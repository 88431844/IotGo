package fun.iotgo.dto.todoist;

import lombok.Data;

@Data
public class GetTaskListByProjectNameReq extends TodoistComReq {

    private String projectName;
}
