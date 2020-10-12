package fun.iotgo.entity;

import lombok.Data;

@Data
public class TodoList {
    private Integer id;

    private String todolistname;

    private String content;
}