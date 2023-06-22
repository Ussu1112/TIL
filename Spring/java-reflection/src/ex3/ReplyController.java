package ex3;

@Controller
public class ReplyController {
    @RequestMapping(uri = "/reply/write")
    public void write(){
        System.out.println("write 호출됨");
    }
}
