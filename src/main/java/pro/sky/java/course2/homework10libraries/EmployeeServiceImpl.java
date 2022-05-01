package pro.sky.java.course2.homework10libraries;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Set<Employee> employeeSet;

    public EmployeeServiceImpl() {
        this.employeeSet = new HashSet<>();
    }

    public Employee createEmployee(String firstName, String lastName, double salary, int departmentId) {
        return new Employee(firstName, lastName, salary, departmentId);
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int departmentId) {
        String a = (firstName + " " + lastName);
        Employee employee = createEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, departmentId);
        if (StringUtils.isAlphaSpace(a)) {
            employeeSet.add(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, double salary, int departmentId) {
        String a = (firstName + " " + lastName);
        Employee employee = createEmployee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName), salary, departmentId);
        if (StringUtils.isAlphaSpace(a)) {
            employeeSet.remove(employee);
            return employee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findDepartmentMaxSalary(int departmentId) {
        return employeeSet.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findDepartmentMinSalary(int departmentId) {
        return employeeSet.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Set<String> getDepartmentEmployees(int departmentId) {
        return employeeSet.stream()
                .filter(employee -> employee.getDepartmentId().equals(departmentId))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getEmployeesByDepartment() {
        return employeeSet.stream()
                .sorted(Comparator.comparing(Employee::getDepartmentId))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName() + " departmentId" + employee.getDepartmentId())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Employee> getAllEmployees() {
        return new HashSet<>(employeeSet);
    }
}
