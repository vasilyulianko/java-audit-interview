package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by johnstamp on 11/03/2019.
 *
 * @author John Stamp
 */

@Entity(name =	"event_by_john")
public class AuditLog {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "tenant")
	Integer tenant;
	@Column(name = "user_id")
	Integer userId;

//	Date event_time;

	String operation;

	@Column(name = "user_role")
	String userRole;

	Integer identifier;

	String action;
	String entity;
	@Column(name = "entity_id")
	Integer entityId;
	@Column(name = "session_id")
	String sessionId;

	String details;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getTenant() {
		return tenant;
	}

	public void setTenant(Integer tenant) {
		this.tenant = tenant;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
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

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
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

