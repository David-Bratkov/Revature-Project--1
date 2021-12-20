package dao;

import models.Client;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO implements ClientsDAOInterface {

    String url;
    String username;
    String password;

    Logger log = Logger.getLogger(ClientsDAO.class);

    public ClientsDAO() {

        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/Project0-Database";
        this.username =  System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public ClientsDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Client> getAllClients() {

        List<Client> clientList = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "Select * FROM client;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                clientList.add(new Client(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        }catch (SQLException e){
            log.error(e);
        }

        log.info("Was successfull returing all clients");

        return clientList;

    }
    @Override
    public Client getOneClient(Integer clientId) {

        Client client = new Client();

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "Select * FROM client WHERE id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                client = (new Client(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        }catch (SQLException e){
            log.error(e);
        }

        return client;

    }
    @Override
    public void createClient(Client client) {

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "INSERT INTO client VALUES (DEFAULT, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, client.getFirstname());
            ps.setString(2, client.getLastname());

            ps.executeUpdate();

        }catch (SQLException e){
            log.error(e);
        }


    }
    @Override
    public void updateAClient(Integer clientId, String firstname, String lastname) {

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "UPDATE client SET first_name = ?, last_name = ? WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setInt(3, clientId);

            ps.executeUpdate();

        }catch (SQLException e){
            log.error(e);
        }

    }
    @Override
    public void deleteClient(Integer clientId) {

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "DELETE FROM client WHERE id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientId);

            ps.executeUpdate();

        }catch (SQLException e){
            log.error(e);
        }
    }
}