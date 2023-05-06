//package com.example.demo.repository;
//
//import com.example.demo.domain.Member;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.*;
//
//public class MemoryMemberRepositoryTest {
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    @AfterEach // 메소드 실행이 끝날 때마다 실행되는 어노테이션
//    public void afterEach(){
//        repository.clearStore();
//    }
//    @Test
//    public void save(){
//        Member member = new Member();
//        member.setName("Spring");
//        repository.save(member);
//        Member result = repository.findById(member.getId()).get();
//        Assertions.assertEquals(member, result); //member가 result와 같은지 확인
//        assertThat(member).isEqualTo(result);
//    }
//    @Test
//    public void findByName(){
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        Member result = repository.findByName("spring1").get();
//
//        assertThat(result).isEqualTo(member1);
//    }
//    @Test
//    public void findAll(){
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        List<Member> result = repository.findAll();
//
//        assertThat(result.size()).isEqualTo(2);
//    } // 메소드 테스트 중 다른 데이터가 덮어씌여질 수가 있기때문에 잘되던 코드가 통과가 안될수 있다.
//    //=> 테스트가 끝나면 항상 clear해줘야함.
//
//}
//
//
