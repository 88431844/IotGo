package fun.iotgo.controller;

import fun.iotgo.dto.AdminDto;
import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.service.AdminService;
import fun.iotgo.util.myconst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员controller
 */
@RestController
public class AdminController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AdminService adminService;

    /**
     * 更新管理员信息
     *
     * @param adminDto
     * @return
     */
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public CommonResponseDto updateAdmin(@RequestBody @Validated AdminDto adminDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            adminService.updateAdmin(adminDto);
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            logger.error("AdminController updateAdmin error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }
}
