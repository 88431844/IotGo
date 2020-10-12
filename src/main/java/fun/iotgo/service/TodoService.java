package fun.iotgo.service;

import fun.iotgo.dto.TodoDto;
import fun.iotgo.dto.request.AddTodoReq;
import fun.iotgo.dto.request.UpdateTodoReq;

public interface TodoService {

    void addTodo(AddTodoReq addTodoReq);

    void delTodo(String id);

    void updateTodo(UpdateTodoReq updateTodoReq);

    TodoDto selectById(String id);
}
