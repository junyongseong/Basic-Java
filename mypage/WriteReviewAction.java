package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.PurchaseListVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//용준: action파일 만들고 mypageDoo에 추가 xml건들거
//리뷰 dao or mypage 다오 어디에 넣을까 고민좀 해봐야핳듯
public class WriteReviewAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        //세션먼저 받아옴
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("mb_idx");
        String mbIdx = (obj != null) ? String.valueOf(obj) : null;


        String orIdx = request.getParameter("or_idx");
        String oiIdx = request.getParameter("oi_idx");
        String pdIdx = request.getParameter("pd_idx"); //혹시몰라서 만들어둔거

        //유효성 검사
        if (mbIdx == null || orIdx == null || oiIdx == null) {
            request.setAttribute("msg", "잘못된 접근입니다.");
            //일단 error.jsp로 보냈는데 나중에 로그인 jsp로 보내도 ok
            //대충 주소로 쳤을때 이런식일텐데 이거 action에다가 다 예외처리 해놔야함
            //mbIDx만 확인해도 ok임
            return "/WEB-INF/error.jsp";
        }

        // 내 주문 및 리뷰 기능(아직 없음) 검증겸 상세 가져오기
        PurchaseListVO target = MyPageDAO.selectReviewTarget(mbIdx, oiIdx);
        if (target == null) {
            request.setAttribute("msg", "리뷰를 작성할 수 없는 주문입니다.");
            return "/WEB-INF/error.jsp";
        }

        //타겟 저장
        request.setAttribute("target", target);


        return "/MyPage/MyWriteReview.jsp";
    }
}
