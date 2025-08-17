package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MailDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

public class SendMailAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        // 클라이언트로부터 받은 이메일 주소 파라미터 가져오기
        String toEmail = request.getParameter("toEmail");

        // 6자리 인증 코드 생성
        String authCode = String.valueOf((int)(Math.random() * 900000) + 100000);

        // 생성된 인증 코드를 세션에 저장하여 나중에 사용자가 입력한 코드와 비교할 수 있도록 함
        // 세션에 저장할 때는 유효 시간을 설정하는 것이 보안상 좋습니다. (예: 5분)
        HttpSession session = request.getSession();
        session.setAttribute("authCode", authCode);

        try {
            // MailDAO를 사용하여 이메일 전송
            // 이메일 제목과 내용을 정의하여 전송합니다.
            MailDAO.sendMail(toEmail, "크앙 이메일 인증코드입니다", "인증코드: " + authCode + "\n전송된 인증코드를 화면에 입력해주세요.");
            System.out.println("[SendMailAction] 메일 전송 시도 완료."); // 로그 출력

            // AJAX 요청에 대한 JSON 응답 설정

            response.setContentType("application/json;charset=UTF-8"); // 응답 타입을 JSON, 문자셋을 UTF-8로 설정
            // 성공 메시지를 JSON 형식으로 클라이언트에 전송
            try(PrintWriter out = response.getWriter())
            {
                 out.print("{\"result\":\"success\", \"message\":\"메일 전송 완료. 이메일을 확인하세요!\"}");
                 out.flush(); // 버퍼 비우기
                 System.out.println("[SendMailAction] 성공 응답 전송."); // 로그 출력
            }

        } catch (Exception e) {
            // 메일 전송 실패 시 예외 처리
            System.err.println("[SendMailAction] 메일 전송 실패: " + e.getMessage()); // 에러 로그 출력
            e.printStackTrace(); // 스택 트레이스 출력 (디버깅용)

            try {
                // 실패 메시지를 JSON 형식으로 클라이언트에 전송
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter out = response.getWriter();
                out.print("{\"result\":\"fail\", \"message\":\"메일 전송 실패: " + e.getMessage() + "\"}");
                out.flush();
                System.out.println("[SendMailAction] 실패 응답 전송."); // 로그 출력
            } catch (Exception ex) {
                System.err.println("[SendMailAction] 실패 응답 전송 중 추가 오류 발생: " + ex.getMessage()); // 추가 에러 로그
                ex.printStackTrace();
            }
        }

        // AJAX 요청이므로 JSP 페이지로 포워딩하지 않습니다.
        // 클라이언트(JavaScript)에서 JSON 응답을 처리할 것이므로, null을 반환하여 뷰 포워딩을 하지 않도록 합니다.
        return null;
    }
}
