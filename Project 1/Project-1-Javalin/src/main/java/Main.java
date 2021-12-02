import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("/", Location.CLASSPATH);
        }).start(9000);

        app.post("/form-add", context -> {

            Double num1 = Double.parseDouble(context.formParam("add1"));
            Double num2 = Double.parseDouble(context.formParam("add2"));

            context.result("" + (num1 + num2));

        });

        app.post("/form-sub", context -> {

            Double num1 = Double.parseDouble(context.formParam("sub1"));
            Double num2 = Double.parseDouble(context.formParam("sub2"));

            context.result("" + (num1 - num2));

        });

        app.post("/form-mult", context -> {

            Double num1 = Double.parseDouble(context.formParam("mult1"));
            Double num2 = Double.parseDouble(context.formParam("mult2"));

            context.result("" + (num1 * num2));

        });

        app.post("/form-div", context -> {

            Double num1 = Double.parseDouble(context.formParam("div1"));
            Double num2 = Double.parseDouble(context.formParam("div2"));

            context.result("" + (num1 / num2));

        });




    }
}