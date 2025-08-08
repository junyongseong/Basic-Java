package editor.dao;

import mybatis.service.FactoryService;
import mybatis.vo.MembersVO;
import mybatis.vo.MemoVO;
import org.apache.ibatis.session.SqlSession;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MembersDAO {

    // 하나의 싱글턴 패턴으로 사용하고자 해서 만든 로직
    // 하나의 인스턴스만 만들고 계속 재사용하는 방식
    private static MembersDAO instance = new MembersDAO();

    private MembersDAO() {
        // 생성자 private 으로 막기
    }

    public static MembersDAO getInstance() {
        return instance;
    }

    public static int add(String mb_name, String mb_id, String mb_pw,
                          String mb_gender, String mb_email, String mb_phone, String mb_birth, String ip,
                          String ar_addr1, String ar_addr2, String ar_zip_code, String ar_name, String ar_phone, String join_type) {
        int cnt = 0;
        SqlSession ss = FactoryService.getFactory().openSession();

        try {
            // 1. 회원정보 insert
            Map<String, Object> memberMap = new HashMap<>();
            memberMap.put("mb_name", mb_name);
            memberMap.put("mb_id", mb_id);
            memberMap.put("mb_pwd", mb_pw);
            memberMap.put("mb_gender", mb_gender);
            memberMap.put("mb_email", mb_email);
            memberMap.put("mb_phone", mb_phone);
            memberMap.put("mb_birth", mb_birth);
            memberMap.put("join_type", join_type);


            int result = ss.insert("members.membersjoin", memberMap);
            if (result == 0) throw new Exception("회원정보 입력 실패");

            // 2. 주소정보 insert (mb_idx 활용)
            Map<String, Object> addressMap = new HashMap<>();
            addressMap.put("ar_mb_idx", memberMap.get("mb_idx")); // selectKey로 채워짐
            addressMap.put("ar_addr1", ar_addr1);
            addressMap.put("ar_addr2", ar_addr2);
            addressMap.put("ar_zip_code", ar_zip_code);
            addressMap.put("ar_phone", ar_phone);
            addressMap.put("ar_name", ar_name);

            int addrResult = ss.insert("members.insertAddress", addressMap);
            if (addrResult == 0) throw new Exception("주소정보 입력 실패");

            ss.commit();
            cnt = 1;
        } catch (Exception e) {
            ss.rollback();
            cnt = 0;
            e.printStackTrace();
        } finally {
            ss.close();
        }
        return cnt;
    }



    // 검색용 메서드
    public static List<MembersVO> searchMembers(String searchType, String keyword) {
        SqlSession ss = null;
        List<MembersVO> list = null;
        try {
            ss = FactoryService.getFactory().openSession();
            Map<String, String> params = new HashMap<>();
            params.put("type", searchType);
            if(searchType.equals("mb_idx")){
                params.put("keyword", keyword);
            }else params.put("keyword", "%" + keyword + "%");
            list = ss.selectList("members.search", params);
        } finally {
            if (ss != null) {
                ss.close();
            }
        }
        return list;
    }

    public static int insertMember(Map<String, String> map) {
        SqlSession ss = FactoryService.getFactory().openSession();
        int result =ss.insert("members.insert", map);
        ss.commit();
        ss.close();
        return result;
    }

    public static boolean isDuplicateId(String mb_id) {
        SqlSession ss = FactoryService.getFactory().openSession();
        Integer result = ss.selectOne("members.checkDuplicateId", mb_id);
        System.out.println("조회"+result);
        ss.close();
        //결과 유효성 검사
        return result != null && result > 0;
    }

    public static boolean isDuplicateEmail(String mb_email) {
        SqlSession ss = FactoryService.getFactory().openSession();
        Integer result = ss.selectOne("members.checkDuplicateEmail", mb_email);
        ss.close();
        return result != null && result > 0;
    }

    // id 유효성 검사
    public boolean isIdExist(String mb_id) {
        // 결과를 저장할 boolean 변수를 false로 초기화합니다.
        boolean result = false;

        // MyBatis의 SqlSession 객체를 가져옵니다. 이 객체는 데이터베이스와의 연결을 담당합니다.
        SqlSession ss = FactoryService.getFactory().openSession();

        try {
            // ss.selectOne() 메서드를 사용하여 데이터베이스 쿼리를 실행합니다.
            // "members.isIdExist"는 MyBatis 매퍼 파일에 정의된 쿼리의 ID입니다.
            // mb_id를 파라미터로 넘겨 해당 아이디가 존재하는지 조회합니다.
            // 조회 결과가 null이 아니면(즉, 아이디가 존재하면) result를 true로 설정합니다.
            result = (ss.selectOne("members.isIdExist", mb_id) != null);
        } finally {
            // try-catch 블록이 끝날 때마다 SqlSession 객체를 닫아 데이터베이스 연결 자원을 해제합니다.
            ss.close();
        }

        // 최종 결과를 반환합니다.
        return result;
    }

    // 회원가입
    public MembersVO checkLogin(String mb_id, String mb_pwd) {
        SqlSession ss = FactoryService.getFactory().openSession();
        MembersVO vo = null;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("mb_id", mb_id);
            map.put("mb_pwd", mb_pwd);
            vo = ss.selectOne("members.checkLogin", map);
        } finally {
            ss.close();
        }
        return vo;
    }

    // 페이징된 회원 리스트 조회
    public static List<MembersVO> selectPagedMembers(int start, int pageSize) {
        SqlSession ss = FactoryService.getFactory().openSession();

        Map<String, Integer> param = new HashMap<>();
        param.put("start", start);
        param.put("pageSize", pageSize);

        List<MembersVO> list = ss.selectList("members.selectPagedMembers", param);
        ss.close();
        return list;
    }

    //페이지 처리를 위해 멤버수 체크
    public static int countAllMembers() {
        SqlSession ss = FactoryService.getFactory().openSession();
        int count = ss.selectOne("members.countAllMembers");
        ss.close();
        return count;
    }

    //검색했을때 페이지 처리를 위한 쿼리임
    public static List<MembersVO> searchPagedMembers(String searchType, String keyword, int start, int pageSize) {
        SqlSession ss = FactoryService.getFactory().openSession();
        List<MembersVO> list;

        try {
            Map<String, Object> param = new HashMap<>();
            param.put("type", searchType);
            param.put("keyword", "%" + keyword + "%");
            param.put("start", start);
            param.put("pageSize", pageSize);

            list = ss.selectList("members.searchPagedMembers", param);
        } finally {
            ss.close();
        }

        return list;
    }

    //검색했을때 검색결과의 인원수 체크용 쿼리
    public static int countSearchedMembers(String searchType, String keyword) {
        SqlSession ss = FactoryService.getFactory().openSession();
        int count;

        try {
            Map<String, Object> param = new HashMap<>();
            param.put("type", searchType);
            param.put("keyword", "%" + keyword + "%");

            count = ss.selectOne("members.countSearchedMembers", param);
        } finally {
            ss.close();
        }

        return count;
    }

//    멤버 관리(수정)창 위한 쿼리임 랭크와 상태만 수정 하려고 함
public static int updateRankAndStatus(String mb_idx, String mb_rank, String mb_status) {
    SqlSession ss = null;
    int result = 0;

    try {
        ss = FactoryService.getFactory().openSession();
        Map<String, String> map = new HashMap<>();
        map.put("mb_idx", mb_idx);
        map.put("mb_rank", mb_rank);
        map.put("mb_status", mb_status);

        result = ss.update("members.updateRankAndStatus", map);
        ss.commit();
    } finally {
        if (ss != null)
            ss.close();
    }

    return result;
}


    public static void deleteMembers(String[] ids){

        SqlSession ss=null;
        try {
            ss=FactoryService.getFactory().openSession();
            ss.update("members.deleteMembers", Arrays.asList(ids));
            ss.commit();
        }finally {
            if (ss !=null)
                ss.close();
        }
    }

//    그 뭐냐 메모삽이ㅂ임
    public static void insertMemo(MemoVO vo) {
        SqlSession ss = null;
        try {
            ss = FactoryService.getFactory().openSession();
            ss.insert("members.insertMemo", vo);
            ss.commit();
        } finally {
            if (ss != null)
                ss.close();
        }
    }
    public static MembersVO getMember(String mb_id) {
        SqlSession ss = null;
        MembersVO vo = null;
        try {
            ss = FactoryService.getFactory().openSession();
            Map<String, Object> param = new HashMap<>();
            param.put("type", "mb_name");
            param.put("keyword", mb_id);
            vo = ss.selectOne("members.search", param);
            System.out.println("<UNK>"+vo.getMb_id());
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (ss != null)
                ss.close();
        }
        return vo;
    }

    // mb_status 값으로 정지/탈퇴 회원 목록 페이징 조회 status 값도 넘김
    public static List<MembersVO> getBlockedMembers(String mb_status, int start, int pageSize) {
        SqlSession ss = FactoryService.getFactory().openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("mb_status", mb_status);
        map.put("start", start);
        map.put("pageSize", pageSize);
        List<MembersVO> list = ss.selectList("ban.getBlockedMembers", map);
        ss.close();
        return list;
    }

    // 정지 및 탈퇴 회원 검색 + 페이징처리
    public static List<MembersVO> searchBlockedMembers(String searchType,
             String searchKeyword, String mb_status, int start, int pageSize) {
        SqlSession ss = FactoryService.getFactory().openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("searchType", searchType);
        map.put("searchKeyword", "%" + searchKeyword + "%");
        map.put("mb_status", mb_status);
        map.put("start", start);
        map.put("pageSize", pageSize);
        List<MembersVO> list = ss.selectList("ban.searchBlockedMembers", map);
        ss.close();
        return list;
    }

    // 정지 및 탈퇴 회원 총 수 카운팅 페이징 처리를 위해 필요
    public static int countBlockedMembers(String searchType,
                                          String searchKeyword, String mb_status) {
        SqlSession ss = FactoryService.getFactory().openSession();
        Map<String, Object> map = new HashMap<>();
        map.put("searchType", searchType);
        map.put("searchKeyword", "%" + searchKeyword + "%");
        map.put("mb_status", mb_status);
        int cnt = ss.selectOne("ban.countBlockedMembers", map);
        ss.close();
        return cnt;
    }

    // 정지 및 탈퇴 회원 검색 결과 수 검색후 페이징 처리 위해 필요
    //staust값도 포함해서 넘김
    public static int countBlockedMembersTotal(String mb_status) {
        SqlSession ss = FactoryService.getFactory().openSession();
        int cnt = ss.selectOne("ban.countBlockedMembersTotal", mb_status);
        ss.close();
        return cnt;
    }

    //총 인원수
    public static int countByStatus(Map<String, Object> map) {
        SqlSession ss = FactoryService.getFactory().openSession();
        int count = ss.selectOne("ban.countByStatus", map);
        ss.close();
        return count;
    }

}
