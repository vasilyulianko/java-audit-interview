package controllers;

import com.google.inject.Inject;
import models.AuditEvent;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.AuditEventRepository;

import java.sql.SQLException;
import java.time.Instant;
import java.util.UUID;

public class ApplicationController extends Controller {

	private final AuditEventRepository auditEventRepository;

	@Inject
	public ApplicationController(AuditEventRepository auditEventRepository) {
		this.auditEventRepository = auditEventRepository;
	}

	public Result index() throws SQLException {

		AuditEvent auditEvent = new AuditEvent();
		auditEvent.setOperation("GET");
		auditEvent.setAction(request().uri());
		auditEvent.setSessionId(UUID.randomUUID().toString());
		auditEvent.setUserRole("anonymous");
		auditEvent.setEventTime(Instant.now());
		auditEvent.setTenant(111L);
		auditEvent.setDetails("Hello World");
		auditEventRepository.add(auditEvent);

		return ok("Hello world");
	}

}
            
