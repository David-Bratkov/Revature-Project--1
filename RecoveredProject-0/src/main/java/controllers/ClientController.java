package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ClientsDAO;
import io.javalin.http.Context;
import models.Client;
import org.apache.log4j.Logger;
import org.eclipse.jetty.util.log.Log;
import services.ClientServices;

import java.util.List;

public class ClientController {
    Logger log = Logger.getLogger(ClientController.class);
    //refences the services
    //put all the http requets and responces
    static ClientServices clientServices = new ClientServices(new ClientsDAO());

    public void getAllClients(Context context) throws JsonProcessingException {
        context.contentType("application/json"); //sending back json data type

        List<Client> clientList = clientServices.getAllClients(); //get all Clients from db

        String jsonString = new ObjectMapper().writeValueAsString(clientList); //we used jackson to convert our list object to a json string

        context.result(jsonString); //send data back

        context.status(200);
    }


    public void getOneClient(Context context) throws JsonProcessingException {
        context.contentType("application/json"); //sending back json

        try {

            Integer clientId = Integer.parseInt(context.pathParam("client_id"));

            Client client = clientServices.getOneClient(clientId);

            if (client.getId() == null) {

                context.status(404);

            }else {

                context.result(new ObjectMapper().writeValueAsString(client));

            }

        }catch (Exception e) {

            log.error(e);
            context.status(404);

        }

    }

    public void createClient(Context context) {

        try {

            String firstname = (context.formParam("firstname"));
            String lastname = (context.formParam("lastname"));

            if (firstname == null || lastname == null) {

                context.result("Invalid input");
                context.status(400);

            }

            Client client = new Client(firstname, lastname);

            if(!(firstname == null || lastname == null)){
                context.result("Client created");
                clientServices.createClient(client);
                context.status(201);
            }

        }catch (Exception e) {

            log.warn(e);
            context.result("Invalid input");

        }

    }

    public void updateAClient(Context context) {

        Integer clientId = Integer.parseInt(context.pathParam("client_id"));

        if (clientServices.getOneClient(clientId) == null) context.status(404);

        try {
            String firstname = (context.formParam("firstname"));
            String lastname = (context.formParam("lastname"));

            clientServices.updateAClient(clientId, firstname, lastname);

            context.result("Updated Client with id " + clientId);

        }catch (Exception e) {

            context.result("Invalid Inputs");
            log.warn(e);

        }

    }

    public void deleteClient(Context context) {
        Integer clientId = Integer.parseInt(context.pathParam("client_id"));

        if (clientServices.getOneClient(clientId) == null) context.status(404);

        else {

            clientServices.deleteClient(clientId);

            context.result("Deleted Client with id " + clientId);

            context.status(205);

        }

    }

}
