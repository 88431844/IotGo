package fun.iotgo.entity;

public class User {
    private Integer id;

    private String userloginname;

    private String userpassword;

    private String username;

    private Integer usertel;

    private String userdes;

    public User(Integer id, String userloginname, String userpassword, String username, Integer usertel, String userdes) {
        this.id = id;
        this.userloginname = userloginname;
        this.userpassword = userpassword;
        this.username = username;
        this.usertel = usertel;
        this.userdes = userdes;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserloginname() {
        return userloginname;
    }

    public void setUserloginname(String userloginname) {
        this.userloginname = userloginname == null ? null : userloginname.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUsertel() {
        return usertel;
    }

    public void setUsertel(Integer usertel) {
        this.usertel = usertel;
    }

    public String getUserdes() {
        return userdes;
    }

    public void setUserdes(String userdes) {
        this.userdes = userdes == null ? null : userdes.trim();
    }
}