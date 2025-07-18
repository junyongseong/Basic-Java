package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.DeptVO;
import mybatis.vo.EmpVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DeptDAO {
    public static DeptVO[] getAll(){
        SqlSession ss= FactoryService.getFactory().openSession();
        DeptVO[] ar=null;
        List<DeptVO> list= ss.selectList("dept.all");

        if(list !=null &&!list.isEmpty()){
            ar=new DeptVO[list.size()];
            list.toArray(ar);
        }
        ss.close();
        return ar;
    }

}
