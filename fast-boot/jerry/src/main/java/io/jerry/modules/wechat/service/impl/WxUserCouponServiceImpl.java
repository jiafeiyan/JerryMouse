package io.jerry.modules.wechat.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;

import io.jerry.modules.wechat.dao.WxUserCouponDao;
import io.jerry.modules.wechat.entity.WxUserCouponEntity;
import io.jerry.modules.wechat.service.WxUserCouponService;


@Service("wxUserCouponService")
public class WxUserCouponServiceImpl extends ServiceImpl<WxUserCouponDao, WxUserCouponEntity> implements WxUserCouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<WxUserCouponEntity> page = this.page(
                new Query<WxUserCouponEntity>().getPage(params),
                new QueryWrapper<WxUserCouponEntity>()
        );

        return new PageUtils(page);
    }

}