package controllers;

import com.google.inject.Inject;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Result;
import repositories.AuditEventRepository;

import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;
import static play.mvc.Results.ok;

public class AuditEventController {


	private final AuditEventRepository auditEventRepository;
	private final HttpExecutionContext ec;

	@Inject
	public AuditEventController(AuditEventRepository auditEventRepository, HttpExecutionContext ec) {
		this.auditEventRepository = auditEventRepository;
		this.ec = ec;
	}

	public CompletionStage<Result> list() {
		return auditEventRepository.list()
				.thenApplyAsync(auditStream -> ok(toJson(auditStream.collect(Collectors.toList()))), ec.current());

	}
}
