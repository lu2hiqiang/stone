package com.stone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.bean.Goods;
import com.stone.bean.GoodsType;
import com.stone.bean.Msg;
import com.stone.service.GoodsService;
import com.stone.service.GoodsTypeService;

/**
* @Description: 矿材操作请求
* @author luzhiqiang
* @date 2018年1月18日 下午5:21:37
 */
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
	
	@Autowired
	GoodsService goodsService;
	@Autowired
	GoodsTypeService goodsTypeService;

	/*@RequestMapping(value = "/list")
	@ResponseBody
	public Msg getGoods(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		PageHelper.startPage(pn, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Goods> emps = goodsService.getAll();
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		System.out.println("--------->"+ emps.size());
		return Msg.success().add("pageInfo", new PageInfo<Goods>(emps, 10));
	}
	*/
	
	@RequestMapping(value="/getGoods")
	@ResponseBody
	public Msg getGoodsByGoodsType(@RequestParam(value = "type",defaultValue = "101") String goodsType){
		List<Goods> list = goodsService.selectByGoodsType(goodsType);
		if(list.size() > 0)
			return Msg.success().add("data", list);
		else {
			return Msg.fail();
		}
	}
	
	@RequestMapping(value="/goodsTypeList")
	@ResponseBody
	public Msg getGoodsTypeService(){
		List<GoodsType> list = goodsTypeService.getAll();
		if(list.size() > 0)
			return Msg.success().add("data", list);
		else {
			return Msg.fail();
		}
	}
	
}
