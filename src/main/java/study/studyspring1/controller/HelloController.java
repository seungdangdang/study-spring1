package study.studyspring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class HelloController {

    // GetMapping = 주소창에 /hello가 들어오면 이 메서드를 호출함
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //속성의 이름: data, 속성의 값: hello
        return "hello"; // return 한 hello ~> hello.html을 찾아감
    }
}