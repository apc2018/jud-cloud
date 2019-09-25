package jud.cloud.upms.api.feign.fallback;

import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.entity.SysLog;
import jud.cloud.upms.api.feign.RemoteLogService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RemoteLogServiceFallbackImpl implements RemoteLogService {
    @Setter
    private Throwable cause;

    /**
     * 保存日志
     *
     * @param sysLog
     * @param from
     * @return R
     */
    @Override
    public R<Boolean> saveLog(SysLog sysLog, String from) {
        log.error("feign 插入日志失败", cause);
        return null;
    }
}
