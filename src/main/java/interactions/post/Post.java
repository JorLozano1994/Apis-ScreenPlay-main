package interactions.post;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class Post extends RestInteraction {

    private String url;

    public Post(String url) {
        this.url = url;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().relaxedHTTPSValidation()
                .when()
                .post(url);
    }
}
