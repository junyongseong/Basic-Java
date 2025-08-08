package editor.action.admin;

import editor.action.Action;
import editor.dao.MembersDAO;
import mybatis.vo.MembersVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeletedMemberManageAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        // 페이징 처리
        int page = 1;
        String pageParam = request.getParameter("page");
        if (pageParam != null && pageParam.matches("\\d+")) {
            page = Integer.parseInt(pageParam);
        }

        int pageSize = 10;
        int start = (page - 1) * pageSize;

        String searchType = request.getParameter("searchType");
        String searchKeyword = request.getParameter("searchKeyword");

//        status값도 넘겨줘야함
        String mb_status = request.getParameter("mb_status");
        if (mb_status == null || mb_status.trim().isEmpty()) {
            mb_status = "all"; // 기본값 설정
        }

        if ("mb_rank".equals(searchType)) {
            if ("브론즈".equals(searchKeyword)) searchKeyword = "0";
            else if ("실버".equals(searchKeyword)) searchKeyword = "1";
            else if ("골드".equals(searchKeyword)) searchKeyword = "2";
        }

        List<MembersVO> list;
        int totalCount;

        if (searchType != null && searchKeyword != null && !searchKeyword.trim().isEmpty()) {
            list = MembersDAO.searchBlockedMembers(searchType, searchKeyword, mb_status, start, pageSize);
            totalCount = MembersDAO.countBlockedMembers(searchType, searchKeyword, mb_status);
        } else {
            list = MembersDAO.getBlockedMembers(mb_status, start, pageSize);
            totalCount = MembersDAO.countBlockedMembersTotal(mb_status);
        }

        //jsp에 보내기전에 저장
        request.setAttribute("memberlist", list);
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        request.setAttribute("searchType", searchType);
        request.setAttribute("searchKeyword", searchKeyword);
        request.setAttribute("mb_status", "all");

        //템플릿도 같이 반환
        request.setAttribute("contentPage", "/admin/DeletedMember_manage_content.jsp");
        return "/template/Admin_template.jsp";
    }
}
