package fun.iotgo.dto.todoist;

import lombok.Data;

@Data
public class TaskDto {
    private String id;
    private String assigner;
    private String project_id;
    private String section_id;
    private int order;
    private String content;
    private String description;
    private String completed;
    private String label_ids;
    private String priority;
    private String comment_count;
    private String creator;
    private String created;
    private String url;
}
