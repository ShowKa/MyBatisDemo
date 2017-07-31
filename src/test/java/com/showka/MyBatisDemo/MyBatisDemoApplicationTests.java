package com.showka.MyBatisDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySources({ @PropertySource("classpath:framework.properties") })
public class MyBatisDemoApplicationTests {

	@Test
	public void contextLoads() {
	}

}
