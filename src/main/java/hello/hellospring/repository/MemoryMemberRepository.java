package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 실무에서는 동시성 문제 때문에 concurrent hashmap을 사용한다.
    private static Long sequence = 0L; // id

    @Override
    public Member save(Member member) {
        member.setId(++sequence); // 시퀸스 값 하나 올려서 지정
        store.put(member.getId(), member); // store 저장소에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // Null 값을 방지하기 위해 Optional로 감싸서 반환한다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream() // store을 loop로 돌리는데
                .filter(member -> member.getName().equals(name)) // member.getName()이 name과 같다면 필터링
                .findAny(); // 찾으면 반환(하나 찾아지면 바로 반환), 없다면 Null값을 Optional로 감싸 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 멤버들 모두 반환
    }
}
