package com.choa.Ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDAOimpl;

public class DtoTest extends TestUnit{

	@Autowired
	private NoticeDAOimpl noticeDAOimpl;
	
	@Test
	public void test()throws Exception {
		BoardDTO boardDTO =	noticeDAOimpl.boardView(22);
		assertNotNull(boardDTO);
	}

}
