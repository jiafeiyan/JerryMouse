package io.jerry.modules.wechat.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jerry.modules.wechat.entity.WxStoreEntity;
import io.jerry.modules.wechat.service.WxStoreService;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.R;



/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@RestController
@RequestMapping("wechat/wxstore")
public class WxStoreController {
    @Autowired
    private WxStoreService wxStoreService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = wxStoreService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{storeId}")
    public R info(@PathVariable("storeId") String storeId){
		WxStoreEntity wxStore = wxStoreService.getById(storeId);

        return R.ok().put("wxStore", wxStore);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WxStoreEntity wxStore){
		wxStoreService.save(wxStore);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WxStoreEntity wxStore){
		wxStoreService.updateById(wxStore);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] storeIds){
		wxStoreService.removeByIds(Arrays.asList(storeIds));

        return R.ok();
    }

}
