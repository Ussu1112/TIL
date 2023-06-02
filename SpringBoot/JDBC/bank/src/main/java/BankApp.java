import db.DBConnection;
import db.model.Account;
import db.model.AccountDAO;

import java.sql.Connection;
import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();

        AccountDAO accountDAO = new AccountDAO(connection);
        accountDAO.createAccount(3333, "5678");
        accountDAO.updateAccount(500, 1111);
        accountDAO.deleteAccount(3333);

        Account account = accountDAO.getAccountNumber(2222);
        System.out.println(account.toString());

        List<Account> accountList = accountDAO.getAccountList();
        System.out.println(accountList.toString());
    }
}
