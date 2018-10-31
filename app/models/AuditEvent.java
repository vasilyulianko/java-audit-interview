package models;

import com.avaje.ebean.Model;
import play.data.format.Formats;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "event_by_pedro")
public class AuditEvent extends Model {
    public int id;
    public int tenant;
    public int userId;
    @Formats.DateTime(pattern = "dd/MM/yyyy")
    public Date eventTime;
    public String operation;
    public String userRole;
    public int identifier;
    public String action;
    public String entity;
    public int entityId;
    public String sessionId;
    public String details;

    public AuditEvent() {
    }

    public AuditEvent(int id, int tenant, int userId, Date eventTime, String operation,
                      String userRole, int identifier, String action, String entity, int entityId, String sessionId, String details) {
        this.id = id;
        this.tenant = tenant;
        this.userId = userId;
        this.eventTime = eventTime;
        this.operation = operation;
        this.userRole = userRole;
        this.identifier = identifier;
        this.action = action;
        this.entity = entity;
        this.entityId = entityId;
        this.sessionId = sessionId;
        this.details = details;
    }

    public static Finder<Long, AuditEvent> find = new Finder<Long, AuditEvent>(AuditEvent.class);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTenant() {
        return tenant;
    }

    public void setTenant(int tenant) {
        this.tenant = tenant;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
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

    public int getEntityId() {
        return entityId;
    }

    public void setEntityId(int entityId) {
        this.entityId = entityId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
