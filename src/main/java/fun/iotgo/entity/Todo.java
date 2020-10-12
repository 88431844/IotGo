package fun.iotgo.entity;

import java.util.Date;

public class Todo {
    private Integer id;

    private String title;

    private String url;

    private Date starttime;

    private Date endtime;

    private Byte iscycle;

    private Date cycletime;

    private Byte isdone;

    private Integer belonglistid;

    private Integer deviceid;

    private Integer ordersum;

    private String content;

    public Todo(Integer id, String title, String url, Date starttime, Date endtime, Byte iscycle, Date cycletime, Byte isdone, Integer belonglistid, Integer deviceid, Integer ordersum) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.starttime = starttime;
        this.endtime = endtime;
        this.iscycle = iscycle;
        this.cycletime = cycletime;
        this.isdone = isdone;
        this.belonglistid = belonglistid;
        this.deviceid = deviceid;
        this.ordersum = ordersum;
    }

    public Todo(Integer id, String title, String url, Date starttime, Date endtime, Byte iscycle, Date cycletime, Byte isdone, Integer belonglistid, Integer deviceid, Integer ordersum, String content) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.starttime = starttime;
        this.endtime = endtime;
        this.iscycle = iscycle;
        this.cycletime = cycletime;
        this.isdone = isdone;
        this.belonglistid = belonglistid;
        this.deviceid = deviceid;
        this.ordersum = ordersum;
        this.content = content;
    }

    public Todo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Byte getIscycle() {
        return iscycle;
    }

    public void setIscycle(Byte iscycle) {
        this.iscycle = iscycle;
    }

    public Date getCycletime() {
        return cycletime;
    }

    public void setCycletime(Date cycletime) {
        this.cycletime = cycletime;
    }

    public Byte getIsdone() {
        return isdone;
    }

    public void setIsdone(Byte isdone) {
        this.isdone = isdone;
    }

    public Integer getBelonglistid() {
        return belonglistid;
    }

    public void setBelonglistid(Integer belonglistid) {
        this.belonglistid = belonglistid;
    }

    public Integer getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(Integer deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getOrdersum() {
        return ordersum;
    }

    public void setOrdersum(Integer ordersum) {
        this.ordersum = ordersum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}