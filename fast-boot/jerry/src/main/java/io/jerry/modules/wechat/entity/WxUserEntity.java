package io.jerry.modules.wechat.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-14 20:36:50
 */
@Data
@TableName("wx_user")
public class WxUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String wxUserId;
	/**
	 * 
	 */
	private String wxNickname;
	/**
	 * 
	 */
	private String wxPassword;
	/**
	 * 
	 */
	private String wxPhone;
	/**
	 * 
	 */
	private String wxSex;
	/**
	 * 
	 */
	private Date createTime;

}
