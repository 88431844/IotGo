package com.iotlife.service;

import com.iotlife.dao.DevMapper;
import com.iotlife.dao.UserDevRelationMapper;
import com.iotlife.dto.DevDto;
import com.iotlife.entity.Dev;
import com.iotlife.entity.DevStatus;
import com.iotlife.entity.UserDevRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DevService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DevMapper devMapper;
    @Autowired
    private UserDevRelationMapper userDevRelationMapper;
    @Autowired
    private DevService devService;
    @Autowired
    private DevStatusService devStatusService;
    /**
     * 添加设备
     *
     * @param devDto
     * @throws Exception
     */
    @Transactional
    public void addDev(DevDto devDto) throws Exception {
        Dev dev = new Dev();
        BeanUtils.copyProperties(devDto, dev);
        devMapper.insertSelective(dev);
        //对应生成该设备的状态表信息
        DevStatus devStatus = new DevStatus();
        devStatus.setDevid(dev.getId());
        /**
         * 0 下线
         * 1 上线
         * 2 未知
         * 默认0
         */
        devStatus.setDevstatus(0);//默认置为0
        devStatusService.addDevStatus(devStatus);
    }

    /**
     * 删除设备
     *
     * @param devDto
     * @throws Exception
     */
    @Transactional
    public int delDev(DevDto devDto) throws Exception {
        /**
         * 0 删除成功
         * 1 有用户绑定关系
         */
        //判断该设备是否已经被用户绑定，如果已经被绑定提示先解绑再删除
        List<DevDto> dList = devService.selectDevByUserId(devDto);
        if (null != dList && dList.size() > 0) {
            return 1;
        }
        devMapper.deleteByPrimaryKey(devDto.getId());
        //删除对应设备的状态表
        devStatusService.delDevStatusByDevId(devDto.getId());
        return 0;
    }

    /**
     * 更新设备
     *
     * @param devDto
     * @throws Exception
     */
    public void updateDev(DevDto devDto) throws Exception {
        Dev dev = new Dev();
        BeanUtils.copyProperties(devDto, dev);
        devMapper.updateByPrimaryKey(dev);
    }

    /**
     * 通过设备id查询设备信息
     *
     * @param devDto
     * @return
     */
    public DevDto selectById(DevDto devDto) throws Exception {
        return devMapper.selectDevDtoByPrimaryKey(devDto.getId());
    }

    /**
     * 通过用户id查询该用户下设备列表
     *
     * @param devDto
     * @return
     */
    public List<DevDto> selectDevByUserId(DevDto devDto) throws Exception {
        return devMapper.selectDevByUserId(devDto.getUserId());
    }

    /**
     * 用户绑定设备
     *
     * @param devDto
     */
    public void bindDevToUser(DevDto devDto) throws Exception {
        UserDevRelation userDevRelation = new UserDevRelation();
        userDevRelation.setUserid(Integer.parseInt(devDto.getUserId()));
        userDevRelation.setDevid(devDto.getId());
        userDevRelationMapper.insertSelective(userDevRelation);
    }

    /**
     * 用户解绑设备
     *
     * @param devDto
     */
    public void unBindDevToUser(DevDto devDto) throws Exception {
        UserDevRelation userDevRelation = new UserDevRelation();
        userDevRelation.setUserid(Integer.parseInt(devDto.getUserId()));
        userDevRelation.setDevid(devDto.getId());
        userDevRelationMapper.delByUserIdAndDevId(userDevRelation);
    }

    /**
     * 解绑用户所有设备
     *
     * @param devDto
     */
    public void unBindUserAllDev(DevDto devDto) throws Exception {
        userDevRelationMapper.unBindUserAllDev(devDto.getUserId());
    }
}
