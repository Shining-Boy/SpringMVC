<%@ page import="hello.servlet.domain.member.MemberRepository" %> 
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% 
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> memberList = memberRepository.findall();
%>
<html>
    <head>
        <meta charset=" UTF-8">
    </head>

    <body>
        <%
            for(Member member : memberList){
        %>
                <ul>
                    <li>id=<%=member.getId()%></li>
                    <li>username=<%=member.getUsername()%></li>
                    <li>age=<%=member.getAge()%></li>
                </ul>
        <%
            }
        %>
        <a href="/index.html">메인</a>
    </body>

</html>