package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.MembersVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MyPageEditAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //MyPage의 로그인정보 -> 정보 변경 내용들 처리
        HttpSession session = request.getSession();
        Object mb_idx = session.getAttribute("mb_idx");
        int type = Integer.parseInt(request.getParameter("update_type")); //0: 이메일, 1: 비밀번호, 2: 휴대폰번호
        String value = "";
        String viewPath = "";
        switch (type){
            case 0:
                value = request.getParameter("new_mail");
                viewPath = "/MyPage/MyLogin.jsp";
                break;
            case 1:
                value = request.getParameter("new_pwd"); //변경할 new password
                viewPath = "/MyPage/MyLogin.jsp";
                break;
            case 2:
                value = request.getParameter("new_phone");
                viewPath = "/MyPage/MyLogin.jsp";
                break;
            case 3:
                value = request.getParameter("new_name");
                viewPath = "/MyPage/MyProfile.jsp";
                break;
            default:
                break;
        }
        MyPageDAO.update_info((String) mb_idx, type, value);

        // 다시 정보를 불러와서 전달
        List<MembersVO> userInfo = MyPageDAO.myLogin((String) mb_idx);  // DAO에 맞게 작성
        request.setAttribute("user_information", userInfo);

        return viewPath;
    }
}
