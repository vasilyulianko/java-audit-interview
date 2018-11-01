package dao;


import model.EventModel;
import org.apache.commons.lang3.StringUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * DAO class to manage event table
 * On real apps this class normally will extend from a BaseDAO class with common logic
 */
public class EventDAOImpl extends BaseDAOImpl<EventModel> implements EventDAO {


    @Override
    public String[] getTableDefinition() {
        return new String[]{"id","tenant","user_id","event_time","operation","user_role","identifier","action","entity",
                "entity_id","session_id","details"};
    }



    @Override
    public boolean insert(model.EventModel entity) throws SQLException {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = datasource.getConnection();
            ps = conn.prepareStatement(getSaveQuery());
            int i = 1;
            ps.setInt(i++, entity.getTenant());
            ps.setInt(i++, entity.getUser_id());
            ps.setString(i++, getDate(entity.getEvent_time()));
            ps.setString(i++, entity.getOperation());
            ps.setString(i++, entity.getUser_role());
            ps.setInt(i++, entity.getIdentifier());
            ps.setString(i++, entity.getAction());
            ps.setString(i++, entity.getEntity());
            ps.setInt(i++, entity.getEntity_id());
            ps.setString(i++, entity.getSession_id());
            ps.setString(i++, entity.getDetails());
            ps.executeUpdate();

        } finally {
            close(conn, ps, rs);
        }

        return true;
    }

    private String getDate(java.util.Date event_time) {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(event_time);
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

        if (event_time != null && !"".equals(event_time)) {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(event_time.getTime());
            return gc.getTime();
        }
        return null;
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
