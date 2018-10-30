package v1.post;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Data returned from the database
 */
@Entity
@Table(name = "event_by_user")
public class EventByUser {

    public EventByUser() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;

    @Column(name="user_id")
    public Long userId;

    public String tenant;

    @Column(name="event_time")
    public LocalDateTime eventTtime;

    public String operation;

    @Column(name="user_role")
    public String userRole;

    public Integer identifier;

    public String action;

    public String entity;

    @Column(name="entity_id")
    public Integer entityId;

    @Column(name="session_id")
    public String sessionId;

    @Column(name="details", columnDefinition="TEXT")
    public String details;


}
