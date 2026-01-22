package trials.itk.spring_data.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import trials.itk.spring_data.data.dto.request.EmployeeRequestDto;
import trials.itk.spring_data.data.dto.response.EmployeeResponseDto;
import trials.itk.spring_data.data.entity.Employee;

/**
 * @author 4ndr33w
 * @version 1.0
 */
@Mapper(
		componentModel = MappingConstants.ComponentModel.SPRING,
		unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

	Employee mapToEntity(EmployeeRequestDto request);

	@Mapping(target = "departmentId", source = "department.id")
	EmployeeResponseDto mapToResponseDto(Employee entity);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Employee updateEntity(EmployeeRequestDto updateRequest, @MappingTarget Employee entity);
}