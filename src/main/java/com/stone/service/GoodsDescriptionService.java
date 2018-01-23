package com.stone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.bean.GoodsDescription;
import com.stone.dao.GoodsDescriptionMapper;

@Service
public class GoodsDescriptionService {
	@Autowired
	GoodsDescriptionMapper mapper;

	public int insertSelective(GoodsDescription goodsDescription) {
		return mapper.insertSelective(goodsDescription);
	}
	
	public GoodsDescription selectByPrimaryKey(String goodsName) {
		return mapper.selectByPrimaryKey(goodsName);
	}
}
