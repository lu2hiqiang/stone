package com.stone.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stone.bean.GoodsDescription;
import com.stone.bean.Information;
import com.stone.bean.InformationExample;
import com.stone.bean.InformationExample.Criteria;
import com.stone.service.GoodsDescriptionService;
import com.stone.service.InformationDescriptionService;
import com.stone.service.InformationService;

@Controller
@RequestMapping(value = "/XhEditorController")
public class XhEditorController {
	@Autowired
	private GoodsDescriptionService goodsDescriptionService;
	@Autowired
	private InformationService informationService;
	@Autowired
	private InformationDescriptionService informationDescriptionService;

	@RequestMapping("/xheditorStone")
	public String xheditorStone(){
		System.out.println("xhEditor-------------->");
		return "xheditor/xheditorStone";
	}
	
	@RequestMapping("/xheditorNews")
	public String xhEditorNews(){
		System.out.println("xhEditor-------------->");
		return "xheditor/xheditorNews";
	}
	
	@RequestMapping(value = "/xhEditorSubmit",method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public String xhEditorSubmit(HttpServletRequest request,
            HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
	        response.setHeader("Cache-Control", "no-cache");
	        String name = request.getParameter("name");
	        String description = request.getParameter("contents");
	        System.out.println("name-------------->" + name);
			System.out.println("description-------------->" + description);
			int result = goodsDescriptionService.insertSelective(new GoodsDescription(name,description));
			System.out.println("goodsDescriptionService insertSelective result is " + result);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "/xhEditorNewsSubmit",method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public String xhEditorNewsSubmit(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
			String name = request.getParameter("name");
			String titelUrl = request.getParameter("titelUrl");
			String author = request.getParameter("author");
			String edit = request.getParameter("edit");
			String date = request.getParameter("date");
			String description = request.getParameter("description");
			String contents = request.getParameter("contents");
			System.out.println("name-------------->" + name);
			System.out.println("author-------------->" + author);
			System.out.println("edit-------------->" + edit);
			System.out.println("description-------------->" + description);
			Information information = new Information(null, 1, name, description, titelUrl, author, edit, new Date(), 100);
			int result = informationService.insertSelective(information);
			System.out.println("informationService insertSelective result is " + result);
			
//			InformationExample example = new InformationExample(); 
//			Criteria createCriteria = example.createCriteria();
//			createCriteria.andTitelEqualTo(information.getTitel());
//			Information information2 = informationService.selectByTitel(information.getTitel());
//			System.out.println("informationService selectByTitel result is " + information2.getId());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping(value = "/uploadFileSubmit",method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public String uploadFileSubmit(HttpServletRequest request,
			HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			response.setHeader("Cache-Control", "no-cache");
//			String content = request.getParameter("contents");
//			String title = request.getParameter("title");
//			System.out.println("content-------------->" + content);
			System.out.println("uploadFileSubmit----start----------");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
