package com.choa.Ex6;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

//각각의 메서드에 @ResponseBody 붙여준거와 같다 
// 리턴할때 json 형식으로 자동으로 리턴해주는 annotation
@Controller
@RequestMapping(value="/memo/**")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	//list
	@RequestMapping(value="memoList")
	public void memoList(){
		
	}
	
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}")
	@ResponseBody //  돌아가는 곳이 data로 바로 감
	// 원하는 데이터만 바로 json 형식으로 바궈서 리턴해줌 
	public List<MemoDTO> memoList(@PathVariable("curPage") int curPage, @PathVariable String find, @PathVariable String search)throws Exception{
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		
		List<MemoDTO> list =memoService.boardList(listInfo);
		
		return list;
		
	}
	
	@RequestMapping(value="memoWrite" ,method = RequestMethod.POST)
	public List<MemoDTO> memoWrite(MemoDTO memoDTO,Model model)throws Exception{
		System.out.println("write : "+memoDTO.getWriter());
		int result = memoService.boardInsert(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);
		List<MemoDTO> list = memoService.boardList(listInfo);
		
		return list;
	}
	
	
	
	@RequestMapping(value="memoView/{num}")
	@ResponseBody
	//@PathVariable 주소의 값으로 변수에 맵핑
	public MemoDTO memoView(@PathVariable("num") int num)throws Exception{
		MemoDTO memoDTO = memoService.boardView(num);
		
		return memoDTO;
	}
	
}
