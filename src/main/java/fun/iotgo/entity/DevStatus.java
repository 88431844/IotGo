package fun.iotgo.entity;


import lombok.Data;

@Data
public class DevStatus {
    private Integer id;

    private Integer devid;

    /**
     * 0 下线
     * 1 上线
     * 2 未知
     * 默认0
     */
    private Integer devstatus;
}