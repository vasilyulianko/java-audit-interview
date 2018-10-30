package models;


import io.ebean.*;
import play.data.validation.Constraints;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event_by_do")
public class EventTableDo extends Model{

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Constraints.Min(0)
    private int tenant;

    @Constraints.Min(0)
    private int user_id;


    private String event_time;

    private String operation;
    private String user_role;

    @Constraints.Min(0)
    private int identifier;
    private String action;
    private String entity;

    @Constraints.Min(0)
    private int entity_id;
    private String session_id;
    private String details;


    public EventTableDo(){
    }


    public EventTableDo(Long id, int tenant, int user_id, String event_time, String operation, String user_role, int identifier, String action, String entity, int entity_id, String session_id, String details) {
        this.id = id;
        this.tenant = tenant;
        this.user_id = user_id;
        this.event_time = event_time;
        this.operation = operation;
        this.user_role = user_role;
        this.identifier = identifier;
        this.action = action;
        this.entity = entity;
        this.entity_id = entity_id;
        this.session_id = session_id;
        this.details = details;
    }

    //Generic query helper for entity EventTableDo with id type Long
    public static Finder<Long,EventTableDo> find = new Finder<>(EventTableDo.class);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTenant() {
        return tenant;
    }

    public void setTenant(int tenant) {
        this.tenant = tenant;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getEvent_time() {
        return event_time;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
