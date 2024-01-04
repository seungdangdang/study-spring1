// 스프링 빈 직접 등록하기

package study.studyspring1.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.studyspring1.repository.JpaMemberRepository;
import study.studyspring1.repository.MemberRepository;

@Configuration
public class SpringConfig {

    @PersistenceContext
    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JpaMemberRepository(em);
    }
}