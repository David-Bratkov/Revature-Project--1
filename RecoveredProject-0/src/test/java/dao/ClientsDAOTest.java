package dao;

import models.Account;
import models.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import util.H2UtilClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClientsDAOTest {

    ClientsDAO clientsDAO;

    public ClientsDAOTest() {
        this.clientsDAO = new ClientsDAO(H2UtilClient.url, H2UtilClient.username, H2UtilClient.password);
    }

    @BeforeEach
    void setUp() {
        H2UtilClient.createTable();
    }

    @AfterEach
    void tearDown() {
        H2UtilClient.dropTable();
    }

    @Test
    void getAllClients() {
        //arrange
        /*
        List<Client> expectedResult = new ArrayList<>();
        expectedResult.add(new Client(12, "first1", "last1"));

        //act
        List<Account> actualResult = accountServices.getSpecificAccounts(10,500d,100d);

        //assert
        assertEquals(expectedValue,actualResult); */
    }

    @Test
    void getOneClient() {
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