package fun.iotgo.controller;

import fun.iotgo.dto.CommonResponseDto;
import fun.iotgo.dto.HttpDto;
import fun.iotgo.util.myconst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * https转换controller
 */
@RestController
@RequestMapping("/https")
@Slf4j
public class HttpsRouterController {


    /**
     * 管理员登录
     */
    @RequestMapping("/http2https")
    @ResponseBody
    public CommonResponseDto http2https(@RequestBody @Validated HttpDto httpDto) {
        CommonResponseDto ret = new CommonResponseDto();
        try {
            System.out.println("");
        } catch (Exception e) {
            log.error("HttpsRouterController http2https error");
            ret.setCode(myconst.EXCEPTION);
            e.printStackTrace();
        }
        return ret;
    }
}
