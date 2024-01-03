package study.studyspring1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String helloMvc(@RequestParam("name") String name2, Model model) {
        model.addAttribute("name3", name2); // key, value
        return "hello-template";
    } // 이 코드를 실행하기 위해 주소창에는 http://localhost:8080/hello-mvc?name2=블라블라

    // API를 배우면서(1) - 단순 문자를 요구할 때 쓰며 쓸일은 거의 없음, html없이 문자그대로 내려가는 방식
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name2) {
        return "hello" + name2;
    }

    // API 배우면서(2) - 문자가 아닌 데이터를 요구할 떄
    @GetMapping("hello-api")
    @ResponseBody // defalut 반환 json 방식
    public Hello helloApi(@RequestParam("name") String name2) {
        Hello hello = new Hello();
        hello.setName(name2);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}