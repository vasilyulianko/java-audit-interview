package controllers;

import java.sql.SQLException;

public class ReadRequestController extends Controller{

    @Inject
    EventService service;

    public Result index() throws SQLException {
        return ok("Number of request on DB " + service.readRequest().getsize());
    }
}

