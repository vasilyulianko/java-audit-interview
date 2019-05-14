package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Event;
import play.mvc.Controller;
import play.mvc.Result;

import java.sql.SQLException;
import java.time.Instant;
import java.util.List;

public class ApplicationController extends Controller {

    public Result index() throws SQLException {
        Event event = new Event();
        event.tenant = Integer.parseInt(request().getQueryString("tenant"));
        event.user_id = Integer.parseInt(request().getQueryString("user"));
        event.operation = request().method();
        event.event_time = Instant.now().toString();
        event.action = request().path();
        event.save();
        return ok("Hello world: " + event.id);
    }

    public Result write() {
        JsonNode json = request().body().asJson();
        Event event = new Event();
        event.tenant = json.get("tenant").asInt();
        event.user_id = json.get("user_id").asInt();
        event.event_time = json.get("event_time").asText();
        event.operation = json.get("operation").asText();
        event.user_role = json.get("user_role").asText();
        event.identifier = json.get("identifier").asInt();
        event.action = json.get("action").asText();
        event.entity = json.get("entity").asText();
        event.entity_id = json.get("entity_id").asInt();
        event.session_id = json.get("session_id").asText();
        event.details = json.get("details").asText();
        event.save();
        return ok(event.toString());
    }

    public Result events() {
        List<Event> events = Event.find.query().orderBy().desc("id").findList();
        StringBuilder response = new StringBuilder();
        for (Event event : events) {
            response.append("\n___________________________________________________________________________\n");
            response.append(event);
        }
        response.append("\n___________________________________________________________________________\n");
        return ok(response.toString());
    }

}
            
