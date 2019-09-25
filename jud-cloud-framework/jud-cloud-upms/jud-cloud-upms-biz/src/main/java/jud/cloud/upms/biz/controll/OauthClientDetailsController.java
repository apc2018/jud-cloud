package jud.cloud.upms.biz.controll;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import jud.cloud.common.core.util.R;
import jud.cloud.common.log.annotation.SysLog;
import jud.cloud.upms.api.entity.SysOauthClientDetails;
import jud.cloud.upms.biz.service.SysOauthClientDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
@Api(value = "client", description = "客户端管理模块")
public class OauthClientDetailsController {
    private final SysOauthClientDetailsService sysOauthClientDetailsService;

    /**
     * 通过ID查询
     *
     * @param id ID
     * @return SysOauthClientDetails
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R<>(sysOauthClientDetailsService.getById(id));
    }


    /**
     * 简单分页查询
     *
     * @param page                  分页对象
     * @param sysOauthClientDetails 系统终端
     * @return
     */
    @GetMapping("/page")
    public R getOauthClientDetailsPage(Page page, SysOauthClientDetails sysOauthClientDetails) {
        return new R<>(sysOauthClientDetailsService.page(page, Wrappers.query(sysOauthClientDetails)));
    }

    /**
     * 添加
     *
     * @param sysOauthClientDetails 实体
     * @return success/false
     */
    @SysLog("添加终端")
    @PostMapping
    @PreAuthorize("@pms.hasPermission('sys_client_add')")
    public R add(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
        return new R<>(sysOauthClientDetailsService.save(sysOauthClientDetails));
    }

    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @SysLog("删除终端")
    @DeleteMapping("/{id}")
    @PreAuthorize("@pms.hasPermission('sys_client_del')")
    public R removeById(@PathVariable String id) {
        return new R<>(sysOauthClientDetailsService.removeClientDetailsById(id));
    }

    /**
     * 编辑
     *
     * @param sysOauthClientDetails 实体
     * @return success/false
     */
    @SysLog("编辑终端")
    @PutMapping
    @PreAuthorize("@pms.hasPermission('sys_client_edit')")
    public R update(@Valid @RequestBody SysOauthClientDetails sysOauthClientDetails) {
        return new R<>(sysOauthClientDetailsService.updateClientDetailsById(sysOauthClientDetails));
    }
}
