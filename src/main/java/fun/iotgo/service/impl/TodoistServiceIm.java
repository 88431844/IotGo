package fun.iotgo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import fun.iotgo.dto.todoist.GetProjectByNameReq;
import fun.iotgo.dto.todoist.GetTaskListByProjectIdReq;
import fun.iotgo.dto.todoist.ProjectDto;
import fun.iotgo.dto.todoist.TaskDto;
import fun.iotgo.myconst.TodoistConst;
import fun.iotgo.service.TodoistService;
import fun.iotgo.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TodoistServiceIm implements TodoistService {
    @Override
    public ProjectDto getProjectByName(GetProjectByNameReq req) {
        String result = HttpUtil.httpReq(TodoistConst.PROJECT_URL, req.getAuthorization());
        if (!StringUtils.isEmpty(result)) {
            JSONArray jsonArray = JSONArray.parseArray(result);
            for (Object o : jsonArray) {
                if (req.getProjectName().equals(JSONObject.parseObject(o.toString()).getString("name"))) {
                    return JSON.parseObject(o.toString(), ProjectDto.class);
                }
            }
        }
        return null;
    }

    @Override
    public List<TaskDto> getTaskListByProjectId(GetTaskListByProjectIdReq req) {
        List<TaskDto> list = new ArrayList<>();
        String result = HttpUtil.httpReq(TodoistConst.TASK_URL, req.getAuthorization());
//        String projectId = getProjectIdByProjectName(req.getProjectName(), req.getAuthorization());
        String projectId = req.getProjectId();
        if (!StringUtils.isEmpty(projectId)) {
            if (!StringUtils.isEmpty(result)) {
                JSONArray jsonArray = JSONArray.parseArray(result);
                for (Object o : jsonArray) {
                    if (projectId.equals(JSONObject.parseObject(o.toString()).getString("project_id"))) {
                        list.add(JSON.parseObject(o.toString(), TaskDto.class));
                    }
                }
            }
        }
        list.sort((t1, t2) -> {
            if (t1.getOrder() > t2.getOrder()) {
                return 0;
            } else {
                return -1;
            }
        });
        return list;
    }

    private static String getProjectIdByProjectName(String projectName, String authorization) {
        String result = HttpUtil.httpReq(TodoistConst.PROJECT_URL, authorization);
        if (!StringUtils.isEmpty(result)) {
            JSONArray jsonArray = JSONArray.parseArray(result);
            for (Object o : jsonArray) {
                if (projectName.equals(JSONObject.parseObject(o.toString()).getString("name"))) {
                    return JSONObject.parseObject(o.toString()).getString("id");
                }
            }
        }
        return null;
    }

}
