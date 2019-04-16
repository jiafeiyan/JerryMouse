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
 * @date 2019-04-16 18:19:21
 */
@Data
@TableName("wx_coupon")
public class WxCouponEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 优惠券id
	 */
	private String couponId;
	/**
	 * 优惠券金额
	 */
	private String couponAmount;
	/**
	 * 优惠券描述
	 */
	private String couponAmoutDes;
	/**
	 * 优惠券隶属
	 */
	private String couponBelong;
	/**
	 * 优惠券生效日期
	 */
	private String couponEffective;
	/**
	 * 优惠券失效日期
	 */
	private String couponExpired;

}
