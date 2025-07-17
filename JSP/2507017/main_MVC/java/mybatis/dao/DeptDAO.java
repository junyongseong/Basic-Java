package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.DeptVO;
import mybatis.vo.EmpVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptDAO {
    public static DeptVO[] getAll(){
        DeptVO[] ar=null;
        SqlSession ss = FactoryService.getFactory().openSession();

        List<DeptVO> list = ss.selectList("dept.all");

        if(!list.isEmpty()&& list !=null){
            ar = new DeptVO[list.size()];
            list.toArray(ar);
        }
        ss.close();
        return ar;
    }
}
