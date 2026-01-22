package trials.itk.spring_data.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import trials.itk.spring_data.exception.DepartmentNotFoundException;
import trials.itk.spring_data.exception.EmployeeNotFoundException;
import trials.itk.spring_data.exception.dto.ExceptionResponseDto;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 4ndr33w
 * @version 1.1
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponseDto> handleException(Exception e) {
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponseDto(e.getMessage()));
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ExceptionResponseDto> handleIllegalArgumentException(IllegalArgumentException e) {
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(e.getMessage()));
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionResponseDto> handleNullPointerException(NullPointerException e) {
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(e.getMessage()));
	}
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<ExceptionResponseDto> handleDepartmentNotFoundException(DepartmentNotFoundException e) {
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDto(e.getMessage()));
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ExceptionResponseDto> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponseDto(e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();
		errors.put("status", "400");
		errors.put("message", "Некорректный запрос");
		e.getBindingResult().getFieldErrors().forEach(error -> {
			String field = error.getField();
			String message = error.getDefaultMessage();
			errors.put(field, message);
		});
		errors.put("timestamp", ZonedDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponseDto> handleConstraintViolationException(ConstraintViolationException e) {
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponseDto(e.getMessage()));
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ExceptionResponseDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
		String message = "Некорректный запрос";
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(message));
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ExceptionResponseDto> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
		String message = Objects.requireNonNull(e.getRootCause()).getMessage();
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(message));
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ExceptionResponseDto> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
		String message = "Некорректрый аргумент в запросе";
		log.error("ERROR: Сработало исключение: {}; {}", ex.getClass(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponseDto(message));
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException e) {
		log.error("ERROR: Сработало исключение: {}; {}", e.getClass(), e.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ExceptionResponseDto(e.getMessage()));
	}
}