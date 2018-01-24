package com.stone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.bean.Goods;
import com.stone.bean.GoodsType;
import com.stone.bean.GoodsTypeExample;
import com.stone.dao.GoodsMapper;
import com.stone.dao.GoodsTypeMapper;

@Service
public class GoodsTypeService {

	@Autowired
	GoodsTypeMapper mapper;
	
	public List<GoodsType> getAll() {
		return mapper.selectByExample(null);
	}
	
}
