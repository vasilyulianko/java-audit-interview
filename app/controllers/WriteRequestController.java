package controllers;

import java.sql.SQLException;

public class WriteRequestController extends Controller{


    @Inject
    EventService service;

    public Result index() {
        service.writeRequest(request().body);
        return ok("Writing on DB  ");
    }
}
