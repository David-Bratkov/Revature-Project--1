package services;

import dao.AccountsDAO;
import dao.ClientsDAO;
import models.Account;
import models.Client;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientServicesTest {

    ClientsDAO clientsDAO = Mockito.mock(ClientsDAO.class);

    ClientServices clientServices;

    public ClientServicesTest(){this.clientServices = new ClientServices(clientsDAO);}

    @Test
    void getAllClients() {

        //arrange
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(12, "test1", "last1"));
        List<Client> expectedValue = clientList;
        Mockito.when(clientServices.getAllClients()).thenReturn(clientList);

        //act
        List<Client> actualResult = clientServices.getAllClients();

        //assert
        assertEquals(expectedValue,actualResult);

    }

    @Test
    void getOneClient() {//fails because client servives does not return anything

        //arrange
        Client expectedValue = new Client(10, "revature10", "demo10");
        Client actualResult = new Client();
        //Client expectedValue = Mockito.when(clientServices.getOneClient(12)).thenReturn(client);

        //act
        Mockito.when(clientServices.getOneClient(10)).thenReturn(actualResult);

        //assert
        assertEquals(expectedValue,actualResult);

    }

    @Test
    void createClient() {
    }

    @Test
    void updateAClient() {
    }

    @Test
    void deleteClient() {
    }
}