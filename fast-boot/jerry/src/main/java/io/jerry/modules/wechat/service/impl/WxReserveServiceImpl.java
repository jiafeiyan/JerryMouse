package io.jerry.modules.wechat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;

import io.jerry.modules.wechat.dao.WxReserveDao;
import io.jerry.modules.wechat.entity.WxReserveEntity;
import io.jerry.modules.wechat.service.WxReserveService;


@Service("wxReserveService")
public class WxReserveServiceImpl extends ServiceImpl<WxReserveDao, WxReserveEntity> implements WxReserveService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxReserveEntity> page = this.page(
                new Query<WxReserveEntity>().getPage(params),
                new QueryWrapper<WxReserveEntity>()
        );

        return new PageUtils(page);
    }

}