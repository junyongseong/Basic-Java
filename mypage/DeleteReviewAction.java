package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteReviewAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //내 리뷰 삭제
        String cm_idx = request.getParameter("cm_idx");
        MyPageDAO.delete_review(cm_idx);

        return "Controller?type=MyReview";
    }
}
