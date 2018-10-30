package v1.post;

import play.libs.concurrent.HttpExecutionContext;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * Handles presentation of Post resources, which map to JSON.
 */
public class PostResourceHandler {

    private final PostRepository repository;
    private final HttpExecutionContext ec;

    @Inject
    public PostResourceHandler(PostRepository repository, HttpExecutionContext ec) {
        this.repository = repository;
        this.ec = ec;
    }

    public CompletionStage<Stream<v1.post.PostResource>> find() {
        return repository.list().thenApplyAsync(postDataStream -> {
            return postDataStream.map(data -> new PostResource(data.id));
        }, ec.current());
    }
}
