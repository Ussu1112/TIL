package db.model;

import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class AccountDAO {
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public Account getAccountByNumber(int accountNumber){
        String query = "select * from account_tb where account_number = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, accountNumber);

            ResultSet rs = statement.executeQuery();

            // 4.mapping (db result -> model)
            if(rs.next()){
                return new Account(
                        rs.getInt("account_number"),
                        rs.getString("account_password"),
                        rs.getInt("account_balance"),
                        rs.getTimestamp("account_created_at")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> getAccountList(){
        String query = "select * from account_tb";
        List<Account> accountList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                // 4.mapping (db result -> model)
                Account account = new Account(
                        rs.getInt("account_number"),
                        rs.getString("account_password"),
                        rs.getInt("account_balance"),
                        rs.getTimestamp("account_created_at")
                );

                accountList.add(account);
            }

            return accountList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public void createAccount(int accountNumber, String accountPassword){
        // 1.sql
        String query = "insert into account_tb values (?, ?, 1000, now())";

        // 2.buffer
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, accountNumber);
            statement.setString(2, accountPassword);
            int result = statement.executeUpdate();
            System.out.println("result : " + result );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3.send
    }

    public void updateAccount(int accountBalance, int accountNumber){
        String query = "update account_tb set account_balance = ? where account_number = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, accountBalance);
            statement.setInt(2, accountNumber);

            int result = statement.executeUpdate();
            System.out.println("result : " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int accountNumber){
        String query = "delete from account_tb where account_number = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, accountNumber);

            int result = statement.executeUpdate();
            System.out.println("result : " + result);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
