package pro.sky.java.course2.homework10libraries;

import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, double salary, int departmentId);

    Employee removeEmployee(String firstName, String lastName, double salary, int departmentId);

    Employee findDepartmentMaxSalary(int departmentId);

    Employee findDepartmentMinSalary(int departmentId);

    Set<String> printDepartmentEmployees(int departmentId);

    Set<String> printEmployeesByDepartment();

    Set<Employee> getAllEmployees();
}
