package study.studyspring1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import study.studyspring1.service.MemberService;

@Controller
public class MemberController {

    private MemberService memberService;

    @Autowired // 생성자에 Autowired를 쓰면 멤버서비스를 스프링컨테이너에 있는 멤버 서비스를 가져다가 연결을 해줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}