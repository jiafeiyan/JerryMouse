package io.jerry.modules.wechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.modules.wechat.dao.WxStoreProductDao;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;

import io.jerry.modules.wechat.entity.WxStoreProductEntity;
import io.jerry.modules.wechat.service.WxStoreProductService;


@Service("wxStoreProductService")
public class WxStoreProductServiceImpl extends ServiceImpl<WxStoreProductDao, WxStoreProductEntity> implements WxStoreProductService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxStoreProductEntity> page = this.page(
                new Query<WxStoreProductEntity>().getPage(params),
                new QueryWrapper<WxStoreProductEntity>()
        );

        return new PageUtils(page);
    }

}