package controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

import models.Event;
import play.api.db.Database;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import view.html.create;
import view.html.index2;


public class ApplicationController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index() throws SQLException {
        return ok("Hello world");
    }


    public Result list() throws SQLException {

        List<Event> eventList = Event.finder.all();
        return ok(index2.render(eventList));

//        return ok("eventList: " + eventList);
    }

    public Result create() {
        Form<Event> eventForm = formFactory.form(Event.class);
        return ok(create.render(eventForm));

    }

    public Result save() {

        Form<Event> eventForm = formFactory.form(Event.class).bindFromRequest();
        Event event = eventForm.get();
        event.save();

        return redirect(routes.ApplicationController.list());
    }




}
            
