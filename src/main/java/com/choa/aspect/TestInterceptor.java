package com.choa.aspect;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.choa.board.BoardDTO;
import com.choa.util.ListInfo;

public class TestInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("After Controller");
		Map<String,Object> map =  modelAndView.getModel();
		Object list = map.get("list");
		Object listInfo = map.get("listInfo");
		Object board = map.get("board");
		
		
		System.out.println(((List<BoardDTO>)list).get(0).getTitle());
		System.out.println(((ListInfo)listInfo).getCurBlock());
		System.out.println(board);
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Before Controller ");
		return true;
	}
		
	
}
																				