package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Test1VO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test1Tests {

	@Setter(onMethod_ = @Autowired)
	private Test1Mapper mapper;
	
	@Test
	public void testMapper() {
		assertNotNull(mapper);
	}
	
	@Test
	public void testGetList() {
		List<Test1VO> list = mapper.getList();
		
		assertTrue(list.size() > 0);
		
//		list.forEach(board -> log.info("testGetList: " + board)); 아래와 같은 코드
		for (Test1VO board : list) {
			log.info("testGetList: " + board);
		}
	}
	
	@Test
	public void testInsert() {
		Test1VO board = new Test1VO();
		board.setName("테스터");
		board.setAge(999);
		
		int cnt = mapper.insert(board);
		
		assertEquals(1, cnt);
		
		log.info("testInsert: " + board);
	}
	
	@Test
	public void testInsertSelectKey() {
		Test1VO board = new Test1VO();
		board.setName("테스터");
		board.setAge(999);
		
		int cnt = mapper.insertSelectKey(board);
		
		assertEquals(1, cnt);
		assertNotEquals(0, board.getId());
		
		log.info("testInsertSelectKey: " + board);
	}
	
	@Test
	public void testRead() {
		Test1VO board = mapper.read(3); // 존재하는 게시물 번호로 테스트
		
		assertNotNull(board);
		
		log.info("testRead: " + board);
	}
	
	@Test
	public void testDelete() {
		int cnt = mapper.delete(3); // 존재하는 게시물 번호로 테스트
		
		assertEquals(1, cnt);
		
		log.info("testDelete: " + cnt);
	}
	
	@Test
	public void testUpdate() {
		Test1VO board = new Test1VO();
		board.setId(2); // 존재하는 게시물 번호로 테스트
		board.setName("new name");
		board.setAge(777);
		
		int cnt = mapper.update(board);
		
		assertEquals(1, cnt);
		
		log.info("testUpdate: " + board);
	}

}
