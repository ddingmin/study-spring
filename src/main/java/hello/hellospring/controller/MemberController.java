package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    // new를 이용해서 매번 객체를 생성하여 사용할 필요가 없다. -> 스프링 컨테이너에서 이미 관리되고 있기 때문에 통합적으로 사용할 수 있다.

    @Autowired // Autowired는 스프링 컨테이너에 존재하는 memberService를 가져다가 연결을 시켜준다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
