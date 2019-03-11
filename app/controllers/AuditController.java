package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.AuditLog;
import model.AuditRepository;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * Created by johnstamp on 11/03/2019.
 *
 * @author John Stamp
 */
public class AuditController extends Controller {



	private final AuditRepository auditRepository;
	private final HttpExecutionContext ec;


	@Inject
	public AuditController( AuditRepository auditRepository, HttpExecutionContext ec) {

		this.auditRepository = auditRepository;
		this.ec = ec;

	}

	public  CompletionStage<Result>  addAudit(final Http.Request request) {

		JsonNode json = request().body().asJson();


		AuditLog audit = Json.fromJson(json, AuditLog.class);

		return auditRepository
				.add(audit)
				.thenApplyAsync(p -> redirect(routes.AuditController.index()), ec.current());
	}


	public Result index() throws SQLException {
		return ok("Hello world audit");
	}


	public CompletionStage<Result> getClasses() {
		return auditRepository
				.list()
				//	.thenApplyAsync(personStream -> ok(toJson(personStream.collect(Collectors.toList()))), ec.current());
				//.thenApplyAsync(classStream -> ok(views.html.listClasses.render(classStream.collect(Collectors.toList()))),ec.current());
			.thenApplyAsync(auditStream -> ok(Json.toJson(auditStream.collect(Collectors.toList()))),ec.current());
	}
}
