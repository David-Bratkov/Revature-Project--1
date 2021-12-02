package dao;

import models.Account;
import models.Client;

import java.util.List;

public interface ClientsDAOInterface {
    List<Client> getAllClients();
    Client getOneClient(Integer clientId);
    void createClient(Client client);
    void updateAClient(Integer clientId, String firstname, String lastname);
    void deleteClient(Integer clientId);
}
