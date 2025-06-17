package am.client;

import am.vo.DeptVO;
import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws IOException {
        Reader r = Resources.getResourceAsReader("am/config/conf.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
        r.close();
        //---------------------------------------------------------------------
        SqlSession ss = factory.openSession();
        List<DeptVO> list =ss.selectList("dept.all");
        for (DeptVO vo :list){
            System.out.printf("부서번호 : %s, 부서이름 : %s\r\n",vo.getDeptno(),vo.getDname());
            if(vo.getList() !=null){
                for (EmpVO evo : vo.getList()){
                    System.out.printf("\t -사번: %s, 이름: %s, 직종 : %s, 부서코드 : %s\r\n",
                            evo.getEmpno(),evo.getEname(),evo.getJob(),vo.getLoc_code());
                }
            }
        }//for의 끝

        List<DeptVO> list2 = ss.selectList("dept.all");
        for (DeptVO vo :list2){

        }
        ss.close();
    }
}