package trials.itk.spring_data.data.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author 4ndr33w
 * @version 1.1
 */
@Getter
@RequiredArgsConstructor
public enum EmployeePosition implements GrantedAuthority {
	
	SLAVE("холоп"),
	MASTER("барин");
	
	private final String value;
	
	@Override
	public String getAuthority() {
		return value;
	}
}