package mybatis.dao;

import jsonEx.output.DataVO;
import jsonEx.output.MemberVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Component
@Repository //이게 DAO에서 쓰는거 성능은 똑같은데 실무에서
public class EmpDAO {

        @Autowired
        private SqlSessionTemplate ss;

        public List<MemberVO> selectAll() {
        return ss.selectList("emp.read");
        }

}
