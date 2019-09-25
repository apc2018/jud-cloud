package jud.cloud.upms.api.feign.fallback;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jud.cloud.common.core.util.R;
import jud.cloud.upms.api.feign.RemoteTokenService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class RemoteTokenServiceFallbackImpl implements RemoteTokenService {
    @Setter
    private Throwable cause;

    /**
     * 分页查询token 信息
     *
     * @param params 分页参数
     * @param from   内部调用标志
     * @return page
     */
    @Override
    public R<Page> getTokenPage(Map<String, Object> params, String from) {
        log.error("调用认证中心查询token 失败", cause);
        return null;
    }

    /**
     * 删除token
     *
     * @param token
     * @param from  内部调用标志
     * @return
     */
    @Override
    public R<Boolean> removeTokenById(String token, String from) {
        log.error("删除token 失败 {}", token, cause);
        return null;
    }
}
