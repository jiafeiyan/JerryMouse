package io.jerry.modules.wechat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.jerry.modules.wechat.dao.WxUserDao;
import io.jerry.modules.wechat.entity.WxUserEntity;
import io.jerry.modules.wechat.form.WechatAuthForm;
import io.jerry.modules.wechat.service.WxUserService;
import org.springframework.stereotype.Service;


@Service("wxUserService")
public class WxUserServiceImpl extends ServiceImpl<WxUserDao, WxUserEntity> implements WxUserService {


    @Override
    public WxUserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<WxUserEntity>().eq("wx_phone", mobile));
    }

    @Override
    public String checkUser(WechatAuthForm form) {
        WxUserEntity userEntity = queryByMobile(form.getWxPhone());

        return userEntity == null ? null : userEntity.getWxUserId();

    }
}
