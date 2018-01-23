package com.test.init.sql;

import java.util.List;

import net.sf.json.JSONArray;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.stone.bean.Goods;
import com.stone.bean.GoodsExample;
import com.stone.bean.GoodsExample.Criteria;
import com.stone.dao.GoodsMapper;
import com.stone.mybatis.utils.MybatisSqlSessionUtil;
import com.stone.utils.HttpUtil;

public class h_goods {

//	@Test
//	public void initTable(){
//		int value = 16;
//		String url = "http://m.51ore.com/Member/GetListMine";
//		String result = HttpUtil.Post(url, "typeId="+value);
//		System.out.println(result);
//		JSONArray array = JSONArray.fromObject(result);
//		Goods goods=null;
//		value = value-5;
//		System.out.println("****************"+value+"*****************");
//		System.out.println("****************"+array.size()+"*****************");
//		for (int i = 0; i < array.size(); i++) {
//			goods = new Goods();
//			String mineName = array.getJSONObject(i).optString("MineName");
//			goods.setGoodsName(mineName);
//			goods.setGoodsTypeId(""+value);
//			updateOrInsertTable(goods, String.valueOf(value));
//		}
//	}

	private void updateOrInsertTable(Goods goods, String value) {
		SqlSession session = null;
		GoodsMapper mapper;
		try {
			session = MybatisSqlSessionUtil.getSqlSession();
			mapper = session.getMapper(GoodsMapper.class);
			Goods goods1 = mapper.selectByPrimaryKey(goods.getGoodsName());
			int result;
			if (goods1!=null) {
				value = goods1.getGoodsTypeId()+","+value;
				goods1.setGoodsTypeId(value);
				result = mapper.updateByPrimaryKeySelective(goods1);
			}else{
				result = mapper.insertSelective(goods);
			}
			System.out.println("value------------>" + value);
			System.out.println("result------------>" + result);
			session.commit();
		} finally {
			if (session != null)
				session.close();
		}
		
	}
	
	@Test
	public void selectByGoodsType() {
		SqlSession session = null;
		GoodsMapper mapper;
		try {
			session = MybatisSqlSessionUtil.getSqlSession();
			mapper = session.getMapper(GoodsMapper.class);
			List<Goods> goodsList = mapper.selectByGoodsType("107,108");
			System.out.println("goodsList------------>" + goodsList.size());
			for (int i = 0; i < goodsList.size(); i++) {
				System.out.println("goodsname------------>" + goodsList.get(i).getGoodsName());
			}
			session.commit();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
