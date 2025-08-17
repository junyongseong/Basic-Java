package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.AddrVO;
import mybatis.vo.CP_policyVO;
import mybatis.vo.CouponVO;
import mybatis.vo.MyCouponVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCouponAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //My Page -> 회원의 쿠폰목록 확인
        HttpSession session = request.getSession();
        String mb_idx = session.getAttribute("mb_idx").toString();
        Map<String,Object> map = new HashMap<>();
        map.put("mb_idx",mb_idx);

        List<MyCouponVO> couponlist = MyPageDAO.coupon_list(map);

        request.setAttribute("couponlist", couponlist);
        return "MyPage/MyCoupon.jsp";
    }
}
