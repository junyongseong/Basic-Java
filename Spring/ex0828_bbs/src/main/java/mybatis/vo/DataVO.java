package mybatis.vo;

import org.springframework.web.multipart.MultipartFile;

public class DataVO {

    // 폼에 명시된 각 파라미터의 이름과 같은 변수들을 멤버로 선언해야 한다.
    private String title, writer, content, ip, bname;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    private MultipartFile file;

    // 저장할 테이블에 파일명을 저장하는 컬럼이 있다면 같은 이름으로 정의하자
    private String file_name, ori_name;

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getOri_name() {
        return ori_name;
    }

    public void setOri_name(String ori_name) {
        this.ori_name = ori_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
