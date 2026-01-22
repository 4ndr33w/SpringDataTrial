package trials.itk.spring_data.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import trials.itk.spring_data.data.dto.request.DepartmentRequestDto;
import trials.itk.spring_data.data.dto.response.DepartmentResponseDto;
import trials.itk.spring_data.data.entity.Department;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Mapper(componentModel = ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {
	
	//@Mapping(target = "id", ignore = true)
	@Mapping(target = "employees", ignore = true)
	Department mapToEntity(DepartmentRequestDto request);
	
	DepartmentResponseDto mapToResponseDto(Department entity);
	
	//@Mapping(target = "id", ignore = true)
	@Mapping(target = "employees", ignore = true)
	Department updateEntity(DepartmentRequestDto update, @MappingTarget Department entity);
}