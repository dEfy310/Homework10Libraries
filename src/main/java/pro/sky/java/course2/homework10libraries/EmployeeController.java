package pro.sky.java.course2.homework10libraries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam Double salary, @RequestParam Integer departmentId) {
        return employeeServiceImpl.addEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                   @RequestParam Double salary, @RequestParam Integer departmentId) {
        return employeeServiceImpl.removeEmployee(firstName, lastName, salary, departmentId);
    }

    @GetMapping
    public Set<Employee> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }
}