package trials.itk.spring_data.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import trials.itk.spring_data.data.dto.request.DepartmentRequestDto;
import trials.itk.spring_data.data.dto.response.DepartmentResponseDto;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RequestMapping("/api/v1/departments")
public interface DepartmentController {
	
	@PostMapping
	ResponseEntity<DepartmentResponseDto> create(DepartmentRequestDto request);
	
	@GetMapping("/{id}")
	ResponseEntity<DepartmentResponseDto> getById(UUID id);
	
	@GetMapping
	ResponseEntity<List<DepartmentResponseDto>> getAll();
	
	@PatchMapping("/{id}")
	ResponseEntity<DepartmentResponseDto> update(UUID id, DepartmentRequestDto request);
	
	@DeleteMapping("/{id}")
	ResponseEntity<Void> delete(UUID id);
}
