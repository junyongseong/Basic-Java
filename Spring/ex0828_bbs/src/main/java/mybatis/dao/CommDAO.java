package mybatis.dao;

import mybatis.vo.CommVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommDAO {

    // 톰캣이 구동될 때 이미 생성된 SqlsessionTemplate이
    // 자동으로 ss에 저장되도록 한다(autowire)

    @Autowired
    private SqlSessionTemplate ss;

    // 댓글 저장
    public int add(String writer, String content, String pwd, String ip, String b_idx){

        CommVO cvo = new CommVO();
        cvo.setWriter(writer);
        cvo.setContent(content);
        cvo.setPwd(pwd);
        cvo.setIp(ip);
        cvo.setB_idx(b_idx);

        return ss.insert("comm.commadd", cvo);

    }

}
