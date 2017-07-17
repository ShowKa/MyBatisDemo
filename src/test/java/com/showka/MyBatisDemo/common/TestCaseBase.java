package com.showka.MyBatisDemo.common;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.showka.MyBatisDemo.system.exception.LoginUser;

import junit.framework.TestCase;

/**
 * Base Test Case Class for Crud1 Service Class.
 * 
 * @author ShowKa
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public abstract class TestCaseBase extends TestCase {

	@Autowired
	HttpSession session;

	@Before
	public void before() {
		LoginUser user = new LoginUser("UnitTest", "単体テストユーザー");
		session.setAttribute("user", user);
	}

}
