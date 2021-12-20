import io.javalin.Javalin;
import models.User;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create().start(900);

        app.post("/api/login", context -> {
           User user = context.bodyAsClass(User.class);


           context.sessionAttribute("user-session", user);
        });



    }

}
