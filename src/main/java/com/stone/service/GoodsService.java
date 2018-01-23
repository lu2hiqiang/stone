package com.stone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.bean.Goods;
import com.stone.dao.GoodsMapper;

@Service
public class GoodsService {

	@Autowired
	GoodsMapper mapper;
	
	public List<Goods> getAll() {
		return mapper.selectByExample(null);
	}
	
	public List<Goods> selectByGoodsType(String goodsType) {
		return mapper.selectByGoodsType(goodsType);
	}
	
}
