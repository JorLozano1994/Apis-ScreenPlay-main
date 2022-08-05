package interactions.get;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class Get extends RestInteraction {

    private String url;

    public Get(String url) {
        this.url = url;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().relaxedHTTPSValidation()
                .when()
                .get(url);
    }
}
