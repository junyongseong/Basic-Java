package mybatis.dao;

import mybatis.service.FactoryService;
import mybatis.vo.MemoVO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoDAO {
    //MemoList.jsp에서 표현할 메모목록
    public static List<MemoVO> getAll(){
        //DB의 Sql문을 호출하기 위해서는 SqlSession이 있어야한다.
        //그리고 그 SqlSession은 Factory를 통해야 얻을 수 있다.
        SqlSession ss = FactoryService.getFactory().openSession();
        List<MemoVO> list = ss.selectList("memo.all");
        ss.close();
        return list;
    }
    //메모를 저장하는 기능
    public static int addMemo( String writer,
                              String content, String ip){
        //먼저 memo.add를 호출하기 위해 memvo가 필요하니 생성
        //인자로 받은 writer,content, ip를 add라는 mapper로 보내기 위해
        //해당 Mapper의 인자(parameterType)인 Map구조를 준비해야한다.

        Map<String,String> map =new HashMap<>();
        //vo.setIdx(idx);
//        vo.setWriter(writer);
//        vo.setContent(content);
//        vo.setReg_date(reg_date);
        map.put("writer",writer);
        map.put("content",content);
        map.put("ip",ip);

        SqlSession ss= FactoryService.getFactory().openSession();
        int cnt=ss.insert("memo.add",map);
        //유효성 검사 cnt에 값이 들어오면 commit하고 아니면 rollback함
        if (cnt>0)
            ss.commit();
        else
            ss.rollback();

        ss.close();
        return cnt;
    }
}
