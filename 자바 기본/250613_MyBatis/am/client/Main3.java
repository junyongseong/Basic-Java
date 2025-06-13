package am.client;

import am.vo.EmpVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {
    public static void main(String[] args) {
        try {
            // 1) conf.xml과 연결되는 스트림
            Reader r = Resources.getResourceAsReader(
                    "am/config/conf.xml");
            // 2) SqlSessionFactory생성
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);

            // 3) 사용된 스트림 닫기
            r.close();
            //-------------------------한번만 수행하는 부분
            //4) sql문을 호출하기 위해 SqlSession을 factory로부터 얻어낸다.
            SqlSession ss = factory.openSession();
            //List<EmpVO> lsit = ss.selectList("emp.searchDept", 10);

            Map<String,Integer> map = new HashMap<>();
            //map.put("no",null); //no라는 키가 있어도 no에 null이 들어가 있으면
                                // mybatis는 없는것으로 인식한다.
            map.put("no", 10);
            map.put("sal",3000);
            //List<EmpVO> list = ss.selectList("emp.searchDept2",map);

            List<EmpVO> list = ss.selectList("emp.searchDept3",map);



            System.out.println(list.size());
            ss.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
