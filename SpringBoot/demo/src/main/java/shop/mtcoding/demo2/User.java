package shop.mtcoding.demo2;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class User {
    private int id;
    private String username;
    private String email;

    public User() {
        System.out.println("User 디폴트 생성자 호출");
    }

    public User(int id, String username, String email) {
        System.out.println("User 풀 생성자 호출됨");
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        System.out.println("getId() : json으로 변환되기 위해 실행됨");
        return id;
    }

    public String getUsername() {
        System.out.println("getUsername() : json으로 변환되기 위해 실행됨");
        return username;
    }

    public String getEmail() {
        System.out.println("getEmail() : json으로 변환되기 위해 실행됨");
        return email;
    }
}
