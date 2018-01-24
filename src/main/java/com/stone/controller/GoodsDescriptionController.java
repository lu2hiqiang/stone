package com.stone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.bean.Goods;
import com.stone.bean.GoodsDescription;
import com.stone.bean.Msg;
import com.stone.service.GoodsDescriptionService;
import com.stone.service.GoodsService;

/**
* @Description: 矿材介绍相关请求
* @author luzhiqiang
* @date 2018年1月18日 下午5:21:37
 */
@Controller
@RequestMapping(value = "/GoodsDescription")
public class GoodsDescriptionController {
	
	@Autowired
	GoodsDescriptionService goodsDescriptionService;

	@RequestMapping(value="/getDescription")
	@ResponseBody
	public Msg getGoodsDescriptionByName(@RequestParam(value = "goodsName") String goodsName){
		GoodsDescription goodsDescription = goodsDescriptionService.selectByPrimaryKey(goodsName); 
		return Msg.success().add("data", goodsDescription);
	}
	
}
