package com.iotlife.controller;

import com.iotlife.dto.CommonResponseDto;
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
    public CommonResponseDto addDev(@RequestBody @Validated DevDto devDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        try {
            devService.addDev(devDto);
            CommonResponseDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController addDev error");
            CommonResponseDto.setCode(myconst.FAIL);
        }
        return CommonResponseDto;
    }

    /**
     * 删除设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/delDev")
    @ResponseBody
    public CommonResponseDto delDev(@RequestBody @Validated DevDto devDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        int delStatus = 0;
        try {
            delStatus = devService.delDev(devDto);
            //TODO 判断delStatus状态 并且把状态加入到myconst静态变量中
            CommonResponseDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController delDev error");
            CommonResponseDto.setCode(myconst.FAIL);
        }
        return CommonResponseDto;
    }

    /**
     * 修改设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/updateDev")
    @ResponseBody
    public CommonResponseDto updateDev(@RequestBody @Validated DevDto devDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        try {
            devService.updateDev(devDto);
            CommonResponseDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController updateDev error");
            CommonResponseDto.setCode(myconst.FAIL);
        }
        return CommonResponseDto;
    }

    /**
     * 通过设备id查询设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/selectDevById")
    @ResponseBody
    public CommonResponseDto selectDevById(@RequestBody @Validated DevDto devDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        DevDto ret = null;
        try {
            ret = devService.selectById(devDto);
            if (null == ret) {//如果查询出来结果为null则返回响应code码
                CommonResponseDto.setCode(myconst.NULL_RESULT);
            } else {
                CommonResponseDto.setCode(myconst.SUCCESS);
            }
        } catch (Exception e) {
            logger.error("DevController selectDevById error");
            CommonResponseDto.setCode(myconst.FAIL);
        }
        return CommonResponseDto;
    }

    /**
     * 通过用户id查询该用户下面绑定的设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/selectDevByUserId")
    @ResponseBody
    public CommonResponseDto selectDevByUserId(@RequestBody @Validated DevDto devDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        List<DevDto> dList = null;
        try {
            dList = devService.selectDevByUserId(devDto);
            if (null != dList) {
                if (dList.size() > 0) {
                    CommonResponseDto.setData(dList);
                    CommonResponseDto.setCode(myconst.SUCCESS);
                } else {
                    CommonResponseDto.setCode(myconst.EMPTY_LIST);
                }
            } else {
                CommonResponseDto.setCode(myconst.FAIL);
            }
        } catch (Exception e) {
            logger.error("DevController selectDevByUserId error:{}", e);
            CommonResponseDto.setCode(myconst.FAIL);
        }

        return CommonResponseDto;
    }

    /**
     * 用户绑定设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/bingDevToUser")
    @ResponseBody
    public CommonResponseDto bingDevToUser(@RequestBody @Validated DevDto devDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();

        try {
            devService.bingDevToUser(devDto);
            CommonResponseDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController bingDevToUser error:{}", e);
            CommonResponseDto.setCode(myconst.FAIL);
        }
        return CommonResponseDto;
    }

    /**
     * 用户解绑设备
     *
     * @param devDto
     * @return
     */
    @RequestMapping("/unBingDevToUser")
    @ResponseBody
    public CommonResponseDto unBingDevToUser(@RequestBody @Validated DevDto devDto) {
        CommonResponseDto CommonResponseDto = new CommonResponseDto();
        try {
            devService.unBingDevToUser(devDto);
            CommonResponseDto.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("DevController unBingDevToUser error:{}", e);
            CommonResponseDto.setCode(myconst.FAIL);
        }
        return CommonResponseDto;
    }
}
