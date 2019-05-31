package controllers;
import com.avaje.ebean.Ebean;
import controllers.ApplicationController;
import models.Event;
import org.junit.Test;

import play.db.Database;
import play.db.Databases;
import play.mvc.Result;
import play.test.WithApplication;

import java.sql.SQLException;

import static org.junit.Assert.*;
import static play.db.Databases.*;
import static play.mvc.Http.Status.OK;

public class ApplicationControllerTest {

    @Test
    public void index() throws SQLException {
        Result result =  new ApplicationController().index();
        assertEquals(OK, result.status());

    }

    @Test(expected = NullPointerException.class)
    public void list() throws SQLException {
        Database db = inMemory();
        Result result =  new ApplicationController().list();

        assertEquals(OK, result.status());

    }



}


