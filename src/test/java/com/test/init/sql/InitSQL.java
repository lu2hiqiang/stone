package com.test.init.sql;

import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.stone.mybatis.utils.MybatisSqlSessionUtil;
import com.stone.utils.HttpUtil;


public class InitSQL {

	
	/*@Test
	public void initProducts(){
		int pageindex  = 100;
		boolean isTrue = true;
		String url;
		String result;
		while (isTrue) {
			pageindex++;
			url = "http://m.51ore.com/Resources/AjaxGetNewList?page="+pageindex+"&typeId=16";
			result = HttpUtil.Get(url);
			JSONObject object = JSONObject.fromObject(result);
			System.out.println("---- == " + object.getJSONArray("data").size());
			if(object.getJSONArray("data").size()>0){
				JSONArray array = object.getJSONArray("data");
				Product product;
				for (int i = 0; i < array.size(); i++) {
					product = new Product();
					product.setUserid(array.getJSONObject(i).optInt("UserId"));
					product.setTypename(array.getJSONObject(i).optString("TypeName"));
					product.setMinename(array.getJSONObject(i).optString("MineName"));
					product.setSum(array.getJSONObject(i).optString("sum"));
					product.setDealaddress(array.getJSONObject(i).optString("DealAddress"));
					product.setRemark(array.getJSONObject(i).optString("Remark"));
					System.out.println("TypeName ---- == " + array.getJSONObject(i).optString("TypeName"));
					String createTime = array.getJSONObject(i).optString("CreateTime");
					String timeString = createTime.substring(6, createTime.length()-3);
					product.setCreatetime(new Date(Long.parseLong(timeString)));
					product.setPrice(array.getJSONObject(i).optString("price"));
					product.setAuditid(array.getJSONObject(i).optInt("AuditId"));
					product.setAuditname(array.getJSONObject(i).optString("AuditName"));
					product.setSupplyorbegid(array.getJSONObject(i).optInt("SupplyOrBegId"));
					product.setCompanyname(array.getJSONObject(i).optString("CompanyName"));
					product.setName(array.getJSONObject(i).optString("Name"));
					product.setPhone(array.getJSONObject(i).optString("Phone"));
					product.setTradingflag(array.getJSONObject(i).optString("TradingFlag"));
					product.setPricetype(array.getJSONObject(i).optString("priceType"));
					product.setImgurl(array.getJSONObject(i).optString("ImgUrl"));
					product.setRownumber(array.getJSONObject(i).optString("RowNumber"));
					product.setCardjust(array.getJSONObject(i).optString("CardJust"));
					product.setLicense(array.getJSONObject(i).optString("License"));
					product.setMinelicense(array.getJSONObject(i).optString("MineLicense"));
					product.setDomainname(array.getJSONObject(i).optString("DomainName"));
					product.setPrimarykey(array.getJSONObject(i).optString("PrimaryKey"));
					product.setIsautoid(array.getJSONObject(i).optString("IsAutoID"));
					product.setConnname(array.getJSONObject(i).optString("connName"));
					SqlSession session = null;
					ProductMapper mapper;
					try {
						session = MybatisSqlSessionUtil.getSqlSession();
						mapper = session.getMapper(ProductMapper.class);
						int munber = mapper.insertSelective(product);
						session.commit();
					} finally {
						if (session != null)
							session.close();
					}
				}
				if(pageindex==120)
					isTrue = false;
			}else {
				isTrue = false;
			}
		}
	}*/
	
}
