package trials.itk.spring_data.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import trials.itk.spring_data.exception.dto.ExceptionResponseDto;
import trials.itk.spring_data.util.constant.Constants;

import java.io.IOException;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SecurityExceptionHandler {
	
	private final ObjectMapper objectMapper;
	
	public void accessDeniedHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
		log.error("ERROR: SecurityExceptionHandler.accessDeniedHandler: {}", ex.getMessage(), ex);
		printResponse(
				response,
				new ExceptionResponseDto(Constants.FORBIDDEN_MESSAGE),
				HttpStatus.FORBIDDEN);
	}
	
	public void unauthorizedHandler(HttpServletRequest request, HttpServletResponse response, Exception ex) throws IOException {
		log.error("ERROR: SecurityExceptionHandler.unauthorizedHandler: {}", ex.getMessage(), ex);
		printResponse(
				response,
				new ExceptionResponseDto(Constants.UNAUTHORIZED_MESSAGE),
				HttpStatus.UNAUTHORIZED);
	}
	
	private void printResponse (HttpServletResponse response, ExceptionResponseDto responseDto, HttpStatus status) throws IOException {
		response.setStatus(status.value());
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(objectMapper.writeValueAsString(responseDto));
	}
}