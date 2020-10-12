package fun.iotgo.dto;

import lombok.Data;

@Data
public class DevDto {
    private Integer id;

    private String devName;

    private Integer devType;

    private String devTypeName;

    private String devDes;

    private String devTopic;

    private String userId;
    /**
     * 0 下线
     * 1 上线
     * 2 未知
     * 默认0
     */
    private Integer devStatus;
}
