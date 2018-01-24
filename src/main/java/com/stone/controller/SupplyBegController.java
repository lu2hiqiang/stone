package com.stone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.bean.Msg;
import com.stone.bean.SupplyBeg;
import com.stone.service.SupplyBegService;
/**
* @Description: 供货，求购相关操作
* @author luzhiqiang
* @date 2018年1月19日 下午4:27:49
 */
@Controller
@RequestMapping(value = "/supplyBeg")
public class SupplyBegController {
	@Autowired
	private SupplyBegService supplyBegService;

	/**
	* @Description: 获取供求列表接口
	* @param page 页码
	* @param typeId 供求ID：1-供货，2，求购
	* @return Msg    返回类型
	 */
	@RequestMapping(value="/supplyBegList")
	@ResponseBody
	public Msg MsggetSupplyBegList(@RequestParam(value = "page") Integer page,@RequestParam(value = "typeId") Integer typeId){
		PageHelper.startPage(page, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<SupplyBeg> supplyBegs = supplyBegService.selectAllByWithUser(typeId);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		System.out.println("--------->  "+ supplyBegs.size());
		PageInfo<SupplyBeg> pageInfo = new PageInfo<SupplyBeg>(supplyBegs,10);
		return Msg.success().add("data", pageInfo);
	}
	
	
	
}
