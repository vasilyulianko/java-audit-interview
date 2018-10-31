package controllers.service;

import com.sun.deploy.net.HttpRequest;


/**
 * Implementation of the EventService interface to hold the logic of the app
 * Read and Write request
 */
public class EventServiceImpl implements EventService{

    @Inject
    EventDAO dao;

    @Override
    public List<EventModel> readRequest() {
        return dao.selectAll();
    }

    @Override
    public void writeRequest(String request) {
        return false;
    }
}
