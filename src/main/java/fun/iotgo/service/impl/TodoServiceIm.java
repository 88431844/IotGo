package fun.iotgo.service.impl;

import fun.iotgo.dto.TodoDto;
import fun.iotgo.dto.request.AddTodoReq;
import fun.iotgo.dto.request.UpdateTodoReq;
import fun.iotgo.service.TodoService;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceIm implements TodoService {
    @Override
    public void addTodo(AddTodoReq addTodoReq) {

    }

    @Override
    public void delTodo(String id) {

    }

    @Override
    public void updateTodo(UpdateTodoReq updateTodoReq) {

    }

    @Override
    public TodoDto selectById(String id) {
        return null;
    }
}
