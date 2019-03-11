package model;

import model.AuditLog;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* AuditLog Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 11, 2019</pre> 
* @version 1.0 
*/ 
public class AuditLogTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getId() 
* 
*/ 
@Test
public void generateSampleAudit() throws Exception {

	AuditLog auditLog = new AuditLog();
	auditLog.setId(new Long(1));
	auditLog.setAction("new");



} 



} 
