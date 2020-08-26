package fun.iotgo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/test")
    public String test() {
        log.info("TestController test ....");
        return "TestController test ....";
    }
}
