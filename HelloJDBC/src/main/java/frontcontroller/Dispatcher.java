package frontcontroller;


import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.ToDoController;
import io.javalin.Javalin;
import models.ToDo;

/*
 * This is where we are going to route our endpoints to the specific methods
 *
 * */
public class Dispatcher {

    public Dispatcher(Javalin app){
        /*
         * This is where we will route to the correct methods
         * */

        /*
         * REST
         *   - Representational State Transfer
         *   - Architectural standard for HTTP
         *
         * Below is what Restful endpoints look like
         * */
        app.get("/todo", ToDoController::getAllTodos); //get all todos

        app.get("/todo/{id}",ToDoController::getOneTodo); //get one todo

        app.post("/todo",ToDoController::createTodo); // create todo

        app.patch("/todo/{id}", ToDoController::updateTodo); //update todo

        app.delete("/todo/{id}", ToDoController::deleteTodo); //delete todo
    }
}