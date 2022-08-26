package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링으로 전환하기
        //Bean을 다 관리해 준다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //메서드 이름으로 등록이 됨으로 메서드의 이름을 적어야 한다.
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member finMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("finMember = " + finMember.getName());


    }
}
