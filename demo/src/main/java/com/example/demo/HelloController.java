package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        return "hello";
    }

    //MVC와 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    //API, HTML파일없이 그냥 값을 출력
    @GetMapping("hello-string")
    @ResponseBody// http의 헤더와 바디 부분 중 바디 부분에 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{ // 스태틱으로 만들면 클래스 안에서 클래스를 또 쓸 수 있다.
        private String name;
        // 게터 세터는 필수적으로 구현 해야함.(자바 빈 규약)
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
