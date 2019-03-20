package v1.post;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Data returned from the database
 */
@Entity
@Table(name = "event_by_diogo")
public class EventData {

    public EventData() {
    }

    public EventData(Long id, Long userId, Long tenant, LocalDateTime eventTime, String operation, String userRole, Long identifier, String action, String entity, Long entityId, String sessionId, String details) {
        this.id = id;
        this.userId = userId;
        this.tenant = tenant;
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

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;
    @Column(name = "user_id")
    public Long userId;
    @Column(name = "tenant")
    public Long tenant;
    @Column(name = "event_time")
    public LocalDateTime eventTime;
    @Column(name = "operation")
    public String operation;
    @Column(name = "user_role")
    public String userRole;
    @Column(name = "identifier")
    public Long identifier;
    @Column(name = "action")
    public String action;
    @Column(name = "entity")
    public String entity;
    @Column(name = "entity_id")
    public Long entityId;
    @Column(name = "session_id")
    public String sessionId;
    @Column(name = "details")
    public String details;
}
