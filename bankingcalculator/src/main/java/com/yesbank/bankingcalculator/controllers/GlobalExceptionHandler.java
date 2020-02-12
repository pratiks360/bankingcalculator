package com.yesbank.bankingcalculator.controllers;

import java.io.IOException;
import javax.script.ScriptException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	protected final Log logger = LogFactory.getLog(getClass());

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException() {
		logger.error("IOException handler executed");
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "computation error")
	@ExceptionHandler({ ScriptException.class, ResourceNotFoundException.class, NullPointerException.class })
	public void handleComputeException() {
		logger.error("ScriptException handler executed");
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "template parsing error")
	@ExceptionHandler(ParseErrorException.class)
	public void handleParseException() {
		logger.error("Parser handler executed");
	}

}
