package jud.cloud.upms.api.feign;

import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.core.constant.ServiceNameConstants;
import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.entity.SysLog;
import jud.cloud.upms.api.feign.factory.RemoteLogServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = ServiceNameConstants.UMPS_SERVICE, fallbackFactory = RemoteLogServiceFallbackFactory.class)
public interface RemoteLogService {
    /**
     * 保存日志
     *
     * @param sysLog 日志实体
     * @param from   是否内部调用
     * @return succes、false
     */
    @PostMapping("/log/save")
    R<Boolean> saveLog(@RequestBody SysLog sysLog, @RequestHeader(SecurityConstants.FROM) String from);
}
