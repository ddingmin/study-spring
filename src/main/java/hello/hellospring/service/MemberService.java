package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        // 외부에서 넣어주도록 변경
        this.memberRepository = memberRepository;
    }
    // 서비스를 만드려면 멤버 저장소가 필요함.

    // TODO: 회원 가입 로직

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }


    private void validateDuplicateMember(Member member) { // 같은 이름을 가진 중복 회원이 있으면 안되는 로직
        //        Optional<Member> result = memberRepository.findByName(member.getName());
//
//        // ifPresent란 값이 있다면 동작함.
//        result.ifPresent(m -> {
//            // 값이 없다면 예외처리
//            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
//        });
        // 위 코드를 줄인 것.
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }
    // 전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
