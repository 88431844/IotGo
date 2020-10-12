package fun.iotgo.service;

import fun.iotgo.dto.request.AddTodoReq;

public interface TodoService {

    void addTodo(AddTodoReq addTodoReq);
}
