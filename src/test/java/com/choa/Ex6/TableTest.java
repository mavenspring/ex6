package com.choa.Ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.table.TableService;
import com.choa.table.TableADTO;

public class TableTest extends TestUnit{
	
	@Autowired
	private TableService tableService;
	
	@Test
	public void test()throws Exception {
		TableADTO tableADTO = new TableADTO();
		tableADTO.setNum(4);
		tableADTO.setTitle("t2");
		tableADTO.setWriter("t2");
		int result = tableService.insertTable(tableADTO, 3);
		assertNotEquals(0, result);
		
	}

}
