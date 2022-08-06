package ptit.example.tttnapplication.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ptit.example.tttnapplication.data.entity.Account;
import ptit.example.tttnapplication.data.entity.Employee;
import ptit.example.tttnapplication.data.entity.Roles;
import ptit.example.tttnapplication.data.repositpty.AccountRepository;
import ptit.example.tttnapplication.data.repositpty.EmployeeRepository;
import ptit.example.tttnapplication.data.repositpty.RolesRepository;
import ptit.example.tttnapplication.dto.request.EmployeesRequest;
import ptit.example.tttnapplication.dto.response.EmployeeInformationResponse;
import ptit.example.tttnapplication.dto.response.EmployeesResponse;
import ptit.example.tttnapplication.exceptions.ResourceNotAcceptException;
import ptit.example.tttnapplication.exceptions.ResourceNotFoundException;
import ptit.example.tttnapplication.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final AccountRepository accountRepository;
    private final EmployeeRepository employeeRepository;
    private final RolesRepository rolesRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public EmployeeServiceImpl(AccountRepository accountRepository,  RolesRepository rolesRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.rolesRepository = rolesRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public EmployeesResponse getEmployeeByIdDto(Integer employeeId) {
        Optional<Employee> employeeOptional = this.employeeRepository.findById(employeeId);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            return modelMapper.map(employee, EmployeesResponse.class);
        }
        throw new ResourceNotFoundException("User Not Found");
    }

    @Override
    public EmployeeInformationResponse createEmployee(EmployeesRequest dto) {

        Optional<Account> accountOptional = this.accountRepository.findById(dto.getEmail());

        if (accountOptional.isPresent()){
            throw new ResourceNotAcceptException("Email is already exist");
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        Account account = modelMapper.map(dto, Account.class);
        System.out.println("mapper:" + account.toString());

        Roles roles = this.rolesRepository.findByName("employee");
        account.setRoles(roles);
        System.out.println(account.toString());
        Account saveAccount =accountRepository.save(account);

        Employee employee = modelMapper.map(dto, Employee.class);
        employee.setEnable(true);
        employee.setEmail(saveAccount);
        Employee saveEmployee =employeeRepository.save(employee);
        EmployeesResponse employeesResponse = modelMapper.map(saveEmployee, EmployeesResponse.class);

        EmployeeInformationResponse employeeInformationResponse = modelMapper.map(saveAccount, EmployeeInformationResponse.class);
        employeeInformationResponse.setEmployeesResponse(employeesResponse);
        return  employeeInformationResponse;
    }

    @Override
    public EmployeesResponse updateEmployee(Integer employeeId, EmployeesRequest dto) {
        Employee employee = employeeRepository.findById(employeeId).get();

        dto.setEmail(employee.getEmail().getEmail());
        dto.setPassword(employee.getEmail().getPassword());
        modelMapper.map(dto,employee);
        employeeRepository.save(employee);
        return  modelMapper.map(employee, EmployeesResponse.class);
    }

    @Override
    public EmployeesResponse deleteEmployee(Integer employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        if(employee.getEnable().equals(true)){
            employee.setEnable(false);
            employee = employeeRepository.save(employee);
        }
        else if(employee.getEnable().equals(false)){
            employee.setEnable(true);
            employee = employeeRepository.save(employee);
        }

        return  modelMapper.map(employee, EmployeesResponse.class);
    }
}
