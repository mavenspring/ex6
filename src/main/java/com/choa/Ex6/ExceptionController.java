package com.choa.Ex6;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice  // Exception 관련 Annotation
public class ExceptionController {
	
	// Exception 처리
		@ExceptionHandler(Exception.class)   //Exception 외에 다른 예외처리를 넣어도됨
		public String exception(Exception e , Model model){
			model.addAttribute("e",e.getMessage());
			
			return "error/notFound";  //에러가발생하면 views/error/notFound.jsp로 보내줌
		}
}
