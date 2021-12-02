package services;

import dao.AccountsDAO;
import models.Account;

import java.util.List;

//check for balance here
//transfer you can call other methods

public class AccountServices {
    AccountsDAO accountDAO;

    public AccountServices(AccountsDAO accountsDAO) {this.accountDAO = accountsDAO;}

    public boolean createAccount(Account account) {
        accountDAO.createAccount(account);
        return true;
    }

    public List<Account> getAllAccounts(Integer clientId) {return accountDAO.getAllAccounts(clientId);}

    public List<Account> getSpecificAccounts(Integer clientId, Double amount1, Double amount2) {return accountDAO.getSpecificAccounts(clientId, amount1, amount2);}

    public Account getOneAccount(Integer accountId) {return accountDAO.getOneAccount(accountId);}

    public Integer updateAccount(Integer accountId, Double balance, Double update) {

        if (update == -1.3) accountDAO.updateAccount(accountId, balance);

        Account testaccount = getOneAccount(accountId);

        if (update == -1.2 && testaccount.getBal() < balance) return 422;

        if (testaccount.getBal() > balance && update == -1.2) accountDAO.updateAccount(accountId, (testaccount.getBal() - balance));

        if (update == -1.1) accountDAO.updateAccount(accountId, (testaccount.getBal() + balance));

        return 200;

    }

    public void deleteAccount(Integer accountId) {accountDAO.deleteAccount(accountId);}

    public Integer transferMoney(Integer accountId1, Integer accountId2, Double amount) {

        Account account1 = accountDAO.getOneAccount(accountId1);
        Account account2 = accountDAO.getOneAccount(accountId2);

        if (account1.getBal() < amount) return 422;

        accountDAO.updateAccount(accountId1, (account1.getBal() - amount));
        accountDAO.updateAccount(accountId2, (account2.getBal() + amount));

        return 200;

    }
}
