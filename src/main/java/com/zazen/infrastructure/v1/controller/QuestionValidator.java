package com.zazen.infrastructure.v1.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.zazen.infrastructure.v1.vo.QuestionRequestVO;

public class QuestionValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(QuestionRequestVO.class);
	}

	public void validate(Object target, Errors errors) {
		if(errors.hasErrors())
			return ;
		else
		{
			
		}
		
	}

}
