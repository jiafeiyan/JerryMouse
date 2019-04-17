package io.jerry.modules.wechat.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.jerry.common.utils.PageUtils;
import io.jerry.common.utils.R;
import io.jerry.common.utils.UUIDUtils;
import io.jerry.modules.wechat.entity.WxCouponEntity;
import io.jerry.modules.wechat.service.WxCouponService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;



/**
 * 
 *
 * @author chen.y
 * @email kimchy123@126.com
 * @date 2019-04-16 18:19:21
 */
@RestController
@RequestMapping("wechat/wxcoupon")
@Api("优惠券接口")
public class WxCouponController {
    @Autowired
    private WxCouponService wxCouponService;

    /**
     * 分页查询优惠券【未过期】
     */
    @RequestMapping("/list")
    @ApiOperation("分页查询优惠券【未过期】")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = wxCouponService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 查询当前用户的所有优惠券【未过期】
     */
    @RequestMapping("/listAll/{userId}")
    @ApiOperation("查询当前用户的所有优惠券【未过期】")
    public R userAll(@PathVariable("userId") String userId){
        return R.ok();
    }

    /**
     * 用户领取优惠券【未过期】
     */
    @RequestMapping("/save/{userId}/{couponId}")
    @ApiOperation("用户领取优惠券【未过期】")
    public R userReceiveCoupon(@PathVariable("userId") String userId,
                        @PathVariable("couponId") String couponId){
        return wxCouponService.receiveCoupon(userId, couponId);
    }

    /**
     * 查询单条优惠券信息【未过期】
     */
    @RequestMapping("/info/{couponId}")
    @ApiOperation("查询单条优惠券信息【未过期】")
    public R info(@PathVariable("couponId") String couponId){
        WxCouponEntity wxCoupon = wxCouponService.listOne(couponId);
        return R.ok().put("wxCoupon", wxCoupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WxCouponEntity wxCoupon){
        wxCoupon.setCouponId(UUIDUtils.getUUID());
		wxCouponService.save(wxCoupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody WxCouponEntity wxCoupon){
		wxCouponService.updateById(wxCoupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody String[] couponIds){
		wxCouponService.removeByIds(Arrays.asList(couponIds));

        return R.ok();
    }

}
