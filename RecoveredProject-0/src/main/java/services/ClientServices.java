package services;

import dao.ClientsDAO;
import models.Client;

import java.util.List;

public class ClientServices {
    //business logic
    ClientsDAO clientsDao;

    public ClientServices(ClientsDAO clientsDao) {this.clientsDao = clientsDao;}

    public List<Client> getAllClients(){
        return clientsDao.getAllClients();
    }

    public Client getOneClient(Integer id){
        return clientsDao.getOneClient(id);
    }

    public Boolean createClient(Client client){

        clientsDao.createClient(client);
        return true;
    }

    public void updateAClient(Integer ClientId, String Firstname, String Lastname){
        clientsDao.updateAClient(ClientId, Firstname, Lastname);

    }

    public void deleteClient(Integer ClientId){
        clientsDao.deleteClient(ClientId);
    }

}
