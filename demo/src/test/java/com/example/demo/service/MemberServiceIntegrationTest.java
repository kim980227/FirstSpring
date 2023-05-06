package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() { // 테스트 코드는 걍 한글로 써도 되긴함
        //given (어떤 상황(데이터)이 주어짐)
        Member member = new Member();
        member.setName("spring6");

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