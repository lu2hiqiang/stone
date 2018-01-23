package com.stone.dao;

import com.stone.bean.SupplyBeg;
import com.stone.bean.SupplyBegExample;
import com.stone.bean.SupplyBegKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplyBegMapper {
    long countByExample(SupplyBegExample example);

    int deleteByExample(SupplyBegExample example);

    int deleteByPrimaryKey(SupplyBegKey key);

    int insert(SupplyBeg record);

    int insertSelective(SupplyBeg record);

    List<SupplyBeg> selectByExampleWithBLOBs(SupplyBegExample example);

    List<SupplyBeg> selectByExample(SupplyBegExample example);
    
    SupplyBeg selectByPrimaryKey(SupplyBegKey key);

    int updateByExampleSelective(@Param("record") SupplyBeg record, @Param("example") SupplyBegExample example);

    int updateByExampleWithBLOBs(@Param("record") SupplyBeg record, @Param("example") SupplyBegExample example);

    int updateByExample(@Param("record") SupplyBeg record, @Param("example") SupplyBegExample example);

    int updateByPrimaryKeySelective(SupplyBeg record);

    int updateByPrimaryKeyWithBLOBs(SupplyBeg record);

    int updateByPrimaryKey(SupplyBeg record);

	List<SupplyBeg> selectAllByTypeId(@Param("typeId")Integer typeId);
	
	List<SupplyBeg> selectAllByWithUser(@Param("typeId")Integer typeId);
}