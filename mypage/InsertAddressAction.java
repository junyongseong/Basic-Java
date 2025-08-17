package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.MyPageDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InsertAddressAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        // 마이페이지 -> 주소록 -> 새 주소 추가 Action
        //ar_mb_idx, ar_addr1, ar_addr2, ar_zip_code, ar_name, ar_phone
        HttpSession session = request.getSession();
        Object ar_mb_idx = session.getAttribute("mb_idx");
        String ar_addr1 = request.getParameter("ar_addr1");
        String ar_addr2 = request.getParameter("ar_addr2");
        String ar_zip_code = request.getParameter("ar_zip_code");
        String ar_name = request.getParameter("ar_name");
        String ar_phone = request.getParameter("ar_phone");

        Map<String, Object> map = new HashMap<>();
        map.put("ar_mb_idx", ar_mb_idx);
        map.put("ar_addr1", ar_addr1);
        map.put("ar_addr2", ar_addr2);
        map.put("ar_zip_code", ar_zip_code);
        map.put("ar_name", ar_name);
        map.put("ar_phone", ar_phone);
        MyPageDAO.add_address(map);

        return "Controller?type=MyAddress";
    }
}
