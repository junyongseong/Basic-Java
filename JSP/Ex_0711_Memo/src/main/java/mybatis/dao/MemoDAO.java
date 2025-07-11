package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.MemoVO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MemoDAO {
    public static List<MemoVO> getAll(){
        SqlSession ss = FactoryService.getFactory().openSession();
        List<MemoVO> list = ss.selectList("memo.all");
        ss.close();
        return list;
    }
    public static int addMemo(String idx, String writer,
                              String content, String reg_date){
        //먼저 memo.add를 호출하기 위해 memvo가 필요하니 생성
        MemoVO vo =new MemoVO();

        vo.setIdx(idx);
        vo.setWriter(writer);
        vo.setContent(content);
        vo.setReg_date(reg_date);

        SqlSession ss= FactoryService.getFactory().openSession();
        int cnt=ss.insert("memo.add",vo);
        //유효성 검사 cnt에 값이 들어오면 commit하고 아니면 rollback함
        if (cnt>0)
            ss.commit();
        else
            ss.rollback();

        ss.close();
        return cnt;
    }
}
