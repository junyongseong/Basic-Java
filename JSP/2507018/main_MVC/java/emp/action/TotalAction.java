package emp.action;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TotalAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //사원목록을 먼저 얻어낸다.
        EmpVO[] ar = EmpDAO.getAll();

        //jsp에서 표현하기 위해 request에 저장한다.
        request.setAttribute("ar",ar);//jsp에서 ar이란 이름을 찾으니 ar로 함

        return "jsp/total.jsp";
    }
}
