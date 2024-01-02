package study.studyspring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HelloController {

    // GetMapping = 주소창에 /hello가 들어오면 이 메서드를 호출함
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "반갑습니다."); //속성의 이름: data, 속성의 값: hello
        return "hello"; // springboot의 'viewResolver'가 return된 hello를 확인하고 resources -> templates에서 hello.html을 찾아감
    }

    // MVC와 템플릿 엔진을 배우면서
    @GetMapping("hello-mvc")
//    public String helloMvc(@RequestParam(name = "name2", required = true) String name, Model model) { // required 기본값은 true이므로 삭제해도 됨
    public String helloMvc(@RequestParam("name2") String name, Model model) { // 파라미터에서 'name =' 부분을 삭제하였음, 그래도 실행가능
        model.addAttribute("name3", name); // key, value
        return "hello-template";
    } // 이 코드를 실행하기 위해 주소창에는 http://localhost:8080/hello-mvc?name2=블라블라
}