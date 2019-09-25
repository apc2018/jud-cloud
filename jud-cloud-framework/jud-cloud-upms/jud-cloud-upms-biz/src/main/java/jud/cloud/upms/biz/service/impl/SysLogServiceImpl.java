package jud.cloud.upms.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jud.cloud.common.core.constant.CommonConstants;
import jud.cloud.upms.api.entity.SysLog;
import jud.cloud.upms.api.vo.PreLogVo;
import jud.cloud.upms.biz.mapper.SysLogMapper;
import jud.cloud.upms.biz.service.SysLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {
    /**
     * 批量插入前端错误日志
     *
     * @param preLogVoList 日志信息
     * @return true/false
     */
    @Override
    public Boolean saveBatchLogs(List<PreLogVo> preLogVoList) {
        List<SysLog> sysLogs = preLogVoList.stream()
                .map(pre -> {
                    SysLog log = new SysLog();
                    log.setType(CommonConstants.STATUS_LOCK);
                    log.setTitle(pre.getInfo());
                    log.setException(pre.getStack());
                    log.setParams(pre.getMessage());
                    log.setCreateTime(LocalDateTime.now());
                    log.setRequestUri(pre.getUrl());
                    log.setCreateBy(pre.getUser());
                    return log;
                })
                .collect(Collectors.toList());
        return this.saveBatch(sysLogs);
    }
}
