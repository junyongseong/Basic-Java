package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.MembersVO;
import mybatis.vo.MyCouponVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyPageAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //my profile 정보들 모두 전달
        //mb_idx, mb_name, mb_id, mb_pwd, mb_gender, mb_email, mb_phone, mb_rank, mb_birth, mb_status, mb_reg_date
        //회원번호, 회원 이름, 아이디, 비밀번호, 성별, 이메일, 휴대폰번호, 등급, 생일, 탈퇴상태, 가입일
        HttpSession session = request.getSession();
        Object mb_idx = session.getAttribute("mb_idx");
        List<MembersVO> user_information = MyPageDAO.myLogin((String) mb_idx);
        String target = request.getParameter("target");

        //JSP 표현 위해 request에 저장
        request.setAttribute("user_information", user_information);
        if ("MyLogin".equals(target)) {
            return "MyPage/MyLogin.jsp";

        } else if ("MyProfile".equals(target)) {
            return "MyPage/MyProfile.jsp"; // 이 JSP 내용만 Ajax로 응답 보냄

        } else if("MyPage".equals(target)){
            Map<String,Object> map = new HashMap<>();
            map.put("mb_idx",mb_idx);

            List<MyCouponVO> couponlist = MyPageDAO.coupon_list(map);
            int count = couponlist.size();
            request.setAttribute("count", count);
            return "MyPage/MyPage.jsp";

        } else {
            return "Login/Login.jsp";
        }
    }
}
