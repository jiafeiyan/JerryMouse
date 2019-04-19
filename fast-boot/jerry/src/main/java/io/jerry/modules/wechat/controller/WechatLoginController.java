package io.jerry.modules.wechat.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jerry.common.utils.R;
import io.jerry.common.utils.UUIDUtils;
import io.jerry.common.validator.ValidatorUtils;
import io.jerry.modules.app.utils.JwtUtils;
import io.jerry.modules.wechat.entity.WxUserEntity;
import io.jerry.modules.wechat.form.WechatAuthForm;
import io.jerry.modules.wechat.service.WxUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-14 20:36:50
 */
@RestController
@RequestMapping("/wechat")
@Api("微信登录接口")
public class WechatLoginController {


    @Autowired
    private WxUserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 登录
     */
    @PostMapping("oauth")
    @ApiOperation("登录")
    public R login(@RequestBody Map<String, Object> params){
        String code = (String)params.get("code");

        HashMap<String, String> wechatAuthCode = userService.wechatLogin(code);

        // 获取token
        String token = jwtUtils.generateToken(wechatAuthCode.get("openid"));

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());


        return R.ok(map);
    }

    /**
     * 登录
     */
    @PostMapping("login")
    @ApiOperation("登录")
    public R login(@RequestBody WechatAuthForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);

        // 检查是否存在记录
        String userId = userService.checkUser(form);

        // 无记录插入
        if (userId == null){
            userId = UUIDUtils.getUUID();
            WxUserEntity user = new WxUserEntity();
            user.setWxNickname(form.getWxNickname());
            user.setWxPhone(form.getWxPhone());
            user.setWxSex(form.getWxSex());
            user.setWxUserId(userId);
            user.setCreateTime(new Date());
            userService.save(user);
        }

        // 获取token
        String token = jwtUtils.generateToken(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", jwtUtils.getExpire());

        return R.ok(map);

    }

}
