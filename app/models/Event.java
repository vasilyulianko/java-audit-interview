package models;

import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="event_by_yuri")
public class Event extends Model{
    @Id
    public Integer id;
    public Integer tenant;
    public Integer user_id;
    public Timestamp event_time;
    public String operation;
    public String user_role;

    public Event() {
    }

    public Event(Integer id, Integer tenant, Integer user_id, Timestamp timestamp, String operation, String user_role) {
        this.id = id;
        this.tenant = tenant;
        this.user_id = user_id;
        this.event_time = timestamp;
        this.operation = operation;
        this.user_role = user_role;
    }

    public static Finder<Integer, Event> finder = new Finder<>(Event.class);


}


