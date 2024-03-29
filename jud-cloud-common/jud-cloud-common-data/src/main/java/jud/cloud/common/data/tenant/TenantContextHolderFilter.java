package jud.cloud.common.data.tenant;

import cn.hutool.core.util.StrUtil;
import jud.cloud.common.core.constant.CommonConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class TenantContextHolderFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String tenantId = request.getHeader(CommonConstants.TENANT_ID);
        log.debug("获取header中的租户ID为:{}", tenantId);

        if (StrUtil.isNotBlank(tenantId)) {
            TenantContextHolder.setTenantId(Integer.parseInt(tenantId));
        } else {
            TenantContextHolder.setTenantId(1);
        }

        filterChain.doFilter(request, response);
        TenantContextHolder.clear();
    }
}
