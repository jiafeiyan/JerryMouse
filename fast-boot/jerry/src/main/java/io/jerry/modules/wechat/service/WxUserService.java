package io.jerry.modules.wechat.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.jerry.modules.wechat.entity.WxUserEntity;
import io.jerry.modules.wechat.form.WechatAuthForm;

import java.util.HashMap;


/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-14 20:36:50
 */
public interface WxUserService extends IService<WxUserEntity> {

    WxUserEntity queryByMobile(String mobile);

    String checkUser(WechatAuthForm form);

    HashMap<String, String> wechatLogin(String code);
}

