package shop.mtcoding.demo2;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String error(RuntimeException e){
        System.out.println("MyControllerAdvice 발동");
        return e.getMessage();
    }
}
