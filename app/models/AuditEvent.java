package models;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "event_by_karol")
public class AuditEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private Long tenant;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "event_time", nullable = false)
	private Instant eventTime;

	@Column(nullable = false)
	private String operation;

	@Column(name = "user_role")
	private String userRole;

	private Long identifier;

	// REST request method - GET/PUT/POST....
	private String action;

	// Resource name
	private String entity;

	@Column(name = "entity_id")
	private Long entityId;

	@Column(name = "session_id")
	private String sessionId;

	@Column(columnDefinition = "TEXT")
	private String details;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenant() {
		return tenant;
	}

	public void setTenant(Long tenant) {
		this.tenant = tenant;
	}

	public Instant getEventTime() {
		return eventTime;
	}

	public void setEventTime(Instant eventTime) {
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

	public Long getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Long identifier) {
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

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "AuditEvent{" +
				"id=" + id +
				", tenant=" + tenant +
				", eventTime=" + eventTime +
				", operation='" + operation + '\'' +
				", userRole='" + userRole + '\'' +
				", identifier=" + identifier +
				", action='" + action + '\'' +
				", entity='" + entity + '\'' +
				", entityId=" + entityId +
				", sessionId='" + sessionId + '\'' +
				", details='" + details + '\'' +
				", userId='" + userId + '\'' +
				'}';
	}
}
