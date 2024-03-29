package jud.cloud.upms.biz.controll;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import jud.cloud.common.core.util.R;
import jud.cloud.common.security.annotation.Inner;
import jud.cloud.upms.api.entity.SysLog;
import jud.cloud.upms.api.vo.PreLogVo;
import jud.cloud.upms.biz.service.SysLogService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/log")
@Api(value = "log", description = "日志管理模块")
public class LogController {
    private final SysLogService sysLogService;

    /**
     * 简单分页查询
     *
     * @param page   分页对象
     * @param sysLog 系统日志
     * @return
     */
    @GetMapping("/page")
    public R getLogPage(Page page, SysLog sysLog) {
        return new R<>(sysLogService.page(page, Wrappers.query(sysLog)));
    }

    /**
     * 删除日志
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_log_del')")
    public R removeById(@PathVariable Long id) {
        return new R<>(sysLogService.removeById(id));
    }

    /**
     * 插入日志
     *
     * @param sysLog 日志实体
     * @return success/false
     */
    @Inner
    @PostMapping("/save")
    public R save(@Valid @RequestBody SysLog sysLog) {
        return new R<>(sysLogService.save(sysLog));
    }

    /**
     * 批量插入前端异常日志
     *
     * @param preLogVoList 日志实体
     * @return success/false
     */
    @PostMapping("/logs")
    public R saveBatchLogs(@RequestBody List<PreLogVo> preLogVoList) {
        return new R<>(sysLogService.saveBatchLogs(preLogVoList));
    }
}
