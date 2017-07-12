package com.showka.MyBatisDemo.common;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

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

}
