package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 메소드가 끝날 때 마다 실행되는 메소드 -> 테스트가 끝날 때 마다 비워준다.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("ddingmin");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals(member, result); // 기대값, 결과값 (member가 나와야함)
        assertThat(member).isEqualTo(result); // member가 result와 똑같은지 확인
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("ddingmin1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("ddingmin2");
        repository.save(member2);

        Member result = repository.findByName("ddingmin1").get();
        assertThat(result).isEqualTo(member1); // result와 member1이 같은지 확인
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("ddingmin1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("ddingmin2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
