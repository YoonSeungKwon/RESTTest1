package yoon.test.restapi1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yoon.test.restapi1.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberById(Long id);
}
