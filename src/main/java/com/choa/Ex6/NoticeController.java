package com.choa.Ex6;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceimpl;
import com.choa.util.ListInfo;
import com.choa.util.MakePage;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

@Controller
@RequestMapping(value="/notice/**") //모든 파일+폴더
public class NoticeController {
	
	@Inject//root-context에서 작성한 type으로 찾음
	private NoticeServiceimpl noticeService;
	
	
	@RequestMapping(value="noticeList", method = RequestMethod.GET)
	public String noticeList(Model model, ListInfo listInfo)throws Exception{
		
		List<BoardDTO> ar = noticeService.boardList(listInfo);
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		model.addAttribute("listInfo", listInfo);
	
		return "board/boardList";
		
	}
	//Write
	@RequestMapping(value="noticeWrite", method = RequestMethod.GET)
	public void noticeWrite(Model model, HttpServletRequest request)throws Exception{
		String path = request.getParameter("path");
	
		if(path==null || path ==""){
			path = "Write";
		}else{
			path = "Update";
		}
		model.addAttribute("path", path);
	}
	//Write
	@RequestMapping(value="noticeWrite", method = RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, RedirectAttributes rd)throws Exception{
		
		int result =noticeService.boardWrite(noticeDTO);
		String message ="글쓰기 실패";
		if(result>0	){
			message="글쓰기 성공!";
		}
	
		rd.addFlashAttribute("message", message);  // 주소창에 데이터가 안보임
		/*rd.addAttribute("message", message);*/   // 주소창에 데이터가 보임
		return "redirect:noticeList?curPage=1";
		
	}
	//View
	@RequestMapping(value="noticeView", method = RequestMethod.GET)
	public void noticeView(Integer num,Model model)throws Exception{
		if(num==null){}
	    BoardDTO boardDTO = noticeService.boardView(num);
	    model.addAttribute("dto", boardDTO);
	}
	
	//Update , 데이터 가져오기
	@RequestMapping(value="noticeUpdate", method = RequestMethod.GET)
	public String noticeUpdate(@RequestParam(defaultValue="1") Integer num , Model model,RedirectAttributes rd)throws Exception{
		BoardDTO boardDTO = noticeService.boardView(num);
		
		rd.addFlashAttribute("dto", boardDTO);
		/*rd.addFlashAttribute("path", "Update");*/
		/*model.addAttribute("path", "Update");*/
		return "redirect:noticeWrite?path=Update";
	}
	//Update, 데이터 수정하기
	@RequestMapping(value="noticeUpdate", method = RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd)throws Exception{
		int result = noticeService.boardUpdate(noticeDTO);
		String message ="수정 실패";
		if(result>0	){
			message="수정 성공!";
		}
		rd.addFlashAttribute("message", message);  // 주소창에 데이터가 안보임
		/*rd.addAttribute("message", message);*/   // 주소창에 데이터가 보임
		return "redirect:noticeList?curPage=1";
		
	}
	//Delete
	@RequestMapping(value="noticeDelete", method = RequestMethod.GET)
	public String noticeDelete(Integer num,RedirectAttributes rd)throws Exception{
		if(num ==null){ num =0;}
		int result = noticeService.boardDelete(num);
		String message =" 삭제 실패";
		
		if(result>0){
			message = "삭제 성공!!";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:noticeList?curPage=1";
	}
	
}
