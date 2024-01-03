package study.studyspring1.service;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import study.studyspring1.domain.Member;
import study.studyspring1.repository.MemoryMemberRepository;

class MemberServiceTest {

    MemoryMemberRepository meberRepository;
    MemberService memberService;

    @BeforeEach
    private void beforeEach() {
        meberRepository = new MemoryMemberRepository();
        memberService = new MemberService(meberRepository);
    }

    @AfterEach
    private void afterEach() {
        meberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    void 중복_회원_예약() {
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");

        memberService.join(member1);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> memberService.join(member2));

        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}