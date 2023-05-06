package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService; // 생성자 주입 (DI의 세가지 중 하나)
    }

    @GetMapping("/members/new") //GET : 데이터 조회, 단순 뷰를 띄워줄 때도 사용
    public String createForm(){
        return "members/creatMemberForm";
    }

    @PostMapping("/members/new") //POST : 데이터 전달, HTML에 method=POST에서 설정
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/"; // localhost:8080/ 로 redirect
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        System.out.println(model.addAttribute(members));
        //value 객체를 name 이름으로 추가한다. 뷰 코드에서는 name으로 지정한 이름을 통해서 value를 사용한다.
        return "members/memberList";
    }
}
