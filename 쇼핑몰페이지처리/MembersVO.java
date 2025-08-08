package mybatis.vo;

public class MembersVO {
    private String mb_idx, mb_name, mb_id, mb_pwd, mb_gender, mb_email, mb_phone, mb_rank, mb_birth, mb_status, mb_reg_date, join_type;

//   용준 : 벤목록 가져오려고 여기다가 만듬 쿼리에서 조인해서 밴 목록도 가져올거임
    private String ban_reason,ban_start, ban_end;

    public String getBan_reason() {
        return ban_reason;
    }

    public void setBan_reason(String ban_reason) {
        this.ban_reason = ban_reason;
    }

    public String getBan_start() {
        return ban_start;
    }

    public void setBan_start(String ban_start) {
        this.ban_start = ban_start;
    }

    public String getBan_end() {
        return ban_end;
    }

    public void setBan_end(String ban_end) {
        this.ban_end = ban_end;
    }

    public String getJoin_type() {
        return join_type;
    }

    public void setJoin_type(String join_type) {
        this.join_type = join_type;
    }

    public String getMb_idx() {
        return mb_idx;
    }

    public void setMb_idx(String mb_idx) {
        this.mb_idx = mb_idx;
    }

    public String getMb_name() {
        return mb_name;
    }

    public void setMb_name(String mb_name) {
        this.mb_name = mb_name;
    }

    public String getMb_id() {
        return mb_id;
    }

    public void setMb_id(String mb_id) {
        this.mb_id = mb_id;
    }

    public String getMb_pwd() {
        return mb_pwd;
    }

    public void setMb_pwd(String mb_pwd) {
        this.mb_pwd = mb_pwd;
    }

    public String getMb_gender() {
        return mb_gender;
    }

    public void setMb_gender(String mb_gender) {
        this.mb_gender = mb_gender;
    }

    public String getMb_email() {
        return mb_email;
    }

    public void setMb_email(String mb_email) {
        this.mb_email = mb_email;
    }

    public String getMb_phone() {
        return mb_phone;
    }

    public void setMb_phone(String mb_phone) {
        this.mb_phone = mb_phone;
    }

    public String getMb_rank() {
        return mb_rank;
    }

    public void setMb_rank(String mb_rank) {
        this.mb_rank = mb_rank;
    }

    public String getMb_birth() {
        return mb_birth;
    }

    public void setMb_birth(String mb_birth) {
        this.mb_birth = mb_birth;
    }

    public String getMb_status() {
        return mb_status;
    }

    public void setMb_status(String mb_status) {
        this.mb_status = mb_status;
    }

    public String getMb_reg_date() {
        return mb_reg_date;
    }

    public void setMb_reg_date(String mb_reg_date) {
        this.mb_reg_date = mb_reg_date;
    }
}
