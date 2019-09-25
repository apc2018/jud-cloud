package jud.cloud.upms.biz.controll;

import io.swagger.annotations.Api;
import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.core.util.R;
import jud.cloud.common.log.annotation.SysLog;
import jud.cloud.upms.api.feign.RemoteTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/token")
@Api(value = "token", description = "令牌管理模块")
public class TokenController {
    private final RemoteTokenService remoteTokenService;

    /**
     * 分页token 信息
     *
     * @param params 参数集
     * @return token集合
     */
    @GetMapping("/page")
    public R getTokenPage(@RequestParam Map<String, Object> params) {
        return remoteTokenService.getTokenPage(params, SecurityConstants.FROM_IN);
    }

    /**
     * 删除
     *
     * @param token getTokenPage
     * @return success/false
     */
    @SysLog("删除用户token")
    @DeleteMapping("/{token}")
    @PreAuthorize("@pms.hasPermission('sys_token_del')")
    public R removeById(@PathVariable String token) {
        return remoteTokenService.removeTokenById(token, SecurityConstants.FROM_IN);
    }
}
