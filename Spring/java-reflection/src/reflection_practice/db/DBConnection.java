package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static Connection connection = getInstance();

    public static Connection getConnection() {
        return connection;
    }

    private static Connection getInstance() {
        // h2 연결 정보
        String url = "jdbc:h2:~/mfa;MODE=MYSQL";
        String username = "sa";
        String password = "";

        // JDBC 드라이버 로드
        try {
            Class.forName("org.h2.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("DB와 연결되었습니다!");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
