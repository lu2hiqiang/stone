package com.stone.dao;

import com.stone.bean.InformationType;
import com.stone.bean.InformationTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationTypeMapper {
    long countByExample(InformationTypeExample example);

    int deleteByExample(InformationTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InformationType record);

    int insertSelective(InformationType record);

    List<InformationType> selectByExample(InformationTypeExample example);

    InformationType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InformationType record, @Param("example") InformationTypeExample example);

    int updateByExample(@Param("record") InformationType record, @Param("example") InformationTypeExample example);

    int updateByPrimaryKeySelective(InformationType record);

    int updateByPrimaryKey(InformationType record);
}