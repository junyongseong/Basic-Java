package pm.client;

import com.mysql.cj.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pm.vo.DeptVO;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main1 {
    public static void main(String[] args) throws IOException {
        Reader r = Resources.getResourceAsReader("pm/config/conf.xml");

        SqlSessionFactory factory =
                new SqlSessionFactoryBuilder().build(r);
        r.close();

        //--------------------------------------
        SqlSession ss = factory.openSession();
        List<DeptVO> list= ss.selectList("dept.all");

        for (DeptVO dvo :list){
            System.out.printf("%s, %s, %s %s",dvo.getDeptno(),dvo.getDname(),dvo.getLvo().getCity());
        }
    }
}
