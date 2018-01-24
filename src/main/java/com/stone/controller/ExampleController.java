package com.stone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.bean.GoodsDescription;
import com.stone.bean.Msg;
import com.stone.service.GoodsDescriptionService;

@Controller
@RequestMapping(value="/example")
public class ExampleController {

	@Autowired
	GoodsDescriptionService goodsDescriptionService;
	
	@RequestMapping(value="/static")
	public String staticJump(){
		return "example/static";
	}
	
	@RequestMapping(value="/dynamic")
	public String dynamicJump(ModelMap map){
		GoodsDescription goodsDescription = goodsDescriptionService.selectByPrimaryKey("孔雀石");
		map.put("message", goodsDescription);
		return "example/dynamic";
	}
	
}
