package fun.iotgo.dto.todoist;

import lombok.Data;

@Data
public class GetTaskListByProjectIdReq extends TodoistComReq {

    private String projectId;
}
