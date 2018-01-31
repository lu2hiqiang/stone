package com.stone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.stone.bean.GoodsType;
import com.stone.bean.Msg;
import com.stone.service.GoodsTypeService;

/**
* @Description: 原料操作
* @author luzhiqiang
* @date 2018年1月31日 上午11:12:04
 */
@Controller
@RequestMapping(value = "/goodsType")
public class GoodsTypeController {
	
	@Autowired
	GoodsTypeService goodsTypeService;

	@RequestMapping(value="/all")
	@ResponseBody
	public Msg getGoodsTypeService(){
		List<GoodsType> list = goodsTypeService.getAllPuls();
		if(list.size() > 0)
			
			return Msg.success().add("data", list);
		else {
			return Msg.fail();
		}
	}
	
}
