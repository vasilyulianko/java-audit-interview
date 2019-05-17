package controllers;

import models.Audit;
import org.joda.time.DateTime;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

import javax.inject.Inject;
import java.util.List;

public class AuditController extends Controller {

    @Inject
    FormFactory formFactory;

    public Result index(){
        List<Audit>  list = Audit.find.all();
        return ok(index.render(list));
    }

    public Result create(){
        Form<Audit> auditForm = formFactory.form(Audit.class);
        return ok(create.render(auditForm));
    }
    public Result save(){

        Form<Audit> auditForm = formFactory.form(Audit.class).bindFromRequest();
        if(auditForm.hasErrors()){
               return badRequest(auditForm.errors().toString());
         }
        Audit audit = auditForm.get();
        audit.setEvent_time(DateTime.now());
        audit.save();
        return redirect(routes.AuditController.index());
       // return ok("SUCCESS");
    }

    public Result getAudit(){

        return ok("Hello AUDIT");
    }
}
