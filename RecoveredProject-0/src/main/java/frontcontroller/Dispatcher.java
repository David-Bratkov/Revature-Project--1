package frontcontroller;

import controllers.AccountController;
import controllers.ClientController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {

    ClientController clientController = new ClientController();
    AccountController accountController = new AccountController();

    public Dispatcher(Javalin app) { //dispatcher waits until it receives an HTTP request

        app.routes(() -> {
            path("clients", () -> {
                //:: is the method reference operator
                get(clientController::getAllClients); //will get all the clients from the database
                post(clientController::createClient); //will put a client in the database
                path("{client_id}", () -> {
                    get(clientController::getOneClient); //will get one client from the database
                    put(clientController::updateAClient); //will modify a single client from the database
                    delete(clientController::deleteClient); //will remove a client and all connected accounts from the database
                    path("accounts", () -> {
                       get(accountController::getAllAccounts); //will get all accounts linked to that client id number
                       post(accountController::createAccount); //will make a new account for that client
                            path("{account_id}", () -> {
                               get(accountController::getOneAccount); //will get a specific account for that client
                               put(accountController::updateAccount); //will modify a single account for that client
                               patch(accountController::modifyAccount); //will deal with depositing and withdrawing a client that the client has
                               delete(accountController::deleteAccount); //will remove that specific account for the client
                               path("transfer", () -> {
                                   path("{deposit_account}", () -> {
                                       patch(accountController::transferAccountMoney); //will be dealing with transfering money between accounts for the client
                                   });
                                });
                            });
                    });
                });
            });

        });
    }


}



