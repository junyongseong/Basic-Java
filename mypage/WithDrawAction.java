package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WithDrawAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        //회원 탈퇴
        HttpSession session = request.getSession();
        Object mb_idx = session.getAttribute("mb_idx");

        MyPageDAO.withDraw((String) mb_idx);

        return "/MainPage/body.jsp";
    }
}
