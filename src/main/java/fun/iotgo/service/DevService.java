package fun.iotgo.service;

import fun.iotgo.dto.DevDto;
import fun.iotgo.entity.DevStatus;

import java.util.List;


public interface DevService {

    /**
     * 添加设备
     */
    void addDev(DevDto devDto) throws Exception;

    /**
     * 删除设备
     */
    int delDev(DevDto devDto) throws Exception;

    /**
     * 更新设备
     */
    void updateDev(DevDto devDto) throws Exception;

    /**
     * 通过设备id查询设备信息
     */
    DevDto selectById(DevDto devDto) throws Exception;

    /**
     * 通过用户id查询该用户下设备列表
     */
    List<DevDto> selectDevByUserId(DevDto devDto) throws Exception;

    /**
     * 用户绑定设备
     */
    void bindDevToUser(DevDto devDto) throws Exception;

    /**
     * 用户解绑设备
     */
    void unBindDevToUser(DevDto devDto) throws Exception;

    /**
     * 解绑用户所有设备
     */
    void unBindUserAllDev(DevDto devDto) throws Exception;

    /**
     * 添加对应设备的状态
     */
    void addDevStatus(DevStatus devStatus) throws Exception;

    /**
     * 删除对应设备的状态
     */
    void delDevStatus(DevStatus devStatus) throws Exception;

    /**
     * 更新对应设备的状态
     */
    void updateDevStatus(DevStatus devStatus) throws Exception;

    /**
     * 通过设备id查询对应设备状态
     */
    DevStatus selectDevStatusByDevId(DevStatus devStatus) throws Exception;

    /**
     * 通过设备id删除对应设备状态
     */
    void delDevStatusByDevId(Integer devId) throws Exception;
}
