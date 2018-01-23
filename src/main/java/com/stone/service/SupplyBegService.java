package com.stone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.bean.SupplyBeg;
import com.stone.dao.SupplyBegMapper;

@Service
public class SupplyBegService {
	@Autowired
	SupplyBegMapper mapper;

	public List<SupplyBeg> getAllByTypeId(Integer typeId) {
		return mapper.selectAllByTypeId(typeId);
	}
	
	public List<SupplyBeg> selectAllByWithUser(Integer typeId) {
		return mapper.selectAllByWithUser(typeId);
	}
}
