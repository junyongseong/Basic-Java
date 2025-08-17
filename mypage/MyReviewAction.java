package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.CommVO;
import mybatis.vo.PurchaseListVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class MyReviewAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //My리뷰 내역
        HttpSession session = request.getSession();
        Object mb_idx = session.getAttribute("mb_idx");

        //용준: 추가 null일수 있으니 안전빵으로 try catch문을 감싸고
        //예외처리 할꺼임

        String mbIdxStr = (mb_idx != null) ? String.valueOf(mb_idx) : null;
        List<CommVO> reviewlist = java.util.Collections.emptyList();
        List<PurchaseListVO> orderlist = java.util.Collections.emptyList();
        List<PurchaseListVO> totallist = java.util.Collections.emptyList();

        try {
            if (mb_idx !=null){
                List<CommVO> r = MyPageDAO.review_list(mbIdxStr);
                List<PurchaseListVO> o = MyPageDAO.poss_review(mbIdxStr);
                List<PurchaseListVO> t = MyPageDAO.purchase_list(mbIdxStr);

                if (r != null)
                    reviewlist = r;
                if (o != null)
                    orderlist = o;
                if (t != null)
                    totallist = t;
            }else{
                //로그인 정보 없을때 jsp는 떠야하니 메세지처리
                request.setAttribute("loginRequired",true);
                return "/WEB-INF/error.jsp";
            }
        } catch (Exception e) {
            //오류 있을때 예외 처리해서 응답 스트림은 안끊기도록 처리 해버림
            e.printStackTrace();
            request.setAttribute("loadError",e.getMessage());
            return "/WEB-INF/error.jsp";

        }

        //JSP 표현 위해 request에 저장
        request.setAttribute("reviewlist", reviewlist);
        request.setAttribute("orderlist", orderlist);
        request.setAttribute("totallist", totallist);

        return "MyPage/MyReview.jsp";
    }
}
