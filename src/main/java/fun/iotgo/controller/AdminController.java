package fun.iotgo.controller;

import fun.iotgo.dto.AdminDto;
import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.service.impl.AdminServiceIm;
import fun.iotgo.util.myconst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 管理员controller
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Resource
    private AdminServiceIm adminService;

    /**
     * 更新管理员信息
     */
    @RequestMapping("/updateAdmin")
    @ResponseBody
    public CommonResponseDto updateAdmin(@RequestBody @Validated AdminDto adminDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            adminService.updateAdmin(adminDto);
            ret.setCode(myconst.SUCCESS);
        } catch (Exception e) {
            log.error("AdminController updateAdmin error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }
}
