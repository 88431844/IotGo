package fun.iotgo.dto;

import lombok.Data;

@Data
public class TodoDto extends CommonRequestDto {

    private int id;
    /**
     * 提醒标题
     */
    private String title;
    /**
     * 提醒内容
     */
    private String content;
    /**
     * 提醒URL
     */
    private String url;
    /**
     * 提醒开始时间
     */
    private String startTime;
    /**
     * 提醒结束时间
     */
    private String endTime;
    /**
     * 是否为周期提醒
     * <p>
     * 1代表TRUE,0代表FALSE
     */
    private boolean isCycle;
    /**
     * 周期提醒时间
     */
    private String cycleTime;
    /**
     * 是否完成
     * 1代表TRUE,0代表FALSE
     */
    private boolean isDone;
    /**
     * 归属提醒列表
     */
    private String belongListId;
    /**
     * 提醒归属设备的Id(需要提醒到哪个设备上)
     */
    private String deviceId;
    /**
     * 提醒顺序
     * 0优先级最低，数越大越往上
     */
    private int orderSum;
}
