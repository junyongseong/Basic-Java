package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;
import mybatis.vo.AddrVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class MyAddressAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //My Page -> 회원의 주소록(배송지) 확인
        HttpSession session = request.getSession();
        Object mb_idx = session.getAttribute("mb_idx");
        List<AddrVO> addrlist = MyPageDAO.addr_list((String) mb_idx);

        request.setAttribute("addrlist", addrlist);

        return "MyPage/MyAddress.jsp";
    }
}
