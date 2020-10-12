package fun.iotgo.dto.request;


import fun.iotgo.dto.CommonRequestDto;
import lombok.Data;

@Data
public class AddTodoReq extends CommonRequestDto {

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
     */
    private boolean isCycle;
    /**
     * 周期提醒时间
     */
    private String cycleTime;
    /**
     * 是否完成
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
}
