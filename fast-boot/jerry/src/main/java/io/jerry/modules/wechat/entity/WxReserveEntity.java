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
@TableName("wx_reserve")
public class WxReserveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 预约ID
	 */
	private String reserveId;
	/**
	 * 预约用户
	 */
	private String reserveUserId;
	/**
	 * 预约时间
	 */
	private String reserveTime;
	/**
	 * 预约门店
	 */
	private String reserveStoreid;

}
