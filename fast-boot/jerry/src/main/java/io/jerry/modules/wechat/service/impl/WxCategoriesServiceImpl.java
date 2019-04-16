package io.jerry.modules.wechat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;

import io.jerry.modules.wechat.dao.WxCategoriesDao;
import io.jerry.modules.wechat.entity.WxCategoriesEntity;
import io.jerry.modules.wechat.service.WxCategoriesService;


@Service("wxCategoriesService")
public class WxCategoriesServiceImpl extends ServiceImpl<WxCategoriesDao, WxCategoriesEntity> implements WxCategoriesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxCategoriesEntity> page = this.page(
                new Query<WxCategoriesEntity>().getPage(params),
                new QueryWrapper<WxCategoriesEntity>()
        );

        return new PageUtils(page);
    }

}