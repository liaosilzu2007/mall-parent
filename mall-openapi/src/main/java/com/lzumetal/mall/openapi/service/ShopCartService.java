package com.lzumetal.mall.openapi.service;


import com.lzumetal.mall.openapi.vo.ShopCartVo;

/**
 * 购物车业务
 *
 * @author liaosi
 * @date 2018-08-26
 */
public interface ShopCartService {


    ShopCartVo getByUserId(long userid);

}
