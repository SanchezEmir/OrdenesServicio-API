package pe.edu.idat.app.controladores.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.edu.idat.app.servicios.exceptions.DataIntegratyViolationException;
import pe.edu.idat.app.servicios.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControladorExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<ErrorEstandar> objectNotFoundException(ObjectNotFoundException e) {
		ErrorEstandar error = new ErrorEstandar(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegratyViolationException.class)
	public ResponseEntity<ErrorEstandar> objectNotFoundException(DataIntegratyViolationException e) {
		ErrorEstandar error = new ErrorEstandar(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorEstandar> objectNotFoundException(MethodArgumentNotValidException e) {
		ValidacionErrores error = new ValidacionErrores(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Error en la validación de los campos!!");

		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			error.addErrores(x.getField(), x.getDefaultMessage());
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
