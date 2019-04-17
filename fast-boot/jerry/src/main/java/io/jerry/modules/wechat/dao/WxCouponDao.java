package io.jerry.modules.wechat.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.jerry.modules.wechat.entity.WxCouponEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@Mapper
public interface WxCouponDao extends BaseMapper<WxCouponEntity> {

    List<WxCouponEntity> queryUserCoupon(String userId);
}
