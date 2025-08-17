package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishRemoveAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //찜 삭제
        String idx = request.getParameter("wi_idx");
        MyPageDAO.delete_wish(idx);

        return "Controller?type=WishList";
    }
}
