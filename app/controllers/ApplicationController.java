package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.inject.Inject;
import play.api.db.Database;
import play.libs.Json;
import play.mvc.*;
import models.Event;
import services.AuditService;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class ApplicationController extends Controller {

	@Inject
	AuditService auditService;

    public Result index() throws SQLException {
    	List<Event> events = auditService.findAll();
    	JsonNode jsonEvents = Json.toJson(events);
        return ok(jsonEvents);
    }

    public Result audit() throws SQLException {
    	JsonNode json = request().body().asJson();
    	Event event = Json.fromJson(json, Event.class);

    	auditService.create(event);

    	return ok();
	}
    
}
            
