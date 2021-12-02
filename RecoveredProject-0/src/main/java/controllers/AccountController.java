package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.AccountsDAO;
import dao.ClientsDAO;
import io.javalin.http.Context;
import models.Account;
import org.apache.log4j.Logger;
import services.AccountServices;
import services.ClientServices;

import java.util.List;

public class AccountController {
    Logger log = Logger.getLogger(AccountController.class);
    //refences the services
    //put all the http requets and responces
    static AccountServices accountServices = new AccountServices(new AccountsDAO());
    static ClientServices clientServices = new ClientServices(new ClientsDAO());

    public void getAllAccounts(Context context) throws JsonProcessingException {

        context.contentType("application/json"); //sending back json data type

        Integer clientId = Integer.parseInt(context.pathParam("client_id"));

        List<Account> accountList = accountServices.getAllAccounts(clientId); //get all Clients from db

        String jsonString = new ObjectMapper().writeValueAsString(accountList); //we used jackson to convert our list object to a json string

        context.result(jsonString); //send data back

        context.status(200);
    }


    public void getOneAccount(Context context) throws JsonProcessingException {
        context.contentType("application/json"); //sending back json

        try {

            Integer.parseInt(context.pathParam("client_id"));

            try {

                Integer accountId = Integer.parseInt(context.pathParam("account_id"));

                Account account = accountServices.getOneAccount(accountId);

                if (account.getId() == null) {

                    context.status(404);

                }else {

                    context.result(new ObjectMapper().writeValueAsString(account));

                }

            } catch (Exception e) {

                log.error(e);
                context.status(404);
            }

        } catch (Exception e) {

            log.error(e);
            context.status(404);
        }

    }

    public void createAccount(Context context) {

        try {

            Integer clientId = Integer.parseInt(context.pathParam("client_id"));

            if (clientServices.getOneClient(clientId) == null) {

                context.status(404);
            }else {

                try {

                    Double balance = Double.parseDouble(context.formParam("balance"));

                    Account account = new Account(clientId, balance);

                    context.result("Client created");
                    accountServices.createAccount(account);
                    context.status(201);


                }catch (Exception e) {

                    log.warn(e);
                    context.result("Invalid input");

                }

            }

        } catch (Exception e) {

            log.error(e);
            context.status(404);
        }

    }

    public void updateAccount(Context context) {

        Integer retval = 200;

        try {

            Integer clientId = Integer.parseInt(context.pathParam("client_id"));

            if (clientServices.getOneClient(clientId) == null) {

                context.status(404);
            }else {

                try {
                    Double balance = Double.parseDouble(context.formParam("balance"));

                    retval = accountServices.updateAccount(clientId, balance, -1.3);

                    context.result("Updated Client with id " + clientId);

                }catch (Exception e) {

                    context.result("Invalid Inputs");
                    log.warn(e);

                }

                context.status(retval);

            }

        } catch (Exception e) {

            log.error(e);
            context.status(404);
        }

    }

    public void deleteAccount(Context context) {

        try {

            Integer clientId = Integer.parseInt(context.pathParam("client_id"));

            if (clientServices.getOneClient(clientId).getId() == null) {

                context.status(404);

            }else {

                Integer accountId = Integer.parseInt(context.pathParam("account_id"));

                if (accountServices.getOneAccount(accountId).getId() == null) context.status(404);

                else {

                    accountServices.deleteAccount(accountId);

                    context.result("Deleted Client with id " + accountId);

                    context.status(205);

                }
            }
        } catch (Exception e) {

            log.error(e);
            context.status(404);
        }

    }

    public void modifyAccount(Context context) {

        Integer retval = 200;

        try {

            Integer clientId = Integer.parseInt(context.pathParam("client_id"));
            Integer accountId = Integer.parseInt(context.pathParam("account_id"));

            if (clientServices.getOneClient(clientId).getId() == null) {

                context.status(404);
            }else {

                try {
                    Double withdraw = Double.parseDouble(context.formParam("withdraw"));

                    retval = accountServices.updateAccount(accountId, withdraw, -1.2);

                    context.result("Updated Account with id " + accountId);

                }catch (Exception e) {

                    //context.result("Invalid Inputs");
                    log.warn(e);

                }

                try {
                    Double deposit = Double.parseDouble(context.formParam("deposit"));

                    retval = accountServices.updateAccount(accountId, deposit, -1.1);

                    context.result("Updated Account with id " + accountId);

                }catch (Exception e) {

                    //context.result("Invalid Inputs");
                    log.warn(e);

                }

                context.status(retval);

            }

        } catch (Exception e) {

            log.error(e);
            context.status(404);
        }

    }

    public void transferAccountMoney(Context context) {

        Integer retval = 200;

        try {

            Integer clientId = Integer.parseInt(context.pathParam("client_id"));

            Integer accountId = Integer.parseInt(context.pathParam("account_id"));

            Integer depositId = Integer.parseInt(context.pathParam("deposit_account"));

            if ((clientServices.getOneClient(clientId).getId() == null) && accountServices.getOneAccount(depositId).getId() == null && (accountServices.getOneAccount(accountId).getId() == null)) {

                context.status(404);
            }else {

                try {
                    Double amount = Double.parseDouble(context.formParam("amount"));

                    retval = accountServices.transferMoney(accountId, depositId, amount);

                    context.result("Transferred money to account" + depositId + " from account" + clientId + " Bal:" + amount);

                }catch (Exception e) {

                    context.result("Invalid Inputs");
                    log.warn(e);

                }

                context.status(retval);

            }

        } catch (Exception e) {

            log.error(e);
            context.status(404);
        }

    }

}
