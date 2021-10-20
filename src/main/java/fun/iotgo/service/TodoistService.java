package fun.iotgo.service;

import fun.iotgo.dto.todoist.GetProjectByNameReq;
import fun.iotgo.dto.todoist.GetTaskListByProjectNameReq;
import fun.iotgo.dto.todoist.ProjectDto;
import fun.iotgo.dto.todoist.TaskDto;

import java.util.List;

public interface TodoistService {

    ProjectDto getProjectByName(GetProjectByNameReq req);

    List<TaskDto> getTaskListByProjectName(GetTaskListByProjectNameReq req);
}
