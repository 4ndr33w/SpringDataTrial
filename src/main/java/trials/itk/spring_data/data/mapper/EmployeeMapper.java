package trials.itk.spring_data.data.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import trials.itk.spring_data.data.dto.request.EmployeeRequestDto;
import trials.itk.spring_data.data.dto.response.EmployeeResponseDto;
import trials.itk.spring_data.data.entity.Employee;
import trials.itk.spring_data.data.mapper.decorator.EmployeeMapperDecorator;

/**
 * @author 4ndr33w
 * @version 1.1
 */
@Mapper(
		componentModel = MappingConstants.ComponentModel.SPRING,
		uses = {EmployeeMapperDecorator.class})
@DecoratedWith(EmployeeMapperDecorator.class)
public interface EmployeeMapper {

	Employee mapToEntity(EmployeeRequestDto request);

	EmployeeResponseDto mapToResponseDto(Employee entity);
	
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	Employee updateEntity(EmployeeRequestDto updateRequest, @MappingTarget Employee entity);
}