package editor.action.customer.mypage;

import editor.action.Action;
import editor.dao.CommDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class SubmitReviewAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            HttpSession session = request.getSession();
            Object mb = session.getAttribute("mb_idx");
            String mbIdx = (mb != null) ? String.valueOf(mb) : null;

            String oiIdx = request.getParameter("oi_idx");
            String pdIdx = request.getParameter("pd_idx");
            //평점 받기 위해
            String star = request.getParameter("cm_star");
            String content  = request.getParameter("cm_content");
//          공개 비공개 처리여부
            int visible = (request.getParameter("cm_visible") != null) ? 1 : 0;

            //유효성 검사
            if (mbIdx == null || oiIdx == null || pdIdx == null || star == null) {
                request.setAttribute("msg", "필수 값 누락");
                return "/WEB-INF/error.jsp";
            }

            // 사진 업로드(이건 선택)
            String imgUrl = null;

            try {
                //import javax.servlet.http.Part;
                //서블릿에서 파일업로드 처리를 위한 인터페이스임 파일 업로드 유무 파악용으로 씀
                // Part는 서블릿 3.0 멀티파트 요청에서 파일 한 개를 나타냄.
// 컨트롤러(FrontController) 또는 이 액션이 멀티파트 허용(@MultipartConfig 또는 web.xml)이어야 동작함
                Part part = request.getPart("cm_img_file");

//                파일이 비어있지 않다면 유효성 검사
                if (part != null && part.getSize() > 0) {

                    //업로드 파일명: 현재시각_원본파일명  (경로분리자 제거)
                    String fileName = System.currentTimeMillis() + "_"
                            + java.nio.file.Paths.get(part.getSubmittedFileName()).getFileName();
//                    웹앱 내부 저장 디렉토리임 실제 운영은 외부 디렉토리로 해야함
                    String dir = request.getServletContext().getRealPath("/upload/review");
                    //이코드는 실제 파일이 없으면 생성해줌
                    Files.createDirectories(Paths.get(dir));
                    //최종으로 갈 목적지 경로를 지정해주는 객체
                    Path dest = Paths.get(dir, fileName);

                    //인풋스트림 기존파일 존재 유무 파악후 있으면 덮어씌움
                    try (InputStream in = part.getInputStream()) {
                        java.nio.file.Files.copy(in, dest, StandardCopyOption.REPLACE_EXISTING);
                    }
                    imgUrl = request.getContextPath() + "/upload/review/" + fileName;
                }

            } catch (Exception ignore) {
            }

            Map<String, Object> map = new HashMap<>();
            map.put("cm_member_idx", mbIdx);
            map.put("cm_products_idx", pdIdx);
            map.put("cm_oi_idx", oiIdx);
            map.put("cm_star", Integer.parseInt(star));
            map.put("cm_img_url", imgUrl);
            map.put("cm_content", content);
            map.put("cm_visible", visible);

            // 사진이면 1000, 아니면 500
            boolean hasImage = (imgUrl != null);
            int ok = CommDAO.writeWithPoint(map, hasImage);


            if (ok > 0) {
                // 저장 후: MyReview로 이동 + #tab-list 로 탭 전환
                response.sendRedirect(request.getContextPath() + "/Controller?type=MyReview#tab-list");
                return null;
            } else {
                request.setAttribute("msg", "리뷰 저장 실패(중복 or DB 오류)");
                return "/WEB-INF/error.jsp";
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "서버 오류");
            return "/WEB-INF/error.jsp";
        }
    }
}
