package trials.itk.spring_data.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import trials.itk.spring_data.data.dto.request.DepartmentRequestDto;
import trials.itk.spring_data.data.dto.response.DepartmentResponseDto;
import trials.itk.spring_data.data.entity.Department;
import trials.itk.spring_data.data.mapper.DepartmentMapper;
import trials.itk.spring_data.data.repository.DepartmentRepository;
import trials.itk.spring_data.exception.DepartmentNotFoundException;
import trials.itk.spring_data.service.DepartmentService;

import java.util.List;
import java.util.UUID;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentMapper departmentMapper;
	private final DepartmentRepository departmentRepository;
	
	@Override
	@Transactional
	public DepartmentResponseDto create(DepartmentRequestDto request) {
		Department newDepartment = departmentMapper.mapToEntity(request);
		Department savedDepartment = departmentRepository.save(newDepartment);
		
		return departmentMapper.mapToResponseDto(savedDepartment);
	}
	
	@Override
	@Transactional
	public DepartmentResponseDto update(UUID id, DepartmentRequestDto update) {
		Department existingDepartment = getDepartmentByIdOrElseThrow(id);
		Department updatedDepartment = departmentMapper.updateEntity(update, existingDepartment);
		
		return departmentMapper.mapToResponseDto(updatedDepartment);
	}
	
	@Override
	@Transactional
	public void delete(UUID id) {
		Department existingDepartment = getDepartmentByIdOrElseThrow(id);
		departmentRepository.delete(existingDepartment);
	}
	
	@Override
	@Transactional(readOnly = true)
	public DepartmentResponseDto getById(UUID id) {
		Department existingDepartment = getDepartmentByIdOrElseThrow(id);
		
		return departmentMapper.mapToResponseDto(existingDepartment);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<DepartmentResponseDto> getAll() {
		List<Department> departments = departmentRepository.findAll();
		
		return departments.stream()
				.map(departmentMapper::mapToResponseDto)
				.toList();
	}
	
	private Department getDepartmentByIdOrElseThrow(UUID id) {
		return departmentRepository.findById(id)
				.orElseThrow(() -> new DepartmentNotFoundException("Department not found"));
	}
}