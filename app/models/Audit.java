package models;


import com.avaje.ebean.Model;
import org.joda.time.DateTime;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name = "auditlucas")
public class Audit extends Model {

    @Id
    private Integer id;
    @Constraints.Required
    private int tenant ;
    @Constraints.Required
    private int user_id;

    private DateTime event_time;
    @Constraints.Required
    private String operation;
    @Constraints.Required
    private String user_role;
    @Constraints.Required
    private int identifier ;
    @Constraints.Required
    private String action ;
    @Constraints.MaxLength(65535)
    private String details;

    public static Finder<Integer, Audit> find = new Finder<>(Audit.class);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public DateTime getEvent_time() {
        return event_time;
    }

    public void setEvent_time(DateTime event_time) {
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public static Finder<Integer, Audit> getFind() {
        return find;
    }

    public static void setFind(Finder<Integer, Audit> find) {
        Audit.find = find;
    }
}
