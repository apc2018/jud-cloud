package jud.cloud.upms.api.feign.factory;

import feign.hystrix.FallbackFactory;
import jud.cloud.upms.api.feign.RemoteUserService;
import jud.cloud.upms.api.feign.fallback.RemoteUserServiceFallbackImpl;
import org.springframework.stereotype.Component;

@Component
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {
    @Override
    public RemoteUserService create(Throwable throwable) {
        RemoteUserServiceFallbackImpl remoteUserServiceFallback = new RemoteUserServiceFallbackImpl();
        remoteUserServiceFallback.setCause(throwable);
        return remoteUserServiceFallback;
    }
}
