package jud.cloud.upms.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jud.cloud.upms.api.entity.SysDict;
import jud.cloud.upms.biz.mapper.SysDictMapper;
import jud.cloud.upms.biz.service.SysDictService;
import org.springframework.stereotype.Service;

@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDict> implements SysDictService {
}
