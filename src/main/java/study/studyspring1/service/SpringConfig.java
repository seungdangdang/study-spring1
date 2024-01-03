// 스프링 빈 직접 등록하기

package study.studyspring1.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.studyspring1.repository.MemberRepository;
import study.studyspring1.repository.MemoryMemberRepository;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}