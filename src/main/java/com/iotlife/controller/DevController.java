package com.iotlife.controller;

import com.iotlife.dto.CommonDto;
import com.iotlife.dto.DevDto;
import com.iotlife.service.DevService;
import com.iotlife.util.myconst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DevService devService;

    /**
     * 设备绑定用户
     *
     * @param devDto
     * @return
     */
    public CommonDto bingDevToUser(DevDto devDto) {
        CommonDto commonDto = new CommonDto();

        try {
            devService.bingDevToUser(devDto);
            commonDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController bingDevToUser error:{}", e);
            commonDto.setCode(myconst.FAIL);
        }
        return commonDto;
    }
}
