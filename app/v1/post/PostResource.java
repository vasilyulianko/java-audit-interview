package v1.post;

import java.time.LocalDateTime;

/**
 * Resource for the API.  This is a presentation class for frontend work.
 */

//TODO User Lombok to reduce the boilerplate. User builder design pattern
// and create a DTO
public class PostResource {

    public Long id;
    public Long userId;
    public String tenant;
    public LocalDateTime eventTtime;
    public String operation;
    public String userRole;
    public Integer identifier;
    public String action;
    public String entity;
    public Integer entityId;
    public String sessionId;
    public String details;

    public PostResource(final Long id){
        this.id = id;

    }

    public PostResource(Long id, Long userId, String tenant, LocalDateTime eventTtime,
                        String operation, String userRole,
                        Integer identifier, String action, String entity, Integer entityId,
                        String sessionId, String details) {
        this.id = id;
        this.userId = userId;
        this.tenant = tenant;
        this.eventTtime = eventTtime;
        this.operation = operation;
        this.userRole = userRole;
        this.identifier = identifier;
        this.action = action;
        this.entity = entity;
        this.entityId = entityId;
        this.sessionId = sessionId;
        this.details = details;
    }

    //TODO create specific Constructors.


    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTenant() {
        return tenant;
    }

    public LocalDateTime getEventTtime() {
        return eventTtime;
    }

    public String getOperation() {
        return operation;
    }

    public String getUserRole() {
        return userRole;
    }

    public Integer getIdentifier() {
        return identifier;
    }

    public String getAction() {
        return action;
    }

    public String getEntity() {
        return entity;
    }

    public Integer getEntityId() {
        return entityId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getDetails() {
        return details;
    }
}
