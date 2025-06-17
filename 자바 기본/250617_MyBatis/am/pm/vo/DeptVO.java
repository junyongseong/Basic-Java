package pm.vo;

public class DeptVO {
    private String deptno,dname,loc_code,city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public locVO getLvo() {
        return lvo;
    }

    public void setLvo(locVO lvo) {
        this.lvo = lvo;
    }

    public String getLoc_code() {
        return loc_code;
    }

    public void setLoc_code(String loc_code) {
        this.loc_code = loc_code;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    private locVO lvo;
}
