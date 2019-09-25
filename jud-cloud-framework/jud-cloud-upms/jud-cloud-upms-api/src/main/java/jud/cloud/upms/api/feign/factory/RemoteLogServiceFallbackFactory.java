package jud.cloud.upms.api.feign.factory;

import feign.hystrix.FallbackFactory;
import jud.cloud.upms.api.feign.RemoteLogService;
import jud.cloud.upms.api.feign.fallback.RemoteLogServiceFallbackImpl;
import org.springframework.stereotype.Component;

@Component
public class RemoteLogServiceFallbackFactory implements FallbackFactory<RemoteLogService>  {
    @Override
    public RemoteLogService create(Throwable throwable) {
        RemoteLogServiceFallbackImpl remoteLogServiceFallback = new RemoteLogServiceFallbackImpl();
        remoteLogServiceFallback.setCause(throwable);
        return remoteLogServiceFallback;
    }
}
