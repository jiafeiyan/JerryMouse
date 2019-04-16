package io.jerry.modules.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:20
 */
@Data
@TableName("wx_user_coupon")
public class WxUserCouponEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String wxUserId;
	/**
	 * 优惠券ID
	 */
	private String couponId;
	/**
	 * 领取时间
	 */
	private String couponGetTime;
	/**
	 * 优惠券状态
	 */
	private String couponStatus;

}
