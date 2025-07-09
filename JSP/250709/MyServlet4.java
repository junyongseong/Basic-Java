package com.example.ex_0709;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MyServlet4")
public class MyServlet4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 요청 및 응답 한글 처리
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 파라미터 수신
        String id = request.getParameter("m_id");
        String name = request.getParameter("m_name");
        String[] phoneParts = request.getParameterValues("m_phone");
        String fullPhone = String.join("-", phoneParts); // 예: 010-1234-5678
        String[] hobbies = request.getParameterValues("hobby");

        // 응답 출력
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<ul>");
        out.printf("<li>ID: %s</li>%n", id != null ? id : "미입력");
        out.printf("<li>Name: %s</li>%n", name != null ? name : "미입력");
        out.printf("<li>Phone: %s</li>%n",fullPhone);

        // 취미 출력 (null 체크)
        if (hobbies != null && hobbies.length > 0) {
            out.print("<li>Hobby: ");
            for (int i = 0; i < hobbies.length; i++) {
                out.print(hobbies[i]);
                if (i < hobbies.length - 1) out.print(", ");
            }
            out.println("</li>");
        } else {
            out.println("<li>Hobby: 없음</li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }
}
