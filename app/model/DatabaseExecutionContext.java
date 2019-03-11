package model;

import akka.actor.ActorSystem;
import play.libs.concurrent.CustomExecutionContext;

import javax.inject.Inject;


/**
 * Created by johnstamp on 11/03/2019.
 *
 * @author John Stamp
 */
public class DatabaseExecutionContext extends CustomExecutionContext {
	@Inject
	public DatabaseExecutionContext(ActorSystem actorSystem) {
		super(actorSystem, "database.dispatcher");
	}
}
