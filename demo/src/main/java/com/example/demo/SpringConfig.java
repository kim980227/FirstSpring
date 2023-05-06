package com.example.demo;

import com.example.demo.repository.*;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    //    private DataSource dataSource;
//    private EntityManager em;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired
//    public SpringConfig(EntityManager em) {//DataSource dataSource) {
////        this.dataSource = dataSource;
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//
//        return new JdbcMemberRepository(dataSource); //순수jdbc
//        return new JdbcTemplateRepository(dataSource); //jdbc template
//        return new JpaMemberRepository(em); // jpa (not spring jpa)
//
//    }

}
