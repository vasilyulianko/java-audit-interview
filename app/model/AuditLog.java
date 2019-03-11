package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by johnstamp on 11/03/2019.
 *
 * @author John Stamp
 */

@Entity
public class AuditLog {
	@Id
	@GeneratedValue
	private Long id;

	Integer tenant;
	Integer user_id;

	Date event_time;

	String operation;
	String user_role;

	Integer identifier;

	String action;
	String entity;
	Integer entity_id;
	String session_id;

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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Date getEvent_time() {
		return event_time;
	}

	public void setEvent_time(Date event_time) {
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

	public Integer getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(Integer entity_id) {
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

	@Override
	public String toString() {
		return "AuditLog{" +
				"id=" + id +
				", tenant=" + tenant +
				", user_id=" + user_id +
				", event_time=" + event_time +
				", operation='" + operation + '\'' +
				", user_role='" + user_role + '\'' +
				", identifier=" + identifier +
				", action='" + action + '\'' +
				", entity='" + entity + '\'' +
				", entity_id=" + entity_id +
				", session_id='" + session_id + '\'' +
				", details='" + details + '\'' +
				'}';
	}
}
