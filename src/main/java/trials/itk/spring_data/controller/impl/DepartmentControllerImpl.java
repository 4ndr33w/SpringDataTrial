package trials.itk.spring_data.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import trials.itk.spring_data.controller.DepartmentController;
import trials.itk.spring_data.data.dto.request.DepartmentRequestDto;
import trials.itk.spring_data.data.dto.response.DepartmentResponseDto;
import trials.itk.spring_data.service.DepartmentService;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@RestController
@RequiredArgsConstructor
public class DepartmentControllerImpl implements DepartmentController {
	
	private final DepartmentService departmentService;
	
	@Override
	public ResponseEntity<DepartmentResponseDto> create(@Valid DepartmentRequestDto request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.create(request));
	}
	
	@Override
	public ResponseEntity<DepartmentResponseDto> getById(UUID id) {
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.getById(id));
	}
	
	@Override
	public ResponseEntity<List<DepartmentResponseDto>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(departmentService.getAll());
	}
	
	@Override
	public ResponseEntity<DepartmentResponseDto> update(UUID id, @Valid DepartmentRequestDto request) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentService.update(id, request));
	}
	
	@Override
	public ResponseEntity<Void> delete(UUID id) {
		departmentService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}