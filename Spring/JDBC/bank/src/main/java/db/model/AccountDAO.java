package db.model;

import lombok.Getter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class AccountDAO {
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    // Insert
    public Account createAccount(int accountNumber, String accountPassword, int accountBalance) throws SQLException {
        String query = "INSERT INTO account_tb (account_number, account_password, account_balance, account_created_at) VALUES (?, ?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, accountNumber);
            statement.setString(2, accountPassword);
            statement.setInt(3, accountBalance);
            int rowCount = statement.executeUpdate();
            if(rowCount > 0){
                return getAccountByNumber(accountNumber);
            }
        }
        return null;
    }

    public Account getAccountByNumber(int accountNumber) throws SQLException {
        String query = "SELECT * FROM account_tb WHERE account_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountNumber);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return buildAccountFromResultSet(resultSet);
                }
            }
        }
        return null; // Account not found
    }

    public List<Account> getAccountList() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM account_tb";
        try (Statement statement = connection.createStatement()) {
            try(ResultSet resultSet = statement.executeQuery(query)){
                while (resultSet.next()) {
                    Account account = buildAccountFromResultSet(resultSet);
                    accounts.add(account);
                }
            }
        }
        return accounts;
    }



    public Account updateAccount(int accountBalance, int accountNumber) throws SQLException {
        String query = "update account_tb set account_balance = ? where account_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountBalance);
            statement.setInt(2, accountNumber);

            int rowCount = statement.executeUpdate();
            if (rowCount > 0) {
                return getAccountByNumber(accountNumber);
            }
        }
        return null;

    }

    public void deleteAccount(int accountNumber) throws SQLException {
        String query = "DELETE FROM account_tb WHERE account_number = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, accountNumber);
            statement.executeUpdate();
        }
    }

    private Account buildAccountFromResultSet(ResultSet resultSet) throws SQLException {
        int accountNumber = resultSet.getInt("account_number");
        String accountPassword = resultSet.getString("account_password");
        int accountBalance = resultSet.getInt("account_balance");
        Timestamp accountCreatedAt = resultSet.getTimestamp("account_created_at");

        return Account.builder()
                .accountNumber(accountNumber)
                .accountPassword(accountPassword)
                .accountBalance(accountBalance)
                .accountCreatedAt(accountCreatedAt)
                .build();
    }
}
