package fun.iotgo.service;

import fun.iotgo.dto.TodoDto;
import fun.iotgo.dto.request.AddTodoReq;
import fun.iotgo.dto.request.UpdateTodoReq;

import java.util.List;

public interface TodoService {

    void addTodo(AddTodoReq addTodoReq);

    void delTodo(int id);

    void updateTodo(UpdateTodoReq updateTodoReq);

    TodoDto selectTodoById(int id);

    List<TodoDto> selectTodoListByDeviceId(int deviceId);

    /**
     * 查询所有提醒
     */
    List<TodoDto> selectAllTodoList();
}
