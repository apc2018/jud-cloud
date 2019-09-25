package jud.cloud.upms.biz.controll;

import io.swagger.annotations.Api;
import jud.cloud.common.core.util.R;
import jud.cloud.upms.biz.service.MobileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/mobile")
@Api(value = "mobile", description = "手机管理模块")
public class MobileController {
    private final MobileService mobileService;

    @GetMapping("/{mobile}")
    public R sendSmsCode(@PathVariable String mobile) {
        return mobileService.sendSmsCode(mobile);
    }
}
