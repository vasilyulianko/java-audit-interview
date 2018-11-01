package controllers;

import service.EventService;
import service.EventServiceImpl;
import play.mvc.*;
import javax.inject.Inject;
import java.sql.SQLException;


public class WriteRequestController extends Controller{


    EventService service;


    @Inject
    public WriteRequestController(EventServiceImpl service) {
        this.service = service;
    }


    public Result writeRequest() throws SQLException {

        service.writeRequest(request().body().asJson());
        return ok("Writing on DB  ");
    }
}
