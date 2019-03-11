package model;

import play.db.jpa.JPAApi;


import javax.inject.Inject;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.stream.Stream;
import javax.persistence.EntityManager;

/**
 * Created by johnstamp on 11/03/2019.
 *
 * @author John Stamp
 */


import static java.util.concurrent.CompletableFuture.supplyAsync;

public class JPAAuditRepository implements AuditRepository {

	private final JPAApi jpaApi;
	private final DatabaseExecutionContext executionContext;



	@Inject
	public JPAAuditRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
		this.jpaApi = jpaApi;
		this.executionContext = executionContext;
	}




	@Override
	public CompletionStage<AuditLog> add(AuditLog auditLog) {
		return supplyAsync(() -> wrap(em -> insert(em, auditLog)), executionContext);
	}


	private AuditLog insert(EntityManager em, AuditLog auditLog) {
		em.persist(auditLog);
		return auditLog;
	}
	@Override
	public CompletionStage<Stream<AuditLog>> list() {
		return null;
	}

	private <T> T wrap(Function<EntityManager, T> function) {
		return jpaApi.withTransaction(function);
	}

}
