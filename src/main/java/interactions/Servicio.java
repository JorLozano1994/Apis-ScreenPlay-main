package interactions;

import interactions.delete.Delete;
import interactions.get.Get;
import interactions.post.Post;
import net.serenitybdd.screenplay.Interaction;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class Servicio {

    private Servicio() {
    }
    public static Interaction delete(String url ){
        return instrumented(Delete.class, url);
    }
    public static Interaction get(String url){
        return instrumented(Get.class, url);
    }
    public static Interaction post(String url){
        return instrumented(Post.class, url);
    }


}
