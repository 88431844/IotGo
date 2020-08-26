package fun.iotgo.service;

import fun.iotgo.dao.DevStatusMapper;
import fun.iotgo.entity.DevStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class DevStatusService {

    @Resource
    private DevStatusMapper devStatusMapper;

    /**
     * 添加对应设备的状态
     *
     * @param devStatus
     */
    public void addDevStatus(DevStatus devStatus) throws Exception {
        devStatusMapper.insertSelective(devStatus);
    }

    /**
     * 删除对应设备的状态
     *
     * @param devStatus
     */
    public void delDevStatus(DevStatus devStatus) throws Exception {
        devStatusMapper.deleteByPrimaryKey(devStatus.getId());
    }

    /**
     * 更新对应设备的状态
     *
     * @param devStatus
     */
    public void updateDevStatus(DevStatus devStatus) throws Exception {
        devStatusMapper.updateByPrimaryKeySelective(devStatus);
    }

    /**
     * 通过设备id查询对应设备状态
     *
     * @param devStatus
     * @return
     */
    public DevStatus selectDevStatusByDevId(DevStatus devStatus) throws Exception {
        return devStatusMapper.selectByDevId(devStatus.getDevid());
    }

    /**
     * 通过设备id删除对应设备状态
     *
     * @param devId
     */
    public void delDevStatusByDevId(Integer devId) throws Exception {
        devStatusMapper.delDevStatusByDevId(devId);
    }
}
