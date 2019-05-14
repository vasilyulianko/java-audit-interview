package models;


import akka.http.javadsl.model.DateTime;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.format.Formats;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "event_by_dgibilini")
public class Event extends Model {

    @Id
    @GeneratedValue
    public int id;
    public int tenant;
    public int user_id;
//    @Formats.DateTime(pattern = "yyyy-MM-dd hh:mm:ss")
    public String event_time;
    public String operation;
    public String user_role;
    public int identifier;
    public String action;
    public String entity;
    public int entity_id;
    public String session_id;
    public String details;

    public static final Finder<Long, Event> find = new Finder<>(Event.class);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id:");
        sb.append(id);
        sb.append("\ntenant:");
        sb.append(tenant);
        sb.append("\nuser_id:");
        sb.append(user_id);
        sb.append("\nevent_time:");
        sb.append(event_time);
        sb.append("\noperation:");
        sb.append(operation);
        sb.append("\nuser_role:");
        sb.append(user_role);
        sb.append("\nidentifier:");
        sb.append(identifier);
        sb.append("\naction:");
        sb.append(action);
        sb.append("\nentity:");
        sb.append(entity);
        sb.append("\nentity_id:");
        sb.append(entity_id);
        sb.append("\nsession_id:");
        sb.append(session_id);
        sb.append("\ndetails:");
        sb.append(details);
        return sb.toString();
    }

}
