package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "event_by_user_maire")
public class Event extends Model {

    @Id
    @Constraints.Min(11)
    private Long id;

    public Long tenant;

    public Long user_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    @Formats.DateTime(pattern="dd/MM/yyyy hh:mm:ss")
    public Date event_time = new Date();

    public String operation;

    public String user_role;

    public Long identifier;

    public String action;

    public String entity;

    public Long entity_id;

    public String session_id;

    @Lob
    public String details;

    public static Finder<Long, Event> find = new Finder<Long,Event>(Event.class);

    public Long getTenant() {
    	return tenant;
    }

    public Long getId() {
    	return id;
    }

    public Date getEvent_time() {
    	return event_time;
    }
}


