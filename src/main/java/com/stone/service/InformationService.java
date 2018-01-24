package com.stone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stone.bean.Information;
import com.stone.bean.InformationExample;
import com.stone.dao.InformationMapper;

@Service
public class InformationService {
	@Autowired
	InformationMapper mapper;

	public int insertSelective(Information information) {
		return mapper.insertSelective(information);
	}

	public Information selectByTitel(String titel) {
		return mapper.selectByTitel(titel);
	}

	public List<Information> selectInformationListByType(Integer typeId) {
		return mapper.selectInformationListByType(typeId);
	}
	
}