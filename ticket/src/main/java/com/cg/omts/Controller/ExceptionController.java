package com.cg.omts.Controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.omts.Dto.ErrorDto;
import com.cg.omts.Exception.CustomException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler({CustomException.class,SQLException.class,NullPointerException.class})
	public ResponseEntity<ErrorDto> exception(CustomException exception){
		ErrorDto error = new ErrorDto("error",exception.getMessage());
		ResponseEntity<ErrorDto> response = new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		return response;
	}
	
}
