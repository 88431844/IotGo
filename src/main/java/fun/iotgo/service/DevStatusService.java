package fun.iotgo.service;

import fun.iotgo.dao.DevStatusMapper;
import fun.iotgo.entity.DevStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevStatusService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
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
