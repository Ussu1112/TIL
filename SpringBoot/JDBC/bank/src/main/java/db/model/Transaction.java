package db.model;

import java.sql.Timestamp;

public class Transaction {
    private int transactionNumber; //PK
    private int transactionAmount;
    private int transactionWBalance;
    private int transactionDBalance;
    private int transactionWAccountNumber;
    private int transactionDAccountNumber;
    private Timestamp transactionCreatedAt;

    public Transaction(int transactionNumber, int transactionAmount, int transactionWBalance, int transactionDBalance, int transactionWAccountNumber, int transactionDAccountNumber, Timestamp transactionCreatedAt) {
        this.transactionNumber = transactionNumber;
        this.transactionAmount = transactionAmount;
        this.transactionWBalance = transactionWBalance;
        this.transactionDBalance = transactionDBalance;
        this.transactionWAccountNumber = transactionWAccountNumber;
        this.transactionDAccountNumber = transactionDAccountNumber;
        this.transactionCreatedAt = transactionCreatedAt;
    }
}
