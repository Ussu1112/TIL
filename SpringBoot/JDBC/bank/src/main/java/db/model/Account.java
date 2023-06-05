package db.model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Account {
    private int accountNumber; // PK
    private String accountPassword;
    private int accountBalance;
    private Timestamp accountCreatedAt;

    @Builder
    public Account(int accountNumber, String accountPassword, int accountBalance, Timestamp accountCreatedAt) {
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.accountBalance = accountBalance;
        this.accountCreatedAt = accountCreatedAt;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountPassword='" + accountPassword + '\'' +
                ", accountBalance=" + accountBalance +
                ", accountCreatedAt=" + accountCreatedAt +
                '}';
    }
}
