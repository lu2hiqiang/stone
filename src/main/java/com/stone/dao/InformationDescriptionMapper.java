package com.stone.dao;

import com.stone.bean.InformationDescription;
import com.stone.bean.InformationDescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationDescriptionMapper {
    long countByExample(InformationDescriptionExample example);

    int deleteByExample(InformationDescriptionExample example);

    int deleteByPrimaryKey(Integer informationId);

    int insert(InformationDescription record);

    int insertSelective(InformationDescription record);

    List<InformationDescription> selectByExampleWithBLOBs(InformationDescriptionExample example);

    List<InformationDescription> selectByExample(InformationDescriptionExample example);

    InformationDescription selectByPrimaryKey(Integer informationId);

    int updateByExampleSelective(@Param("record") InformationDescription record, @Param("example") InformationDescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") InformationDescription record, @Param("example") InformationDescriptionExample example);

    int updateByExample(@Param("record") InformationDescription record, @Param("example") InformationDescriptionExample example);

    int updateByPrimaryKeySelective(InformationDescription record);

    int updateByPrimaryKeyWithBLOBs(InformationDescription record);
}