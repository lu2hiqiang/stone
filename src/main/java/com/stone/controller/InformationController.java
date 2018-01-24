package com.stone.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stone.bean.Information;
import com.stone.bean.InformationDescription;
import com.stone.bean.Msg;
import com.stone.service.InformationDescriptionService;
import com.stone.service.InformationService;

@Controller
@RequestMapping(value = "/Information")
public class InformationController {
	
	@Autowired
	InformationService informationService;
	@Autowired
	InformationDescriptionService descriptionService;
	
	
	/**
	 * 获取新闻列表
	 * page 页码
	 * typeId 新闻类型
	 */
	@RequestMapping(value = "/informationList",method = { RequestMethod.GET})
	@ResponseBody
	public Msg getInformationList(@RequestParam(value = "page") Integer page,@RequestParam(value = "typeId") Integer typeId){
		PageHelper.startPage(page, 10);
		// startPage后面紧跟的这个查询就是一个分页查询
		List<Information> informationList = informationService.selectInformationListByType(typeId);
		// 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		System.out.println("--------->  "+ informationList.size());
		PageInfo<Information> pageInfo = new PageInfo<Information>(informationList,10);
		return Msg.success().add("data", pageInfo);
	}
	
	/**
	 * 获取新闻详情
	 * Id 新闻Id
	 */
	@RequestMapping(value = "/informationDescription",method = { RequestMethod.GET})
	@ResponseBody
	public Msg getInformationList(@RequestParam(value = "id") Integer id){
		InformationDescription description = descriptionService.selectByPrimaryKey(id);
		return Msg.success().add("data", description);
	}
}
