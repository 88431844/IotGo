package com.iotlife.service;

import com.iotlife.dao.DevMapper;
import com.iotlife.dao.UserDevRelationMapper;
import com.iotlife.dto.DevDto;
import com.iotlife.entity.Dev;
import com.iotlife.entity.UserDevRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DevMapper devMapper;
    @Autowired
    private UserDevRelationMapper userDevRelationMapper;

    /**
     * 添加设备
     *
     * @param devDto
     * @throws Exception
     */
    public void addDev(DevDto devDto) throws Exception {
        Dev dev = new Dev();
        BeanUtils.copyProperties(devDto, dev);
        devMapper.insertSelective(dev);
    }

    /**
     * 删除设备
     *
     * @param devDto
     * @throws Exception
     */
    public int delDev(DevDto devDto) throws Exception {
        /**
         * 0 删除成功
         * 1 有用户绑定关系
         * 2 删除绑定关系失败
         * 3 珊瑚设备信息失败
         */
        int ret = 0;
        //TODO 先看看该设备是否已经被用户绑定，如果已经被绑定提示先解绑再删除，
        //TODO 如果没有，则关联userdevrelation表进行删除
        devMapper.deleteByPrimaryKey(devDto.getId());
        return ret;
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
    public DevDto selectById(DevDto devDto) {
        Dev dev = new Dev();
        DevDto dto = new DevDto();
        dev = devMapper.selectByPrimaryKey(devDto.getId());
        BeanUtils.copyProperties(dev, dto);
        return dto;
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
    public void bingDevToUser(DevDto devDto) throws Exception {
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
    public void unBingDevToUser(DevDto devDto) throws Exception {
        UserDevRelation userDevRelation = new UserDevRelation();
        userDevRelation.setUserid(Integer.parseInt(devDto.getUserId()));
        userDevRelation.setDevid(devDto.getId());
        userDevRelationMapper.delByUserIdAndDevId(userDevRelation);
    }
}
