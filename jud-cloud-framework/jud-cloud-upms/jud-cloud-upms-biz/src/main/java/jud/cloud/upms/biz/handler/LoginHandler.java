package jud.cloud.upms.biz.handler;

import jud.cloud.upms.api.dto.UserInfo;

public interface LoginHandler {
    /**
     * 通过用户传入获取唯一标识
     *
     * @param loginStr
     * @return
     */
    String identify(String loginStr);

    /**
     * 通过openId 获取用户信息
     *
     * @param identify
     * @return
     */
    UserInfo info(String identify);

    /**
     * 处理方法
     *
     * @param loginStr 登录参数
     * @return
     */
    UserInfo handle(String loginStr);
}
