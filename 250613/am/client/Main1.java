package am.client;

import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class Main1 {
    public static void main(String[] args) {
        try {
            // 1) conf.xml과 연결되는 스트림
            Reader r = Resources.getResourceAsReader(
                    "am/config/conf.xml");
            // 2) SqlSessrionFactory생성
            SqlSessionFactory factory =
                    new SqlSessionFactoryBuilder().build(r);
            // 3) 사용된 스트림 닫기
            r.close();
            //------------------한번만 수행하는 부분------------------
            //emp테이블에 저장하기 위해 객체를 준비
            //왜 EmpVo일까? 호출하고자 하는 SQL문이 emp.add라는 mapper다.
            //emp.add의 parameterType이 EmpVO이기 때문이다.
            EmpVO vo= new EmpVO();
            vo.setEmpno("1101");
            vo.setEname("창조리");
            vo.setJob("DeVelop");
            vo.setHiredate("2025-06-13");

            // 4) sql문을 호출하기 위해 SqlSession을 factory로부터 얻어낸다.
            SqlSession ss = factory.openSession();
            int cnt = ss.insert("emp.add",vo);
            // System.out.println(cnt); 1이 찍힘
            if(cnt>0) {
                ss.commit();//작업된 내용을 DB에 적용
                System.out.println("저장완료");
            }else {
                ss.rollback();//작업취소
                System.out.println("저장실패");
            }ss.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
