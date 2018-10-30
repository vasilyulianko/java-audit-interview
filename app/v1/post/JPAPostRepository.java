package v1.post;

import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Singleton
public class JPAPostRepository implements PostRepository {

    private final JPAApi jpaApi;
    private final PostExecutionContext ec;

    @Inject
    public JPAPostRepository(JPAApi api, PostExecutionContext ec) {
        this.jpaApi = api;
        this.ec = ec;
    }

    @Override
    public CompletionStage<Stream<EventByUser>> list() {
        return supplyAsync(() -> wrap(em -> select(em)), ec);
    }

    private <T> T wrap(Function<EntityManager, T> function) {
        return jpaApi.withTransaction(function);
    }

    private Stream<EventByUser> select(EntityManager em) {
        TypedQuery<EventByUser> query = em.createQuery("SELECT p FROM EventByUser p", EventByUser.class);
        return query.getResultList().stream();
    }
}
