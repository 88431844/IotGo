package fun.iotgo.dao;

import fun.iotgo.entity.TodoList;

public interface TodoListMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TodoList record);

    int insertSelective(TodoList record);

    TodoList selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TodoList record);

    int updateByPrimaryKey(TodoList record);
}