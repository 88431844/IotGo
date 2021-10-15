package fun.iotgo.controller;

import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.util.myconst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * https转换controller
 */
@RestController
@RequestMapping("/todoist")
@Slf4j
public class TodoistController {

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
}
