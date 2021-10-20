package fun.iotgo.dto.todoist;

import lombok.Data;

@Data
public class GetProjectByNameReq extends TodoistComReq {

    private String projectName;
}
