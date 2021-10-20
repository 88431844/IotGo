package fun.iotgo.dto.todoist;

import lombok.Data;

@Data
public class ProjectDto {

    private String id;
    private int order;
    private String color;
    private String name;
    private String comment_count;
    private String shared;
    private String favorite;
    private String sync_id;
    private String url;
}
