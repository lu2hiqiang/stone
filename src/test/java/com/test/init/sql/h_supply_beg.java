package com.test.init.sql;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.stone.bean.Goods;
import com.stone.bean.SupplyBeg;
import com.stone.bean.SupplyBegKey;
import com.stone.bean.User;
import com.stone.bean.UserExample;
import com.stone.bean.UserExample.Criteria;
import com.stone.dao.GoodsMapper;
import com.stone.dao.SupplyBegMapper;
import com.stone.dao.UserMapper;
import com.stone.mybatis.utils.MybatisSqlSessionUtil;
import com.stone.utils.HttpUtil;

public class h_supply_beg {

	@Test
	public void initTable(){
		int pageindex  = 30;
		int endindex  = pageindex + 10;
		boolean isTrue = true;
		String url;
		String result;
		while (isTrue) {
			pageindex++;
			url = "http://m.51ore.com/Resources/AjaxGetNewList?page="+pageindex+"&typeId=15";
			result = HttpUtil.Get(url);
			JSONObject object = JSONObject.fromObject(result);
			System.out.println("---- == " + pageindex);
			if(object.getJSONArray("data").size()>0){
				JSONArray array = object.getJSONArray("data");
				SupplyBeg supplyBeg;
				User user;
				for (int i = 0; i < array.size(); i++) {
					user = new User();
					user.setPhone(array.getJSONObject(i).optString("Phone"));
					user.setPassword("e10adc3949ba59abbe56e057f20f883e");
					user.setUserName(array.getJSONObject(i).optString("Name"));
					user.setCompanyName(array.getJSONObject(i).optString("CompanyName"));
					
					supplyBeg = new SupplyBeg();
					supplyBeg.setPhone(array.getJSONObject(i).optString("Phone"));
//					supplyBeg.setPhone("13307884188");
					supplyBeg.setName(array.getJSONObject(i).optString("MineName"));
					supplyBeg.setTypeName(array.getJSONObject(i).optString("TypeName"));
					supplyBeg.setSupplyBegId(2);
					supplyBeg.setAuditId("1");
					supplyBeg.setAccessCount(1000);
					supplyBeg.setAuditState(array.getJSONObject(i).optString("AuditName"));
					System.out.println("TypeName ---- == " + array.getJSONObject(i).optString("TypeName"));
					String createTime = array.getJSONObject(i).optString("CreateTime");
					String timeString = createTime.substring(6, createTime.length()-2);
					supplyBeg.setCreatDate(new Date(Long.parseLong(timeString)));
					supplyBeg.setGoodsNumber(array.getJSONObject(i).optString("sum"));
//					supplyBeg.setGoodsNumber((int)(Math.random()*900)+1000 + "吨");
					supplyBeg.setGoodsPrice(array.getJSONObject(i).optString("price"));
//					supplyBeg.setGoodsPrice("电议");
					supplyBeg.setAddress(array.getJSONObject(i).optString("DealAddress"));
					supplyBeg.setProductionTarget(array.getJSONObject(i).optString("Remark"));
					supplyBeg.setGoodsPicUrl(array.getJSONObject(i).optString("ImgUrl"));
					SqlSession session = null;
					SupplyBegMapper supplyBegMapper;
					GoodsMapper goodsMapper;
					UserMapper userMapper;
					UserExample userExample;
					try {
						session = MybatisSqlSessionUtil.getSqlSession();
						supplyBegMapper = session.getMapper(SupplyBegMapper.class);
						goodsMapper = session.getMapper(GoodsMapper.class);
						userMapper = session.getMapper(UserMapper.class);
						userExample = new UserExample();
						Criteria criteria = userExample.createCriteria();
						criteria.andPhoneEqualTo(user.getPhone());
						List<User> list = userMapper.selectByExample(userExample);
						System.out.println("=List<User>============>" + list.size());
						Goods goods = goodsMapper.selectByPrimaryKey(supplyBeg.getName());
						if(goods!=null){
							SupplyBegKey begKey = new SupplyBegKey();
							begKey.setName(supplyBeg.getName());
							begKey.setSupplyBegId(supplyBeg.getSupplyBegId());
							begKey.setPhone(supplyBeg.getPhone());
							begKey.setTypeName(supplyBeg.getTypeName());
							SupplyBeg supplyBeg2 = supplyBegMapper.selectByPrimaryKey(begKey);
							if(supplyBeg2==null){
								supplyBegMapper.insertSelective(supplyBeg);
							}
							if(list.size()==0){
								userMapper.insertSelective(user);
							}
						}
						session.commit();
					} finally {
						if (session != null)
							session.close();
					}
				}
				if(pageindex==endindex)
					isTrue = false;
			}else {
				isTrue = false;
			}
		}
	}
}
