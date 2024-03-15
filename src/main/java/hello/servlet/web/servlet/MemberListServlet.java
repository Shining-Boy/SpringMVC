package hello.servlet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet{
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> memberList = memberRepository.findall();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n");
        for(Member member : memberList){
            w.write("<ul>\n" + 
            " <li>id="+member.getId()+"</li>\n" +
            " <li>username="+member.getUsername()+"</li>\n" +
            " <li>age="+member.getAge()+"</li>\n" +
            "</ul>\n");
        }
        w.write("<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>");
    }
}
