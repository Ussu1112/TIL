package shop.mtcoding.demo2;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Dog {
    private String name = "강아지";

    public Dog() {
        System.out.println("Dog 생성자 호출됨");
    }
}
