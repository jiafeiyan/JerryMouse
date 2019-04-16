package io.jerry.modules.wechat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;

import io.jerry.modules.wechat.dao.WxProductDao;
import io.jerry.modules.wechat.entity.WxProductEntity;
import io.jerry.modules.wechat.service.WxProductService;


@Service("wxProductService")
public class WxProductServiceImpl extends ServiceImpl<WxProductDao, WxProductEntity> implements WxProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxProductEntity> page = this.page(
                new Query<WxProductEntity>().getPage(params),
                new QueryWrapper<WxProductEntity>()
        );

        return new PageUtils(page);
    }

}