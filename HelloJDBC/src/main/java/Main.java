import controllers.ToDoController;
import dao.ToDoDao;
import dao.ToDoDaoImpl;
import frontcontroller.FrontController;
import io.javalin.Javalin;
import models.ToDo;
import services.ToDoService;

public class Main {

    static ToDoService toDoService = new ToDoService(new ToDoDaoImpl());

    public static void main(String[] args) {


        Javalin app = Javalin.create().start(9000);

        new FrontController(app);



    }

}