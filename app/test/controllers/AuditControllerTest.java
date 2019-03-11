package test.controllers; 

import controllers.AuditController;
import model.AuditLog;
import model.AuditRepository;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Result;
import scala.util.parsing.json.JSONObject;
import static play.mvc.Http.Status.OK;

import java.sql.SQLException;

import static org.junit.Assert.*;


/** 
* AuditController Tester. 
* 
* @author <Authors name> 
* @since <pre>Mar 11, 2019</pre> 
* @version 1.0 
*/ 
public class AuditControllerTest {


	private final String pushUrl="localhost:9000/audit";

	@Mock
	private AuditRepository daoMock;


	@Mock
	private HttpExecutionContext ec;

	@InjectMocks
	private AuditController auditController;


	@Before
	public void before() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: addAudit(final Http.Request request)
	 */

	@Test
	public void testIndex() {


		try {
			final Result index = auditController.index();

			System.out.println("index" + index.status());
			assertEquals(OK, index.status());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	@Test
	public void testPut() {


	}




} 
