package hello.servlet.web.frontcontroller.v2.controller;

import java.io.IOException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberListControllerV2 implements ControllerV2{
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws SerialException, IOException {
        List<Member> memberList = memberRepository.findall();
        request.setAttribute("members", memberList);

        return new MyView("/WEB-INF/views/members.jsp");
    }
    
}
