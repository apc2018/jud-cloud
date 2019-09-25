package jud.cloud.upms.api.feign.factory;

import feign.hystrix.FallbackFactory;
import jud.cloud.upms.api.feign.RemoteTokenService;
import jud.cloud.upms.api.feign.fallback.RemoteTokenServiceFallbackImpl;
import org.springframework.stereotype.Component;

@Component
public class RemoteTokenServiceFallbackFactory implements FallbackFactory<RemoteTokenService> {
    @Override
    public RemoteTokenService create(Throwable throwable) {
        RemoteTokenServiceFallbackImpl remoteTokenServiceFallback = new RemoteTokenServiceFallbackImpl();
        remoteTokenServiceFallback.setCause(throwable);
        return remoteTokenServiceFallback;
    }
}
