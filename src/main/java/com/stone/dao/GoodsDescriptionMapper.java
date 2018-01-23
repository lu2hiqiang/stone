package com.stone.dao;

import com.stone.bean.GoodsDescription;
import com.stone.bean.GoodsDescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDescriptionMapper {
    long countByExample(GoodsDescriptionExample example);

    int deleteByExample(GoodsDescriptionExample example);

    int deleteByPrimaryKey(String goodsName);

    int insert(GoodsDescription record);

    int insertSelective(GoodsDescription record);

    List<GoodsDescription> selectByExampleWithBLOBs(GoodsDescriptionExample example);

    List<GoodsDescription> selectByExample(GoodsDescriptionExample example);

    GoodsDescription selectByPrimaryKey(String goodsName);

    int updateByExampleSelective(@Param("record") GoodsDescription record, @Param("example") GoodsDescriptionExample example);

    int updateByExampleWithBLOBs(@Param("record") GoodsDescription record, @Param("example") GoodsDescriptionExample example);

    int updateByExample(@Param("record") GoodsDescription record, @Param("example") GoodsDescriptionExample example);

    int updateByPrimaryKeySelective(GoodsDescription record);

    int updateByPrimaryKeyWithBLOBs(GoodsDescription record);
}