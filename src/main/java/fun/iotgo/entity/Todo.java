package fun.iotgo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class Todo {
    private Integer id;

    private String title;

    private String url;

    private Date startTime;

    private Date endTime;

    private Byte isCycle;

    private Date cycleTime;

    private Byte isDone;

    private Integer belongListId;

    private Integer deviceId;

    private Integer orderSum;

    private String content;


}