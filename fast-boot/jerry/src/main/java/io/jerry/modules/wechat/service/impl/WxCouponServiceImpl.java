package io.jerry.modules.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.Query;
import io.jerry.common.utils.R;
import io.jerry.common.utils.UUIDUtils;
import io.jerry.modules.wechat.dao.WxCouponDao;
import io.jerry.modules.wechat.entity.WxCouponEntity;
import io.jerry.modules.wechat.entity.WxUserCouponEntity;
import io.jerry.modules.wechat.entity.WxUserEntity;
import io.jerry.modules.wechat.service.WxCouponService;
import io.jerry.modules.wechat.service.WxUserCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;


@Service("wxCouponService")
public class WxCouponServiceImpl extends ServiceImpl<WxCouponDao, WxCouponEntity> implements WxCouponService {

    @Autowired
    private WxUserCouponService wxUserCouponService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String now = LocalDate.now().toString().replace("-","");
        IPage<WxCouponEntity> page = this.page(
                new Query<WxCouponEntity>().getPage(params),
                new QueryWrapper<WxCouponEntity>().ge("coupon_expired",  now)
        );

        return new PageUtils(page);
    }

    @Override
    public List<WxCouponEntity> queryUserCoupon(String userId) {

        return null;
    }

    @Override
    public R receiveCoupon(String userId, String couponId) {
        WxCouponEntity couponEntity = this.listOne(couponId);
        if (couponEntity == null) {
            return R.error("查无此券或者该券已过期！");
        }

        WxUserCouponEntity userCouponEntity = wxUserCouponService.getBaseMapper()
                .selectOne(new QueryWrapper<WxUserCouponEntity>().eq("wx_user_id", userId)
                                                                 .eq("coupon_id", couponId));
        // 如果不为空，这表示已经领取过了
        if (userCouponEntity != null) {
            return R.error("该优惠券您已领取过！");
        } else {
            userCouponEntity = new WxUserCouponEntity();
            userCouponEntity.setWxUserId(userId);
            userCouponEntity.setCouponId(couponId);
            String nowTime = LocalTime.now().toString();
            userCouponEntity.setCouponGetTime(nowTime);
            wxUserCouponService.getBaseMapper().insert(userCouponEntity);
            return R.ok();
        }
    }

    @Override
    public WxCouponEntity listOne(String couponId) {
        String now = LocalDate.now().toString().replace("-","");
        return this.getOne(new QueryWrapper<WxCouponEntity>()
                .ge("coupon_expired",  now)
                .eq("coupon_id", couponId));
    }

}