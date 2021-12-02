package dao;



import models.Account;

import java.util.List;

public interface AccountsDAOInterface {
    List<Account> getAllAccounts(Integer clientId);
    List<Account> getSpecificAccounts(Integer clientId, Double lessthan, Double greaterthan);
    Account getOneAccount(Integer accountId);
    void createAccount(Account account);
    void updateAccount(Integer accountId, Double balance);
    void deleteAccount(Integer accountId);
}
