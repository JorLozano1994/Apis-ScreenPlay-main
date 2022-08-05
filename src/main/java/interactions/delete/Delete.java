package interactions.delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

public class Delete extends RestInteraction {

    private String url;
    public Delete(String url ){
        this.url = url;

    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().relaxedHTTPSValidation()
                .when()
                .delete(url);
    }
}
