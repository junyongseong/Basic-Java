package mybatis.dao;

import mybatis.vo.EmpVO;
import mybatis.vo.MemVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO {
    private static SqlSessionFactory factory;

    //static 초기화-가장 빠르게 인식되어 1번 움직인다.
    static {
        try {
            Reader r = Resources.getResourceAsReader("mybatis/config/conf.xml");
            factory =new SqlSessionFactoryBuilder().build(r);
            r.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //전체보기 기능
    public static EmpVO[] getAll(){
        EmpVO[] ar = null;
        SqlSession ss =factory.openSession();

        List<EmpVO> list = ss.selectList("emp.all");

        //리스트의 size크기만큼 배열의 크기를 지정하자!
        ar = new EmpVO[list.size()];

        ss.close();
        list.toArray(ar);//list에 있는 모든 요소가 ar에 복사한다.
        return ar;
    }
    //사번 검색기능은 EmpVO 하나만 간다.
    public static EmpVO getEmp(String empno){
        SqlSession ss =factory.openSession();
        EmpVO vo =ss.selectOne("emp.searchempno",empno);
        ss.close();
        return vo;
    }
    public static EmpVO[] search(String searchType,String searchValue){
        EmpVO[] ar = null;
        //받은 인자를 emp.search라는 sQl문에게 전달하기 위해
        //Map구조로 만들어야하낟.
        Map<String,String> map =new HashMap<>();
        map.put("searchType",searchType);
        map.put("searchValue",searchValue);

        SqlSession ss= factory.openSession();
        List<EmpVO> list =ss.selectList("emp.search",map);
        ar=new EmpVO[list.size()];
        //list에있는 모든 데이터를 ar에 복사한다.
        list.toArray(ar);
        return ar;
    }
    //로그인하는 함수
    public static MemVO login(String id,String pw){
        Map<String,String> map = new HashMap<>();
        map.put("id",id);
        map.put("pw",pw);

        SqlSession ss=factory.openSession();
        MemVO mvo =ss.selectOne("mem.login",map);
        ss.close();
        return mvo;

    }
}
