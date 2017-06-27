package com.choa.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.board.BDTO;
import com.choa.util.ListInfo;

import oracle.net.aso.l;

@Service
public class MemoService {

	@Autowired
	private MemoDAO memoDAO;
	
	
	//list
	public List<MemoDTO> boardList(ListInfo listInfo)throws Exception{
		int count =memoDAO.boardCount(listInfo);
		listInfo.makePage(count);
		listInfo.setRow();
		return memoDAO.boardList(listInfo);
	}
	//view
	public MemoDTO boardView(int num)throws Exception{
		return memoDAO.boardView(num);
	}
	//inert
	public int boardInsert(MemoDTO memoDTO)throws Exception{
		return memoDAO.boardInsert(memoDTO);
	}
	//update
	public int boardUpdate(MemoDTO memoDTO)throws Exception{
		return memoDAO.boardUpdate(memoDTO);
	}
	//delete
	public int boardDelete(int num)throws Exception{
		return memoDAO.boardDelete(num);
	}
}
