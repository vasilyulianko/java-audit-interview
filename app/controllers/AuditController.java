package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class AuditController  extends Controller {

    public Result index(){
        return ok("Hello AUDIT");
    }
}
