package fun.iotgo.entity;

import lombok.Data;

import java.util.Date;

@Data
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

    private String content;
}