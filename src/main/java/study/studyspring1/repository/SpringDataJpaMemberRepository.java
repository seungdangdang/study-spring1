package study.studyspring1.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import study.studyspring1.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);
}