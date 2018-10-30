package v1.post;

import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

public interface PostRepository {

    CompletionStage<Stream<v1.post.EventByUser>> list();

}

