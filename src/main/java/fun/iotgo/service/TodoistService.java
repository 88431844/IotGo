package fun.iotgo.service;

import fun.iotgo.dto.todoist.GetProjectByNameReq;
import fun.iotgo.dto.todoist.GetTaskListByProjectIdReq;
import fun.iotgo.dto.todoist.ProjectDto;
import fun.iotgo.dto.todoist.TaskDto;

import java.util.List;

public interface TodoistService {

    ProjectDto getProjectByName(GetProjectByNameReq req);

    List<TaskDto> getTaskListByProjectId(GetTaskListByProjectIdReq req);
}
