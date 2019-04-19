package io.jerry.modules.wechat.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import io.jerry.modules.wechat.dao.WxUserDao;
import io.jerry.modules.wechat.entity.WxUserEntity;
import io.jerry.modules.wechat.form.WechatAuthForm;
import io.jerry.modules.wechat.service.WxUserService;
import io.jerry.modules.wechat.utils.WechatAuthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;


@Service("wxUserService")
public class WxUserServiceImpl extends ServiceImpl<WxUserDao, WxUserEntity> implements WxUserService {

    private RestTemplate wxAuthRestTemplate = new RestTemplate();

    @Autowired
    private WechatAuthProperties wechatAuthProperties;

    @Override
    public HashMap<String, String> wechatLogin(String code) {
        String urlString = "?appid={appid}&secret={srcret}&js_code={code}&grant_type={grantType}";
        String response = wxAuthRestTemplate.getForObject(
                wechatAuthProperties.getSessionHost() + urlString, String.class,
                wechatAuthProperties.getAppId(),
                wechatAuthProperties.getSecret(),
                code,
                wechatAuthProperties.getGrantType());
        HashMap<String, String> map = JSON.parseObject(response, HashMap.class);
        return map;
    }

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
