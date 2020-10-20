package fun.iotgo.service.impl;

import fun.iotgo.dao.TodoMapper;
import fun.iotgo.dto.TodoDto;
import fun.iotgo.dto.request.AddTodoReq;
import fun.iotgo.dto.request.UpdateTodoReq;
import fun.iotgo.entity.Todo;
import fun.iotgo.service.TodoService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TodoServiceIm implements TodoService {

    @Resource
    private TodoMapper todoMapper;

    @Override
    public void addTodo(AddTodoReq addTodoReq) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(addTodoReq, todo);
        todoMapper.insertSelective(todo);
    }

    @Override
    public void delTodo(int id) {
        todoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateTodo(UpdateTodoReq updateTodoReq) {
        Todo todo = new Todo();
        BeanUtils.copyProperties(updateTodoReq, todo);
        todoMapper.updateByPrimaryKeySelective(todo);
    }

    @Override
    public TodoDto selectTodoById(int id) {
        return null;
    }

    @Override
    public List<TodoDto> selectTodoListByDeviceId(int deviceId) {
        return null;
    }

    @Override
    public List<TodoDto> selectAllTodoList() {
        return todoMapper.selectAllTodoList();
    }

}
