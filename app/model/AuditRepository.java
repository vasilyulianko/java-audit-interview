package model;

import com.google.inject.ImplementedBy;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * Created by johnstamp on 11/03/2019.
 *
 * @author John Stamp
 */
@ImplementedBy(JPAAuditRepository.class)
public interface AuditRepository {
	CompletionStage<AuditLog> add(AuditLog audit);

	CompletionStage<Stream<AuditLog>> list();
}
