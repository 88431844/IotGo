package fun.iotgo.controller;

import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.dto.todoist.GetProjectByNameReq;
import fun.iotgo.dto.todoist.GetTaskListByProjectNameReq;
import fun.iotgo.service.TodoistService;
import fun.iotgo.util.myconst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * https转换controller
 */
@RestController
@RequestMapping("/todoist")
@Slf4j
public class TodoistController {

    @Resource
    TodoistService todoistService;

    /**
     * 获取项目列表
     */
    @RequestMapping("/getProjects")
    public CommonResponseDto getProjects() {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            log.info("TodoistController getProjects");
            ret.setData("TodoistController getProjects");
            return ret;
        } catch (Exception e) {
            log.error("TodoistController getProjects error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 通过项目名称获取项目
     */
    @RequestMapping("/getProjectByName")
    public CommonResponseDto getProjectByName(GetProjectByNameReq req) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            log.info("TodoistController getProjectByName");
            ret.setData(todoistService.getProjectByName(req));
            ret.setCode(myconst.SUCCESS);
            return ret;
        } catch (Exception e) {
            log.error("TodoistController getProjectByName error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 通过项目名称获取任务列表
     */
    @RequestMapping("/getTaskListByProjectName")
    public CommonResponseDto getTaskListByProjectName(GetTaskListByProjectNameReq req) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            log.info("TodoistController getTaskListByProjectName");
            ret.setData(todoistService.getTaskListByProjectName(req));
            ret.setCode(myconst.SUCCESS);
            return ret;
        } catch (Exception e) {
            log.error("TodoistController getTaskListByProjectName error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }
}
