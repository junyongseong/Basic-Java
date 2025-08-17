package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.PurchaseListVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class PurchaseListAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //구매 내역
        HttpSession session = request.getSession();
        if (session == null || session.getAttribute("mb_idx") == null) {
            return "/login.jsp"; //로그인이 안된 상태일 때
        }
        Object mb_idx = session.getAttribute("mb_idx");
        List<PurchaseListVO> list = MyPageDAO.purchase_list((String) mb_idx);
        //JSP 표현 위해 request에 저장
        request.setAttribute("list", list);
        return "MyPage/purchaseList.jsp";
    }
}
