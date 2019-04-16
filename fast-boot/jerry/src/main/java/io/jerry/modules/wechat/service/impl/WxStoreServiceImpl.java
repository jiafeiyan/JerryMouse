package io.jerry.modules.wechat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;

import io.jerry.modules.wechat.dao.WxStoreDao;
import io.jerry.modules.wechat.entity.WxStoreEntity;
import io.jerry.modules.wechat.service.WxStoreService;


@Service("wxStoreService")
public class WxStoreServiceImpl extends ServiceImpl<WxStoreDao, WxStoreEntity> implements WxStoreService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxStoreEntity> page = this.page(
                new Query<WxStoreEntity>().getPage(params),
                new QueryWrapper<WxStoreEntity>()
        );

        return new PageUtils(page);
    }

}