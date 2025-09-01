package Spring.input;

import org.springframework.web.multipart.MultipartFile;

public class ImgVO {

    // 반드시 파라미터 이름과 동일한 이름으로 멤버변수 선언
    // jsp 에서 폼 객체에 파일을 파라미터로 저장(upload)로 저장해서 보내줌

    private MultipartFile upload;

    public MultipartFile getUpload() {
        return upload;
    }

    public void setUpload(MultipartFile upload) {
        this.upload = upload;
    }
}
