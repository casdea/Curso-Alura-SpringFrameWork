package br.com.alura.springboot.apispringboot.forum.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.alura.springboot.apispringboot.forum.dto.ErroInputModel;

@RestControllerAdvice
public class ErroValidacaoInputHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroInputModel> handle(MethodArgumentNotValidException exception)
	{
		List<ErroInputModel> erros = new ArrayList<ErroInputModel>();
		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
		
		fieldErros.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); 
			ErroInputModel erro = new ErroInputModel(e.getField(),mensagem);
			erros.add(erro);
		});
		
		return erros;
	}
	
	
}
