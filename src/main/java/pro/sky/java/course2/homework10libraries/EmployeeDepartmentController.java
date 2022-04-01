package pro.sky.java.course2.homework10libraries;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/department")
public class EmployeeDepartmentController {
    private final EmployeeService employeeServiceImpl;

    public EmployeeDepartmentController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/max-salary")
    public Employee findDepartmentMaxSalary(@RequestParam Integer departmentId) {
        return employeeServiceImpl.findDepartmentMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee findDepartmentMinSalary(@RequestParam Integer departmentId) {
        return employeeServiceImpl.findDepartmentMinSalary(departmentId);
    }

    @GetMapping(path = "/all/department")
    public Set<String> printDepartmentEmployees(@RequestParam Integer departmentId) {
        return employeeServiceImpl.printDepartmentEmployees(departmentId);
    }

    @GetMapping(path = "/all")
    public Set<String> printEmployeesByDepartment() {
        return employeeServiceImpl.printEmployeesByDepartment();
    }
}