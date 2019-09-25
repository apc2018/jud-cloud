package jud.cloud.upms.biz.controll;

import cn.hutool.json.JSONArray;
import io.swagger.annotations.Api;
import jud.cloud.common.core.util.R;
import jud.cloud.common.log.annotation.SysLog;
import jud.cloud.upms.biz.service.SysRouteConfService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/route")
@Api(value = "route",description = "动态路由管理模块")
public class SysRouteConfController {
    private final SysRouteConfService sysRouteConfService;


    /**
     * 获取当前定义的路由信息
     *
     * @return
     */
    @GetMapping
    public R listRoutes() {
        return new R<>(sysRouteConfService.list());
    }

    /**
     * 修改路由
     *
     * @param routes 路由定义
     * @return
     */
    @SysLog("修改路由")
    @PutMapping
    public R updateRoutes(@RequestBody JSONArray routes) {
        return new R(sysRouteConfService.updateRoutes(routes));
    }
}
