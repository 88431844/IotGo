package fun.iotgo.dao;

import fun.iotgo.entity.Todo;

public interface TodoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Todo record);

    int insertSelective(Todo record);

    Todo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Todo record);

    int updateByPrimaryKeyWithBLOBs(Todo record);

    int updateByPrimaryKey(Todo record);
}