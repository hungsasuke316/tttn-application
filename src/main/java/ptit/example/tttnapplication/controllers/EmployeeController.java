package ptit.example.tttnapplication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ptit.example.tttnapplication.data.entity.Employee;
import ptit.example.tttnapplication.dto.request.EmployeesRequest;
import ptit.example.tttnapplication.dto.response.EmployeeInformationResponse;
import ptit.example.tttnapplication.dto.response.EmployeesResponse;
import ptit.example.tttnapplication.services.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    List<Employee> getAllEmployees(){
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    EmployeesResponse getEmployeeById(@PathVariable("employeeId") Integer employeeId){
        return this.employeeService.getEmployeeByIdDto(employeeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    EmployeeInformationResponse createEmployee(@Valid @RequestBody EmployeesRequest dto){
        return this.employeeService.createEmployee(dto);
    }

    @PutMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    EmployeesResponse updateEmployee(@PathVariable("employeeId") Integer employeeId, @Valid @RequestBody EmployeesRequest dto){
        return this.employeeService.updateEmployee(employeeId,dto);
    }

    @DeleteMapping("/{employeeId}")
    @ResponseStatus(HttpStatus.OK)
    EmployeesResponse deleteEmployee(@PathVariable("employeeId") Integer employeeId){
        return this.employeeService.deleteEmployee(employeeId);
    }
}
