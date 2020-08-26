package fun.iotgo.entity;

public class DevType {
    private Integer id;

    private String devtypename;

    public DevType(Integer id, String devtypename) {
        this.id = id;
        this.devtypename = devtypename;
    }

    public DevType() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDevtypename() {
        return devtypename;
    }

    public void setDevtypename(String devtypename) {
        this.devtypename = devtypename == null ? null : devtypename.trim();
    }
}