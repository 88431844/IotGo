package fun.iotgo.dao;

import fun.iotgo.dto.DevDto;
import fun.iotgo.entity.Dev;

import java.util.List;

public interface DevMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dev record);

    int insertSelective(Dev record);

    Dev selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dev record);

    int updateByPrimaryKey(Dev record);

    /**
     * 通过用户id查询该用户下面绑定设备
     */
    List<DevDto> selectDevByUserId(String userId);

    /**
     * 通过设备id查询devDto
     */
    DevDto selectDevDtoByPrimaryKey(Integer devId);

    /**
     * 查询所有设备
     */
    List<DevDto> selectAllDev();
}