package io.jerry.modules.wechat.controller;

import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.R;
import io.jerry.modules.wechat.entity.WxReserveEntity;
import io.jerry.modules.wechat.service.WxReserveService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;



/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@RestController
@RequestMapping("wechat/wxreserve")
public class WxReserveController {
    @Autowired
    private WxReserveService wxReserveService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestBody Map<String, Object> params){
        PageUtils page = wxReserveService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{reserveId}")
    public R info(@PathVariable("reserveId") String reserveId){
		WxReserveEntity wxReserve = wxReserveService.getById(reserveId);

        return R.ok().put("wxReserve", wxReserve);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WxReserveEntity wxReserve){
		wxReserveService.save(wxReserve);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WxReserveEntity wxReserve){
		wxReserveService.updateById(wxReserve);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] reserveIds){
		wxReserveService.removeByIds(Arrays.asList(reserveIds));

        return R.ok();
    }

}
