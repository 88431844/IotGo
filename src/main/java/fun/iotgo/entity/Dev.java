package fun.iotgo.entity;

public class Dev {
    private Integer id;

    private String devname;

    private Integer devtype;

    private String devdes;

    private String devtopic;

    public Dev(Integer id, String devname, Integer devtype, String devdes, String devtopic) {
        this.id = id;
        this.devname = devname;
        this.devtype = devtype;
        this.devdes = devdes;
        this.devtopic = devtopic;
    }

    public Dev() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname == null ? null : devname.trim();
    }

    public Integer getDevtype() {
        return devtype;
    }

    public void setDevtype(Integer devtype) {
        this.devtype = devtype;
    }

    public String getDevdes() {
        return devdes;
    }

    public void setDevdes(String devdes) {
        this.devdes = devdes == null ? null : devdes.trim();
    }

    public String getDevtopic() {
        return devtopic;
    }

    public void setDevtopic(String devtopic) {
        this.devtopic = devtopic == null ? null : devtopic.trim();
    }
}