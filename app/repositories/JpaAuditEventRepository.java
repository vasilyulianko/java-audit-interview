package repositories;

import models.AuditEvent;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;

public class JpaAuditEventRepository implements AuditEventRepository {

	private final JPAApi jpaApi;
	private final DatabaseExecutionContext executionContext;

	@Inject
	public JpaAuditEventRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
		this.jpaApi = jpaApi;
		this.executionContext = executionContext;
	}

	@Override
	public CompletionStage<AuditEvent> add(AuditEvent auditEvent) {
		return supplyAsync(() -> wrap(em -> insert(em, auditEvent)), executionContext);
	}

	private AuditEvent insert(EntityManager em, AuditEvent auditEvent) {
		em.persist(auditEvent);
		return auditEvent;
	}

	@Override
	public CompletionStage<Stream<AuditEvent>> list() {
		return supplyAsync(() -> wrap(this::list), executionContext);
	}

	private Stream<AuditEvent> list(EntityManager em) {
		return em.createQuery("select a from AuditEvent a", AuditEvent.class).getResultList().stream();
	}

	private <T> T wrap(Function<EntityManager, T> function) {
		return jpaApi.withTransaction(function);
	}
}
