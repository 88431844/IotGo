package fun.iotgo.dao;

import fun.iotgo.entity.DevStatus;

public interface DevStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DevStatus record);

    int insertSelective(DevStatus record);

    DevStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DevStatus record);

    int updateByPrimaryKey(DevStatus record);

    /**
     * 通过设备id查询对应设备状态
     */
    DevStatus selectByDevId(Integer devId);

    /**
     * 通过设备id删除对应设备状态
     */
    void delDevStatusByDevId(Integer devId);
}