package jud.cloud.upms.biz.handler;

import jud.cloud.upms.api.dto.UserInfo;

public abstract class AbstractLoginHandler implements LoginHandler {
    /**
     * 处理方法
     *
     * @param loginStr 登录参数
     * @return
     */
    @Override
    public UserInfo handle(String loginStr) {
        String identify = identify(loginStr);
        return info(identify);
    }
}
