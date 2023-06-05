import db.DBConnection;
import db.model.Account;
import db.model.AccountDAO;
import db.transaction.Transaction;
import db.transaction.TransactionDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();
        AccountDAO accountDAO = new AccountDAO(connection);
        TransactionDAO transactionDAO = new TransactionDAO(connection);

//        accountDAO.createAccount(3333, "5678");
//        accountDAO.updateAccount(500, 1111);
//        accountDAO.deleteAccount(3333);

//        Account account = accountDAO.getAccountNumber(2222);
//        System.out.println(account.toString());
//
//        List<Account> accountList = accountDAO.getAccountList();
//        System.out.println(accountList.toString());

        try {
            // 이체 요청 정보
            String wAccountPassword = "1234";
            int wAccountNumber = 1111;
            int dAccountNumber = 2222;
            int amount = 100;

            // 0원 이체 확인하기 (컨트롤러에서 체크)
            if(amount <= 0){
                System.out.println("[유효성 오류] 0원 이하의 금액을 이체할 수 없습니다");
                return;
            }

            // 동일 계좌 이체 확인하기 (컨트롤러에서 체크)
            if(wAccountNumber == dAccountNumber){
                System.out.println("[유효성 오류] 입출금 계좌가 동일할 수 없습니다");
                return;
            }

            // --------------------------------------------- 트랜잭션 시작
            connection.setAutoCommit(false);

            // 계좌 찾기 (서비스에서 체크)
            Account wAccount = accountDAO.getAccountByNumber(wAccountNumber);
            Account dAccount = accountDAO.getAccountByNumber(dAccountNumber);

            // 계좌 존재 확인 (서비스에서 체크)
            if(wAccount == null){
                throw new RuntimeException("출금 계좌가 존재하지 않습니다");
            }
            if(dAccount == null){
                throw new RuntimeException("입금 계좌가 존재하지 않습니다");
            }
            // 계좌 비밀번호 확인 (서비스에서 체크)
            if(!wAccount.getAccountPassword().equals(wAccountPassword)){
                throw new RuntimeException("출금 계좌의 비밀번호가 올바르지 않습니다");
            }
            // 계좌 잔액 확인 (서비스에서 체크)
            if(wAccount.getAccountBalance() < amount){
                throw new RuntimeException("출금 계좌의 잔액이 부족합니다");
            }

            // 계좌 업데이트 (서비스에서 업데이트)
            int wBalance = wAccount.getAccountBalance() - amount;
            int dBalance = dAccount.getAccountBalance() + amount;
            accountDAO.updateAccount(wBalance, wAccountNumber);
            accountDAO.updateAccount(dBalance, dAccountNumber);

            Transaction transaction = Transaction.builder()
                    .transactionAmount(amount)
                    .transactionWAccountNumber(wAccountNumber)
                    .transactionDAccountNumber(dAccountNumber)
                    .transactionWBalance(900)
                    .transactionDBalance(1100)
                    .build();
            transactionDAO.transfer(transaction);
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
