package ptit.example.tttnapplication.controllers.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Account;
import ptit.example.tttnapplication.data.entity.Employee;
import ptit.example.tttnapplication.dto.request.EmployeesRequest;
import ptit.example.tttnapplication.dto.response.EmployeeInformationResponse;
import ptit.example.tttnapplication.dto.response.EmployeesResponse;
import ptit.example.tttnapplication.services.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeManagementController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeManagementController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    EmployeesResponse getEmployeeById(@PathVariable("email") String email){
        return this.employeeService.getEmployeeByIdDto(email);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeInformationResponse createEmployee(@Valid @RequestBody EmployeesRequest dto){
        return this.employeeService.createEmployee(dto);
    }

    @PutMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    EmployeesResponse updateEmployee(@PathVariable("email") String email, @Valid @RequestBody EmployeesRequest dto){
        return this.employeeService.updateEmployee(email,dto);
    }

    @DeleteMapping("/{email}")
    @ResponseStatus(HttpStatus.OK)
    Account deleteEmployee(@PathVariable("email") String email){
        return this.employeeService.deleteEmployee(email);
    }
}
