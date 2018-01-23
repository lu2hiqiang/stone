package com.stone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.bean.InformationDescription;
import com.stone.dao.InformationDescriptionMapper;

@Service
public class InformationDescriptionService {
	@Autowired
	InformationDescriptionMapper mapper;

	public int insertSelective(InformationDescription description) {
		return mapper.insertSelective(description);
	}
	
}
