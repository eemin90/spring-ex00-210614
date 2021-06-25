package org.zerock.sample;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.Test2MapperTests;

import lombok.extern.log4j.Log4j;

public class StringSplitTests {

	@Test
	public void test() {
		String str1 = "java,spring,css";
		
		String[] arr1 = str1.split(",");
		
		assertEquals("java", arr1[0]);
		assertEquals("spring", arr1[1]);
		assertEquals("css", arr1[2]);
	}
	
	@Test
	public void test2() {
		String str1 = "TWC";
		String[] arr1 = str1.split("");
		
		assertEquals(3, arr1.length);
		assertEquals("T", arr1[0]);
		assertEquals("W", arr1[1]);
		assertEquals("C", arr1[2]);
	}

}
