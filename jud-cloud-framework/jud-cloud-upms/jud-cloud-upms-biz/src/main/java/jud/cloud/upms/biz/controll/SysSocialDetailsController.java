package jud.cloud.upms.biz.controll;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import jud.cloud.common.core.util.R;
import jud.cloud.common.log.annotation.SysLog;
import jud.cloud.common.security.annotation.Inner;
import jud.cloud.upms.api.entity.SysSocialDetails;
import jud.cloud.upms.biz.service.SysSocialDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/social")
@AllArgsConstructor
@Api(value = "social", description = "三方账号管理模块")
public class SysSocialDetailsController {
    private final SysSocialDetailsService sysSocialDetailsService;


    /**
     * 社交登录账户简单分页查询
     *
     * @param page             分页对象
     * @param sysSocialDetails 社交登录
     * @return
     */
    @GetMapping("/page")
    public R getSocialDetailsPage(Page page, SysSocialDetails sysSocialDetails) {
        return new R<>(sysSocialDetailsService.page(page, Wrappers.query(sysSocialDetails)));
    }


    /**
     * 信息
     *
     * @param id
     * @return R
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Integer id) {
        return new R<>(sysSocialDetailsService.getById(id));
    }

    /**
     * 保存
     *
     * @param sysSocialDetails
     * @return R
     */
    @SysLog("保存三方信息")
    @PostMapping
    public R save(@Valid @RequestBody SysSocialDetails sysSocialDetails) {
        return new R<>(sysSocialDetailsService.save(sysSocialDetails));
    }

    /**
     * 修改
     *
     * @param sysSocialDetails
     * @return R
     */
    @SysLog("修改三方信息")
    @PutMapping
    public R updateById(@Valid @RequestBody SysSocialDetails sysSocialDetails) {
        sysSocialDetailsService.updateById(sysSocialDetails);
        return new R<>(Boolean.TRUE);
    }

    /**
     * 删除
     *
     * @param id
     * @return R
     */
    @SysLog("删除三方信息")
    @DeleteMapping("/{id}")
    public R removeById(@PathVariable Integer id) {
        return new R<>(sysSocialDetailsService.removeById(id));
    }

    /**
     * 通过社交账号、手机号查询用户、角色信息
     *
     * @param inStr appid@code
     * @return
     */
    @Inner
    @GetMapping("/info/{inStr}")
    public R getUserInfo(@PathVariable String inStr) {
        return new R<>(sysSocialDetailsService.getUserInfo(inStr));
    }

    /**
     * 绑定社交账号
     *
     * @param state 类型
     * @param code  code
     * @return
     */
    @PostMapping("/bind")
    public R bindSocial(String state, String code) {
        return new R<>(sysSocialDetailsService.bindSocial(state, code));
    }
}
