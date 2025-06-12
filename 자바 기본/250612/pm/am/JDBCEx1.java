package am;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCEx1 {

   // 이 과정을 myBatis가 도와준다.
   
   public static void main(String[] args) {
    try {
       // 1) 드라이버로딩 
       Class.forName("com.mysql.cj.jdbc.Driver");
       
       // 2) DB연결객체 얻기
       // 이과정 때문에 실무에서 잘 쓰지 않는다.
       Connection con = DriverManager.getConnection(
    		   "jdbc:mysql://localhost:3306/my_db","root", "1111");
       
       // 3 연결객체로 부터 구문객체 얻기 
       PreparedStatement pst = con.prepareStatement("SELECT * FROM emp");
       
       // 4) 구문객체 실행 
       ResultSet rs = pst.executeQuery();
       
       // 5) 받은 결과 처리  ******중요*******
       ArrayList<empVO> list = new ArrayList<empVO>();
       
       while(rs.next()) {
          // 컬럼을 하나씩 얻어낸다.
         String empno = rs.getString("empno"); 
         String ename = rs.getString("ename"); 
         String job = rs.getString("job"); 
         String hiredate = rs.getString("hiredate"); 
         
         // 원하는 객체로 생성한다. ******
         empVO  vo = new empVO();
         vo.setEmpno(empno);
         vo.setEname(ename);
         vo.setHiredate(hiredate);
         vo.setJob(job);
         
         list.add(vo);
       }// while의 끝 
       
       System.out.println(list.size() + "명 검출");
       System.out.println(list.get(0).getEname());
       
       // 6)리소스 닫기
       rs.close();
       pst.close();
       con.close();
      
    } catch (Exception e){
       e.printStackTrace();
    }
   } 
}