package shop.mtcoding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    public BoardController() {
        System.out.println("BoardController 생성자 호출");
    }

    @ResponseBody
    @GetMapping("/main")
    public String main(){
        return "<h1>main</h1>";
    }
}
