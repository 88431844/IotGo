package fun.iotgo.controller;

import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.dto.request.AddTodoReq;
import fun.iotgo.dto.request.UpdateTodoReq;
import fun.iotgo.service.TodoService;
import fun.iotgo.util.myconst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/todo")
@Slf4j

/**
 *IOT设备日程相关controller
 */
public class TodoController {

    @Resource
    private TodoService todoService;

    /**
     * 添加提醒
     */
    @RequestMapping("/addTodo")
    @ResponseBody
    public CommonResponseDto addTodo(@RequestBody @Validated AddTodoReq addTodoReq) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            todoService.addTodo(addTodoReq);
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("TodoController addTodo error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 删除提醒
     */
    @RequestMapping("/delTodo")
    @ResponseBody
    public CommonResponseDto delDev(@RequestBody @Validated String id) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            todoService.delTodo(id);
        } catch (Exception e) {
            log.error("TodoController delTodo error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 修改提醒
     */
    @RequestMapping("/updateTodo")
    @ResponseBody
    public CommonResponseDto updateDev(@RequestBody @Validated UpdateTodoReq updateTodoReq) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            todoService.updateTodo(updateTodoReq);
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("TodoController updateTodo error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }

    /**
     * 通过提醒id查询提醒
     */
    @RequestMapping("/selectTodoById")
    @ResponseBody
    public CommonResponseDto selectTodoById(@RequestBody @Validated String id) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            ret.setData(todoService.selectById(id));
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("TodoController selectTodoById error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }
}
