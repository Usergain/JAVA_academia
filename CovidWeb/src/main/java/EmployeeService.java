

import java.util.Arrays;
import java.util.List;

import model.Employee;

public class EmployeeService {

    public List < Employee > getEmployees() {
        return Arrays.asList(
        		new Employee(1, "Ramesh", "Fadatare"), 
        		new Employee(2, "Tony", "Stark"),
        		new Employee(3, "Tom", "Cruise"));
    }
}
