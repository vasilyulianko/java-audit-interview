package service;


import com.fasterxml.jackson.databind.JsonNode;
import model.EventModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Event interface to manage request access
 */
public interface EventService {

    /**
     * Read all persisted request petitions to the app
     * @return List of events
     */
    public List<EventModel> readRequest() throws SQLException;

    /**
     * Method to manage the request and write whatever information is needed on the DB
     * @param request
     */
    public void writeRequest(JsonNode request) throws SQLException ;
}
