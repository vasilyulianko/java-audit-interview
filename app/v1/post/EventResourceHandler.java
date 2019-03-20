package v1.post;

import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;

import javax.inject.Inject;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * Handles presentation of Post resources, which map to JSON.
 */
public class EventResourceHandler {

    private final PostRepository repository;
    private final HttpExecutionContext ec;

    @Inject
    public EventResourceHandler(PostRepository repository, HttpExecutionContext ec) {
        this.repository = repository;
        this.ec = ec;
    }

    public CompletionStage<Stream<EventResource>> find(Http.Request request) {
        return repository.list().thenApplyAsync(postDataStream -> {
            return postDataStream.map(data -> this.mapDataToResource(data));
        }, ec.current());
    }

    public CompletionStage<EventResource> create(Http.Request request, EventResource resource) {
        final EventData data =  mapResourceToData(resource);
        return repository.create(data).thenApplyAsync(savedData -> {
            return this.mapDataToResource(savedData);
        }, ec.current());
    }

    public CompletionStage<Optional<EventResource>> lookup(Http.Request request,String id) {
        return repository.get(Long.parseLong(id)).thenApplyAsync(optionalData -> {
            return optionalData.map(data -> this.mapDataToResource(data));
        }, ec.current());
    }

    private EventData mapResourceToData(EventResource resource) {
        if (resource == null) {
            return null;
        }
        EventData data = new EventData(resource.getId(),
                                    resource.getUserId(),
                                    resource.getTenant(),
                                    resource.getEventTime(),
                                    resource.getOperation(),
                                    resource.getUserRole(),
                                    resource.getIdentifier(),
                                    resource.getAction(),
                                    resource.getEntity(),
                                    resource.getEntityId(),
                                    resource.getSessionId(),
                                    resource.getDetails());
        return data;
    }

    private EventResource mapDataToResource(EventData data) {
        if (data == null) {
            return null;
        }
        EventResource resource = new EventResource(data.id,
                data.userId,
                data.tenant,
                data.eventTime,
                data.operation,
                data.userRole,
                data.identifier,
                data.action,
                data.entity,
                data.entityId,
                data.sessionId,
                data.details);
        return resource;
    }
}
