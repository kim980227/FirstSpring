package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository(); // 다른 db 인스턴스를 사용,
//    실제 서비스와 같은 인스턴스를 사용하는게 좋다 -> 서비스에서 생성자로 repos 만들기
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }// 테스트마다 실행 전 같은 메모리멤버레포즈 사용 가능 (DI)

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() { // 테스트 코드는 걍 한글로 써도 되긴함
        //given (어떤 상황(데이터)이 주어짐)
        Member member = new Member();
        member.setName("hello");

        //when (이걸 실행(기능) 됐을 때)
        Long saveId = memberService.join(member);

        //then (이렇게 되겠지?) => 회원가입을 했을 때 레포지토리에 저장됐겠지?
        Member findMember =memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

//        //when
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다,"); // 이코드가 실행되면 중복검사가 제대로 되지않는다는 뜻
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
            // then중복검사가 제대로 실행되어 이미 존재하는 회원입니다. 라는 메시지를 띄우고 있는지를 확인
        }


    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}