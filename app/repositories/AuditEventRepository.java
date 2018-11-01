package repositories;

import com.google.inject.ImplementedBy;
import models.AuditEvent;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;


@ImplementedBy(JpaAuditEventRepository.class)
public interface AuditEventRepository {

	CompletionStage<AuditEvent> add(AuditEvent auditEvent);

	CompletionStage<Stream<AuditEvent>> list();

}

