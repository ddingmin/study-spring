package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 회원이 저장소에 저장
    Optional<Member> findById(Long id); // 저장된 회원의 id 찾아오기
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 모든 회원 리스트를 반환
}
