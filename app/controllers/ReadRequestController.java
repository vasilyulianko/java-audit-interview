package controllers;

import service.EventService;
import service.EventServiceImpl;
import model.EventModel;
import play.libs.Json;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.List;

public class ReadRequestController extends Controller {


    EventService service;

    @Singleton
    @Inject
    public ReadRequestController(EventServiceImpl service) {
        this.service = service;
    }

    public Result getEvents() throws SQLException {

        List<EventModel> events = service.readRequest();
        return ok(Json.toJson(events));

    }
}

