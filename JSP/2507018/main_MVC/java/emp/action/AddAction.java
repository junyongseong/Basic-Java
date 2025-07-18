package emp.action;

import mybatis.dao.EmpDAO;
import mybatis.vo.EmpVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddAction implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String viewPath="jsp/add.jsp";

        String method=request.getMethod();
        if(method.equalsIgnoreCase("post")){
            //폼에서 현재 객체로 온경우(뭔갈 입력했단 소리)
            //viewPath를 null로 지정

            String empno=request.getParameter("empno");
            String ename=request.getParameter("ename");
            String job=request.getParameter("job");

            EmpVO vo=new EmpVO();
            vo.setEmpno(empno);
            vo.setEname(ename);
            vo.setJob(job);

            EmpDAO.add(vo);//DB에 저장하는 역할!!!

            viewPath = null; //viewPath가 null이면 index로 감
        }

        return viewPath;
    }
}
