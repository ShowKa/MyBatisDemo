package com.showka.MyBatisDemo.system.util;

import org.junit.Test;

import junit.framework.TestCase;

public class CryptUtilTest extends TestCase {

	@Test
	public void testEncrypt() throws Exception {
		String target = "ABC";
		String encrypted = CryptUtil.encrypt(target);
		assertEquals(encrypted, "CCC" + target);

	}

	@Test
	public void testDecrypt() throws Exception {
		String encrypted = "CCCABC";
		String decyrpted = CryptUtil.decrypt(encrypted);
		assertEquals("ABC", decyrpted);
	}

}
