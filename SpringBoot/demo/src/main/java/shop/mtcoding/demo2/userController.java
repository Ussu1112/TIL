package shop.mtcoding.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //Component 스캔 (shop.mtcoding.demo2)
public class userController {

    public userController(Dog dog) {
        System.out.println("userController 생성자 호출");
        System.out.println(dog.getName()+ "를 호출");
    }

    @ResponseBody
    @GetMapping(produces = {"text/html"}, path = "/login")
    public String login(){
        return "<h1>login</h1>";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm"; // viewResolver 발동 (/resources/main/templates/ + joinForm + .mustache )
    }

    @ResponseBody
    @GetMapping("/userInfo")
    public User userInfo(){
        User user = new User(1,"ssar", "ssar@naver.com");
        return user; //MessageConverter 발동 (오브젝트 리턴시에는 getter를 호출해서 json으로 변환한 뒤 application/json MIME Type 응답)
    }

    @ResponseBody
    @GetMapping("/error1/{num}")
    public String error1(@PathVariable int num){
        if (num == 1)
            return "error1";
        else
            throw new RuntimeException("error1 에서 오류");

    }

    @ResponseBody
    @GetMapping("/error2/{num}")
    public String error2(@PathVariable int num){
        if (num == 1)
            return "error2";
        else
            throw new RuntimeException("error2 에서 오류");

    }
}
