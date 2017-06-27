package com.choa.Ex6;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.choa.board.BDTO;
import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;

public class MemoTest extends TestUnit{

	@Autowired
	private MemoService memoService;
	
	private static MemoDTO memoDTO;
	
	@Test
	public void test()throws Exception {
		int result = memoService.boardInsert(memoDTO);
		System.out.println("memoTest :"+result);
	}
	
	@BeforeClass
	public static void memo(){
		String data ="test";
		memoDTO = new MemoDTO();
		memoDTO.setWriter(data);
		memoDTO.setContents(data);
	}

}
