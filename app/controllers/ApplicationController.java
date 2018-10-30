package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ebean.Ebean;
import models.EventTableDo;
import play.db.ebean.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.ApplicationUtil;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ApplicationController extends Controller {

    public Result index() throws SQLException {
        return ok("Hello world");
    }


    @Transactional
    public Result events() {
        List<EventTableDo> eventTableDos = EventTableDo.find.all();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(eventTableDos, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

    @Transactional
    public Result create() {

        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        EventTableDo employee = createEvent(Json.fromJson(json, EventTableDo.class));
        JsonNode jsonObject = Json.toJson(employee);
        Ebean.save(employee);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }


    private EventTableDo createEvent(EventTableDo eventTableDo) {
        EventTableDo e = new EventTableDo();
        e.setTenant(eventTableDo.getTenant());
        e.setUser_id(eventTableDo.getUser_id());
        e.setIdentifier(eventTableDo.getIdentifier());
        e.setEntity_id(e.getEntity_id());
        return e;
    }


}
            
