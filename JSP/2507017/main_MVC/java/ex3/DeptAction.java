package ex3;

import mybatis.dao.DeptDAO;
import mybatis.vo.DeptVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeptAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response){
        DeptVO[] ar= DeptDAO.getAll();

        request.setAttribute("dept",ar);

        return "ex3/dept.jsp";
    }
}
