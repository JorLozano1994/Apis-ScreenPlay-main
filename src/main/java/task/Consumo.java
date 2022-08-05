package task;

import interactions.Servicio;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Consumo implements Task {

    String metodo, url;


    public Consumo(String metodo, String url) {
        this.metodo = metodo;
        this.url = url;
    }

    public static Consumo elApi(String metodo, String url) {
        return Tasks.instrumented(Consumo.class, metodo, url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (metodo) {
            case "Get":
                actor.attemptsTo(Servicio.get(url));
                break;
            case "Post":
                actor.attemptsTo(Servicio.post(url));
                break;
            case "Delete":
                actor.attemptsTo(Servicio.delete(url));
                break;

        }
    }
}
