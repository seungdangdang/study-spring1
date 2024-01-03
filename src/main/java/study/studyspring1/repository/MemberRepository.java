package study.studyspring1.repository;

import java.util.List;
import java.util.Optional;
import study.studyspring1.domain.Member;

public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장됨

    Optional<Member> findById(Long id); // 저장소에서 id를 찾아냄

    Optional<Member> findByName(String name); // 저장소에서 name을 찾아냄

    List<Member> findAll();
}