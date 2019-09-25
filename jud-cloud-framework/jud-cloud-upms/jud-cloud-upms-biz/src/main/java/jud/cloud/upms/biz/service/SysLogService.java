package jud.cloud.upms.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jud.cloud.upms.api.entity.SysLog;
import jud.cloud.upms.api.vo.PreLogVo;

import java.util.List;

/**
 * 系统日志管理
 */
public interface SysLogService extends IService<SysLog> {
    /**
     * 批量插入前端错误日志
     *
     * @param preLogVoList 日志信息
     * @return true/false
     */
    Boolean saveBatchLogs(List<PreLogVo> preLogVoList);
}
