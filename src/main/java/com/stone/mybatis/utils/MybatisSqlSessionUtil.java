package com.stone.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSqlSessionUtil {
	
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = null;
		try {
			InputStream inputStream = Resources.getResourceAsStream("listener-mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
