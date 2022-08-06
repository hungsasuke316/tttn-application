package ptit.example.tttnapplication.services;

import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Employee;
import ptit.example.tttnapplication.dto.request.EmployeesRequest;
import ptit.example.tttnapplication.dto.response.EmployeeInformationResponse;
import ptit.example.tttnapplication.dto.response.EmployeesResponse;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    EmployeesResponse getEmployeeByIdDto(Integer employeeId);
    EmployeeInformationResponse createEmployee(EmployeesRequest dto);
    EmployeesResponse updateEmployee(Integer employeeId, EmployeesRequest dto);
    EmployeesResponse deleteEmployee(Integer employeeId);
}
