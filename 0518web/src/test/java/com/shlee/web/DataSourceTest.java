package com.shlee.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//class의 동일한 위치(resources/) 스프링 설정 파일이 있을 때는 classpath:/사용
//그 외 위치에 존재 할 경우는 file:경로 입력 후 사용
@ContextConfiguration(locations=("file:src/main/webapp/WEB-INF/spring/root-context.xml"))
public class DataSourceTest {

	@Autowired
	private DataSource ds;
	
	@Test
	public void test() {
		try(Connection con = ds.getConnection()){
			System.out.println(con);
			System.out.println("연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
