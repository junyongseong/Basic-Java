package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.ProductsVO;
import mybatis.vo.WishListVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class WishListAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //찜 내역
        HttpSession session = request.getSession();
        Object mb_idx = session.getAttribute("mb_idx");
        List<WishListVO> wishlist = MyPageDAO.wish_list((String) mb_idx);

        //JSP 표현 위해 request에 저장
        request.setAttribute("wishlist", wishlist);
        return "MyPage/wishList.jsp";
    }
}
