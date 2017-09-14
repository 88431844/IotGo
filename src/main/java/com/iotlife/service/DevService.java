package com.iotlife.service;

import com.iotlife.dao.DevMapper;
import com.iotlife.dto.DevDto;
import com.iotlife.entity.Dev;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DevMapper devMapper;

    /**
     * 设备绑定用户
     *
     * @param devDto
     */
    public void bingDevToUser(DevDto devDto) throws Exception {
        Dev dev = new Dev();
        dev.setDevname(devDto.getDevname());
        dev.setDevtype(devDto.getDevtype());
        dev.setDevdes(devDto.getDevdes());
        dev.setDevtopic(devDto.getDevtopic());
        devMapper.insertSelective(dev);
    }
}
