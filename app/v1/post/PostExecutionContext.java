package v1.post;

import akka.actor.ActorSystem;

import javax.inject.Inject;

/**
 * Custom execution context wired to "post.repository" thread pool
 */
public class PostExecutionContext {

    @Inject
    public PostExecutionContext(ActorSystem actorSystem) {
    }
}
