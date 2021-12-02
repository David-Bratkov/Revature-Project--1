package dao;

import models.Account;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountsDAO implements AccountsDAOInterface{

    String url;
    String username;
    String password;

    public AccountsDAO() {

        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/Project0-Database";
        this.username =  System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public AccountsDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    Logger log = Logger.getLogger(AccountsDAO.class);

    @Override
    public List<Account> getAllAccounts(Integer clientId){
        List<Account> accountList = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "Select * FROM account;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
            }

        }catch (SQLException e){
            log.error(e);
        }

        return accountList;

    }

    @Override
    public List<Account> getSpecificAccounts(Integer clientId, Double lessthan, Double greaterthan){

        List<Account> accountList = new ArrayList<>();

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "Select * FROM account WHERE client_id = ? AND balance < ? AND balance > ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, clientId);
            ps.setDouble(2, lessthan);
            ps.setDouble(3, greaterthan);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                accountList.add(new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
            }

        }catch (SQLException e){
            log.error(e);
        }

        return accountList;

    }

    @Override
    public Account getOneAccount(Integer accountId) {

        Account account = new Account();

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "Select * FROM account WHERE account_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                account = (new Account(rs.getInt(1), rs.getInt(2), rs.getDouble(3)));
            }

        }catch (SQLException e){
            log.error(e);
        }

        return account;

    }
    @Override
    public void createAccount(Account account) {

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "INSERT INTO account VALUES (DEFAULT, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, account.getclientID());
            ps.setDouble(2, account.getBal());

            ps.executeUpdate();

        }catch (SQLException e){
            log.error(e);
        }


    }
    @Override
    public void updateAccount(Integer accountId, Double balance) {

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "UPDATE account SET balance = ? WHERE account_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(2, accountId);
            ps.setDouble(1, balance);

            ps.executeUpdate();

        }catch (SQLException e){
            log.error(e);
        }

    }
    @Override
    public void deleteAccount(Integer accountId) {

        try(Connection conn = DriverManager.getConnection(url, username, password)) {

            String sql = "DELETE FROM account WHERE account_id=?;";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, accountId);

            ps.executeUpdate();

        }catch (SQLException e){
            log.error(e);
        }

    }

}
