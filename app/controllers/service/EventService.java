package controllers.service;


import model.EventModel;

/**
 * Event interface to manage request access
 */
public interface EventService {

    /**
     * Read all persisted request petitions to the app
     * @return List of events
     */
    public List<EventModel> readRequest();

    /**
     * Method to manage the request and write whatever information is needed on the DB
     * @param request
     */
    public void writeRequest(String request);
}
