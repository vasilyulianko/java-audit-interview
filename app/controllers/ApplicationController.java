package controllers;

import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;

import com.avaje.ebean.annotation.Transactional;
import models.AuditEvent;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.*;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

public class ApplicationController extends Controller {

    @Transactional
    public Result create() throws SQLException {
        JsonNode json = request().body().asJson();
        final AuditEvent auditEvent = Json.fromJson(json, AuditEvent.class);
        auditEvent.save();
        return ok("");
    }

    public Result list() throws SQLException {
        List<AuditEvent> auditEventList = AuditEvent.find.all();
        return ok(play.libs.Json.toJson(auditEventList));
    }

}
            
