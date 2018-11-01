package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.inject.Inject;
import models.AuditEvent;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.AuditEventRepository;

import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

import static play.libs.Json.toJson;

public class AuditEventController extends Controller {


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

	public CompletionStage<Result> create() {
		JsonNode json = request().body().asJson();
		AuditEvent auditEvent = Json.fromJson(json, AuditEvent.class);
		auditEvent.setDetails(auditEvent.toString());
		return auditEventRepository.add(auditEvent).thenApplyAsync(savedResource -> {
			return created(Json.toJson(savedResource));
		}, ec.current());
	}
}
