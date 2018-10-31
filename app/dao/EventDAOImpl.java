package dao;

import model.BaseModel;
import model.EventModel;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

/**
 * DAO class to manage event table
 * On real apps this class normally will extend from a BaseDAO class with common logic
 */
public class EventDAOImpl<EventModel> extends BaseDAOImpl implements EventDAO {


    @Override
    public String[] getTableDefinition() {
        return new String[]{"id","tenant","user_id","event_time","operation","user_role","identifier","action","entity",
                "entity_id","session_id","details"};
    }



    @Override
    public boolean insert(EventModel eventModel) throws SQLException {
        return false;
    }

    @Override
    public void populate(ResultSet rs, EventModel eventModel) throws SQLException {
        super.populate(rs, eventModel);
        eventModel.setTenant(rs.getInt("tenant"));
        eventModel.setUser_id(rs.getInt("user_id"));
        eventModel.setEvent_time(getDate(rs.getDate("event_time")));
        eventModel.setOperation(rs.getString("operation"));
        eventModel.setUser_role(rs.getString("user_role"));
        eventModel.setIdentifier(rs.getInt("identifier"));
        eventModel.setAction(rs.getString("action"));
        eventModel.setEntity(rs.getString("entity"));
        eventModel.setEntity_id(rs.getInt("entity_id"));
        eventModel.setSession_id(rs.getString("session_id"));
        eventModel.setDetails(rs.getString("details"));
    }

    private java.util.Date getDate(Date event_time) {

        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(event_time.getTime());
        return gc.getTime();
    }

    @Override
    public String getTableName() {
        return "event_by_natalia";
    }

    @Override
    public EventModel getEntityInstance() {
        return new EventModel();
    }


}
