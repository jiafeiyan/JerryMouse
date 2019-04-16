/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package io.jerry.modules.wechat.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 登录表单
 *
 * @author Chen.y
 */
@Data
@ApiModel(value = "登录表单")
public class WechatAuthForm {

    @ApiModelProperty(value = "昵称")
    private String wxNickname;

    @ApiModelProperty(value = "密码")
    /*@NotBlank(message="密码不能为空")*/
    private String wxPassword;

    @ApiModelProperty(value = "手机号")
    @NotBlank(message="手机号不能为空")
    private String wxPhone;

    @ApiModelProperty(value = "性别")
    private String wxSex;

}
