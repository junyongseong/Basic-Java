package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveAddressAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //유저의 주소 삭제 Action
        String ar_idx = request.getParameter("ar_idx");
        MyPageDAO.delete_addr(ar_idx);
       return "Controller?type=MyAddress";
    }
}
