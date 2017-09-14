package com.iotlife.controller;

import com.iotlife.dto.CommonDto;
import com.iotlife.dto.DevDto;
import com.iotlife.service.DevService;
import com.iotlife.util.myconst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DevController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DevService devService;

    /**
     * 添加设备
     * @param devDto
     * @return
     */
    @RequestMapping("/addDev")
    @ResponseBody
    public CommonDto addDev(@RequestBody @Validated DevDto devDto) {
        CommonDto commonDto = new CommonDto();
        try {
            devService.addDev(devDto);
            commonDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController addDev error");
            commonDto.setCode(myconst.FAIL);
        }
        return commonDto;
    }

    /**
     * 删除设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/delDev")
    @ResponseBody
    public CommonDto delDev(@RequestBody @Validated DevDto devDto) {
        CommonDto commonDto = new CommonDto();
        int delStatus = 0;
        try {
            delStatus = devService.delDev(devDto);
            //TODO 判断delStatus状态 并且把状态加入到myconst静态变量中
            commonDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController delDev error");
            commonDto.setCode(myconst.FAIL);
        }
        return commonDto;
    }

    /**
     * 修改设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/updateDev")
    @ResponseBody
    public CommonDto updateDev(@RequestBody @Validated DevDto devDto) {
        CommonDto commonDto = new CommonDto();
        try {
            devService.updateDev(devDto);
            commonDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController updateDev error");
            commonDto.setCode(myconst.FAIL);
        }
        return commonDto;
    }

    /**
     * 通过设备id查询设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/selectDevById")
    @ResponseBody
    public CommonDto selectDevById(@RequestBody @Validated DevDto devDto) {
        CommonDto commonDto = new CommonDto();
        DevDto ret = null;
        try {
            ret = devService.selectById(devDto);
            if (null == ret) {//如果查询出来结果为null则返回响应code码
                commonDto.setCode(myconst.NULL_RESULT);
            } else {
                commonDto.setCode(myconst.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("DevController selectDevById error");
            commonDto.setCode(myconst.FAIL);
        }
        return commonDto;
    }

    /**
     * 通过用户id查询该用户下面绑定的设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/selectDevByUserId")
    @ResponseBody
    public CommonDto selectDevByUserId(@RequestBody @Validated DevDto devDto) {
        CommonDto commonDto = new CommonDto();
        List<DevDto> dList = null;
        try {
            dList = devService.selectDevByUserId(devDto);
            if (null != dList) {
                if (dList.size() > 0) {
                    commonDto.setData(dList);
                    commonDto.setCode(myconst.SUCCESS);
                } else {
                    commonDto.setCode(myconst.EMPTY_LIST);
                }
            } else {
                commonDto.setCode(myconst.FAIL);
            }
        } catch (Exception e) {
            logger.error("DevController selectDevByUserId error:{}", e);
            commonDto.setCode(myconst.FAIL);
        }

        return commonDto;
    }

    /**
     * 用户绑定设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/bingDevToUser")
    @ResponseBody
    public CommonDto bingDevToUser(@RequestBody @Validated DevDto devDto) {
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

    /**
     * 用户解绑设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/unBingDevToUser")
    @ResponseBody
    public CommonDto unBingDevToUser(@RequestBody @Validated DevDto devDto) {
        CommonDto commonDto = new CommonDto();
        try {
            devService.unBingDevToUser(devDto);
            commonDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController unBingDevToUser error:{}", e);
            commonDto.setCode(myconst.FAIL);
        }
        return commonDto;
    }
}
