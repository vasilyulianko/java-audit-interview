package services;

import java.sql.SQLException;
import java.util.List;
import models.Event;

public class AuditService {

	public List<Event> findAll() throws SQLException {
		return Event.find.all();
	}

	public void create(Event event) throws SQLException {
    	event.save();
	}

}