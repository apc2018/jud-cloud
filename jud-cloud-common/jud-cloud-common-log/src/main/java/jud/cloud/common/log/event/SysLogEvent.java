package jud.cloud.common.log.event;

import jud.cloud.upms.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * 日志事件
 */
public class SysLogEvent extends ApplicationEvent {
    public SysLogEvent(SysLog source) {
        super(source);
    }
}
