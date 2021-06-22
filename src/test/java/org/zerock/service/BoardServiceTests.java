package org.zerock.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("new title");
		board.setContent("new content");
		board.setWriter("tester");
		
		service.register(board);
		
		assertNotEquals(0, board.getBno());
	}
	
	@Test
	public void testGetList() {
		List<BoardVO> list = service.getList();
		
		assertNotNull(list);
		assertTrue(list.size() > 0);
	}
	
	@Test
	public void testGet() {
		BoardVO board = service.get(1L);
		
		assertEquals(1L, board.getBno());
	}
	
	@Test
	public void testModify() {
		String title = "modified title";
		String content = "modified content";
		
		BoardVO board = service.get(1L);
		board.setTitle(title);
		board.setContent(content);
		
		service.modify(board);
		
		board = service.get(1L);
		
		assertEquals("modified title", board.getTitle());
		assertEquals("modified content", board.getContent());
	}
	
	@Test
	public void testRemove() {
		Long key = 19L;
		assertFalse(service.remove(key));
		
		// 한 개 입력 후 삭제
		BoardVO board = new BoardVO();
		board.setTitle("title");
		board.setContent("content");
		board.setWriter("writer");
		
		service.register(board);
		
		assertTrue(service.remove(board.getBno()));
	}
}
