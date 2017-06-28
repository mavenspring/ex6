package com.choa.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TableService {
	
	@Autowired
	private TableDAO tableDAO;
	
	@Transactional
	public int insertTable(TableADTO tableADTO,int num)throws Exception{
		tableDAO.insertTableA(tableADTO);
		TableBDTO tableBDTO = new TableBDTO();
		tableBDTO.setWriter(tableADTO.getWriter());
		tableBDTO.setNum(num);
		tableBDTO.setPoint(10);
		return tableDAO.insertTableB(tableBDTO);
	}
	
}
