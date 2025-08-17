package editor.action.customer.mypage;

import editor.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class CheckCodeAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //메일로 발송된 code 검사
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");

            String inputCode = request.getParameter("code"); // 사용자가 입력한 값
            System.out.println("[CheckCodeAction] code = " + inputCode); // 여기 꼭 찍혀야 함

            HttpSession session = request.getSession();
            String sessionCode = (String) session.getAttribute("authCode"); // 세션에서 꺼낸 값
            System.out.println("[CheckCodeAction] session authCode = " + sessionCode);

            PrintWriter out = response.getWriter();

            String json;
            if (sessionCode != null && sessionCode.trim().equals(inputCode.trim())) {
                json = "{\"result\":\"success\", \"message\":\"이메일 인증 성공\"}";
            } else {
                json = "{\"result\":\"fail\", \"message\":\"인증코드가 일치하지 않습니다.\"}";
            }

            out.write(json);  // out.print() 대신 write()도 가능
            out.flush();
            out.close(); // 꼭 닫아주기!
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; // AJAX니까 뷰 없음
    }
}
