package jud.cloud.common.security.component;

import cn.hutool.core.util.StrUtil;
import jud.cloud.common.core.constant.SecurityConstants;
import jud.cloud.common.security.annotation.Inner;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务间接口不鉴权处理逻辑
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
public class JudCloudSecurityInnerAspect {
    private final HttpServletRequest request;

    @Around("@annotation(inner)")
    public Object around(ProceedingJoinPoint point, Inner inner) throws Throwable {
        String header = request.getHeader(SecurityConstants.FROM);
        if (inner.value() && !StrUtil.equals(SecurityConstants.FROM_IN, header)) {
            log.warn("访问接口 {} 没有权限", point.getSignature().getName());
            throw new AccessDeniedException("Access is denied");
        }
        return point.proceed();
    }
}
