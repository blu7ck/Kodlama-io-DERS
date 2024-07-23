package com.blu4ck.demo;

import com.blu4ck.demo.core.utilities.exceptions.BusinessException;
import com.blu4ck.demo.core.utilities.exceptions.ProblemDetails;
import com.blu4ck.demo.core.utilities.exceptions.ValidationProblemDetails;
import com.blu4ck.demo.core.utilities.mappers.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.modelmapper.ValidationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class RentApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){

		ProblemDetails problemDetails = new ProblemDetails();

		problemDetails.setMessage(businessException.getMessage());

		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)		//BUNLARA LOG YAZABİLİYORUZ
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException){

		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();

		validationProblemDetails.setMessage("Validation Exception");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError: methodArgumentNotValidException.getBindingResult().getFieldErrors()){
			validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());
		}
		return validationProblemDetails;
	}


	@Bean
	public 	ModelMapper mapper(){
		return new ModelMapper();

	}
}
