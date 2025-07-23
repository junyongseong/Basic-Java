package bbs.action;

import bba.dao.BbsDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import mybatis.vo.BbsVO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class EditAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String viewPath = null;
        String enc_type = request.getContentType(); // 이땐 null값 찍힘
        System.out.println("enc_type="+enc_type);

        if (enc_type == null) {
            // 수정 폼 요청일 경우
            String b_idx = request.getParameter("b_idx");
            String cPage = request.getParameter("cPage");
//            System.out.println(b_idx);
            BbsVO vo = BbsDAO.getBbs(b_idx);

            request.setAttribute("vo", vo);
            request.setAttribute("cPage", cPage);
            viewPath = "edit.jsp";
        } else if (enc_type.startsWith("multipart")) {
            try {
//                System.out.println("테스트");
                ServletContext application = request.getServletContext();
                String realPath = application.getRealPath("/bbs_upload");

                MultipartRequest mr = new MultipartRequest(
                        request,
                        realPath,
                        1024 * 1024 * 5,
                        "utf-8",
                        new DefaultFileRenamePolicy()
                );

                String title = mr.getParameter("title");
                String writer = mr.getParameter("writer");
                String content = mr.getParameter("content");
                String bname = mr.getParameter("bname");
                String b_idx = mr.getParameter("b_idx");
                String ip = request.getRemoteAddr();
                String cPage = mr.getParameter("cPage");

                File f = mr.getFile("file");
                String fname = null;
                String oname = null;

                if (f != null) {
                    fname = f.getName(); // 현재 저장된 파일명
                    oname = mr.getOriginalFileName("file"); // 원래 파일명
                }

                Map<String, String> map = new HashMap<>();
                map.put("subject", title);
                map.put("writer", writer);
                map.put("content", content);
                map.put("bname", bname);
                map.put("file_name", fname);
                map.put("ori_name", oname);
                map.put("b_idx", b_idx);
                map.put("ip", ip);

                // 실제 수정 쿼리 수행
                BbsDAO.edit(map);
                System.out.println("수정할 제목: " + title);
                System.out.println("수정할 파일명: " + fname);
                System.out.println("수정할 b_idx: " + b_idx);

                // 수정 후에 이동할곳


//                viewPath = "Controller?type=view&b_idx=" + b_idx + "&cPage=" + cPage;
                response.sendRedirect("Controller?type=view&b_idx=" + b_idx + "&cPage=" + cPage);
                return null; // 컨트롤러가 forward 안 하게끔

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return viewPath;
    }
}
