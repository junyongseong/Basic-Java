package am;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisEx2 {

	public static void main(String[] args) throws Exception {
		// 1)환경설정 파일(conf.sml)과 연결된 스트림 생성
		Reader r = Resources.getResourceAsReader(
				"am/config/conf.xml");
				
		// 2) 필요한 것은 sqlSession이지만 이전에 SqlSession을
		// 만들어주는 Factory를 생성해야 한다.
		SqlSessionFactory factory = 
				new SqlSessionFactoryBuilder().build(r);
		
		//3)사용된 스트림 닫기
		r.close();
		//-------------------한번만 수행하는 것-------------------
		
		//4) SQL문장을 모두 호출 및 실행 할 수 있는
		//		sqlSesstion객체를 factory를 통해 얻어낸다.
		SqlSession ss = factory.openSession();
		
		//5) 호출하고자 하는 원하는 SQL문의 id를 인자로 전달하여 수행한다.
		List<empVO> list = ss.selectList("emp.all");
		
		System.out.println(list.size() + "명 검출");
	    System.out.println(list.get(0).getEname());
	}
}
 