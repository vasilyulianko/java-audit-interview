package service;

import com.fasterxml.jackson.databind.JsonNode;
import dao.EventDAO;
import dao.EventDAOImpl;
import model.EventModel;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.sql.SQLException;
import java.util.List;

import static play.libs.Json.*;


/**
 * Implementation of the EventService interface to hold the logic of the app
 * Read and Write request
 */
public class EventServiceImpl implements EventService{


    EventDAO dao;

    @Singleton
    @Inject
    public EventServiceImpl(EventDAOImpl dao){
        this.dao = dao;
    }

    @Override
    public List<EventModel> readRequest() throws SQLException {
        return dao.selectAll();
    }

    @Override
    public void writeRequest(JsonNode request) throws SQLException  {

        EventModel  model = fromJson(request, EventModel.class);
        dao.insert(model);
    }
}
