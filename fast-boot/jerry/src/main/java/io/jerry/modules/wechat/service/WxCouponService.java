package io.jerry.modules.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.R;
import io.jerry.modules.wechat.entity.WxCouponEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
public interface WxCouponService extends IService<WxCouponEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<WxCouponEntity> selectUserCoupon(String userId);

    R receiveCoupon(String userId, String couponId);

    WxCouponEntity listOne(String couponId);
}

