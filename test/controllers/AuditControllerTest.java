package controllers;

import controllers.AuditController;
import model.AuditLog;
import model.AuditRepository;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import play.Application;

import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;


import static org.junit.Assert.*;
import static play.test.Helpers.*;




public class AuditControllerTest {


	private final String pushUrl="localhost:9000/audit";

//	@Mock
//	private AuditRepository daoMock;
//
//
//	@Mock
//	private HttpExecutionContext ec;
//
//	@InjectMocks
//	private AuditController auditController;


	@Before
	public void before() throws Exception {
//		MockitoAnnotations.initMocks(this);
	}

	@After
	public void after() throws Exception {
	}

	/**
	 * Method: addAudit(final Http.Request request)
	 */

//	@Test
//	public void testIndex() {
//
//
//		try {
//			final Result index = auditController.index();
//
//			System.out.println("index" + index.status());
//			assertEquals(OK, index.status());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}



	@Test
	public void testPut() {


		final Application app = fakeApplication(inMemoryDatabase("test"));


		running(app,()->{
			Http.RequestBuilder request = Helpers.fakeRequest().method("GET").uri("audits");

			Result result = route(app,request);
					assertEquals(NOT_FOUND,result.status());
		});

	}




} 
