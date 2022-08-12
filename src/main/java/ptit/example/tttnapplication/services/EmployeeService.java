package ptit.example.tttnapplication.services;

import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Account;
import ptit.example.tttnapplication.data.entity.Employee;
import ptit.example.tttnapplication.dto.request.EmployeesRequest;
import ptit.example.tttnapplication.dto.response.EmployeeInformationResponse;
import ptit.example.tttnapplication.dto.response.EmployeesResponse;

import java.util.List;

@Service
public interface EmployeeService {
    List<Employee> getAllEmployees();
    EmployeesResponse getEmployeeByIdDto(String email);
    EmployeeInformationResponse createEmployee(EmployeesRequest dto);
    EmployeesResponse updateEmployee(String email, EmployeesRequest dto);
    Account deleteEmployee(String email);
}
