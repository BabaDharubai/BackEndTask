/**
 * 
 */
package com.pdfcreator.exceptions;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pdfcreator.model.ApiErrors;

/**
 * @author BabaFakruddinDharuba
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	/**This method returns an over ridden HttpRequestMethodNotSupportException
	 * @param ex passes the HttpRequestMethodNotSupportedException to the method
	 * @param headers HttpHeaders are passed to the method 
	 * @param status HttpStatus of the given request is passed
	 * @param request the web request path is passed
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		String error="Requested Method Not Supported";
		headers.add("info","Accessing method request is not defined");
		ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**This method returns an over ridden HttpMessageNotReadableException
	 * @param ex passes the HttpMessageNotReadableException to the method
	 * @param headers HttpHeaders are passed to the method 
	 * @param status HttpStatus of the given request is passed
	 * @param request the web request path is passed
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		String error="Body is Incorrect";
		headers.add("info","Request body is not in good format");
		ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
		return ResponseEntity.status(status).headers(headers).body(errors);
	}


	/**This method returns an over ridden TypeMismatchException
	 * @param ex passes the TypeMismatchException to the method
	 * @param headers HttpHeaders are passed to the method 
	 * @param status HttpStatus of the given request is passed
	 * @param request the web request path is passed
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error="Input Type Is Mismatched";
		headers.add("info", "check the input type");
		ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	/**This method returns an over ridden Exception
	 * @param ex passes the Exception to the method
	 * @param headers HttpHeaders are passed to the method 
	 * @param status HttpStatus of the given request is passed
	 * @param request the web request path is passed
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String message=ex.getMessage();
		String error="Internal Server Error";
		headers.add("info", "Internal service is having an problem");
		ApiErrors errors=new ApiErrors(error,message,status,status.value(),LocalDateTime.now());
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	
	
	
	/**This method over ridden the FieldNotFoundException
	 * @param ex passes the Exception of the type FieldNotFoundException
	 * @return an ResponseEntity of type Object with HttStatus, HttpHeaders along with body
	 */
	@ExceptionHandler(FieldNotFoundException.class)
	public ResponseEntity<Object> handleFieldNotFoundException(FieldNotFoundException ex){
		String message=ex.getMessage();
		String error="Check your fields";
		ApiErrors errors=new ApiErrors(error,message,HttpStatus.PARTIAL_CONTENT,HttpStatus.PARTIAL_CONTENT.value(),LocalDateTime.now());
		HttpHeaders headers=new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).headers(headers).body(errors);
		
	}

	/**This method returns an over ridden HttpMediaTypeNotSupportedException
	 * @param ex passes the HttpMediaTypeNotSupportedException to the method
	 * @param headers HttpHeaders are passed to the method 
	 * @param status HttpStatus of the given request is passed
	 * @param request the web request path is passed
	 * @return an ResponseEntity of Object type with status, headers and errors
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message=ex.getMessage();
		String error="Check Input Format";
		ApiErrors errors=new ApiErrors(error,message,HttpStatus.NOT_ACCEPTABLE,HttpStatus.NOT_ACCEPTABLE.value(),LocalDateTime.now());
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).headers(headers).body(errors);
	}
	
	/**This method over ridden the TemplateNotFoundException
	 * @param ex passes the Exception of the type TemplateNotFoundException
	 * @return an ResponseEntity of type Object with HttStatus, HttpHeaders along with body
	 */
	@ExceptionHandler(TemplateNotFoundException.class)
	public ResponseEntity<Object> handleTemplateNotFound(TemplateNotFoundException ex){
		String message=ex.getMessage();
		String error="Template Not Found";
		ApiErrors errors=new ApiErrors(error,message,HttpStatus.CONFLICT,HttpStatus.CONFLICT.value(),LocalDateTime.now());
		HttpHeaders headers=new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.CONFLICT).headers(headers).body(errors);
		
	}
	
	
	/**This method over ridden the IOException
	 * @param ex passes the Exception of the type IOException
	 * @return an ResponseEntity of type Object with HttStatus, HttpHeaders along with body
	 */
	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> handleIO(IOException ex){
		String message=ex.getMessage();
		String error="File Not Found";
		ApiErrors errors=new ApiErrors(error,message,HttpStatus.FORBIDDEN,HttpStatus.FORBIDDEN.value(),LocalDateTime.now());
		HttpHeaders headers=new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.FORBIDDEN).headers(headers).body(errors);
		
	}
	

	/**This method over ridden the EmptyListNotFoundException
	 * @param ex passes the Exception of the type EmptyListNotFoundException
	 * @return an ResponseEntity of type Object with HttStatus, HttpHeaders along with body
	 */
	@ExceptionHandler(EmptyListFoundException.class)
	public ResponseEntity<Object> handleEmptyListException(EmptyListFoundException ex){
		String message=ex.getMessage();
		String error="List is Empty";
		ApiErrors errors=new ApiErrors(error,message,HttpStatus.NO_CONTENT,HttpStatus.NO_CONTENT.value(),LocalDateTime.now());
		HttpHeaders headers=new HttpHeaders();
		headers.add("info",message);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(errors);
		
	}
	
	
	
	
	
}
