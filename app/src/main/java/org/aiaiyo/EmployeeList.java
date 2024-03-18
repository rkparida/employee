package org.aiaiyo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeList {
    private List<Employee> employees = new ArrayList<Employee>();

    public EmployeeList() {
        employees.add(new Employee("John Doe", 30, "1000"));
        employees.add(new Employee("Jane Doe", 25, "800"));
        employees.add(new Employee("Tom Smith", 35, "1200"));
        employees.add(new Employee("Sue Smith", 28, "900"));
        employees.add(new Employee("Mike Wilson", 40, "1500"));
    }

    public String[] getEmployeesNames() {
        String[] names = new String[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            names[i] = employees.get(i).getName();
        }
        return names;
    }

    public String[] getEmployeesNamesWithStream() {
        return employees.stream()
                .map(Employee::getName)
                .toArray(String[]::new);
    }

    public List<Employee> getEmployeesSortedByAgEmployees() {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
        return employees.stream()
                .filter(e -> Integer.parseInt(e.getSalary()) > salary)
                .collect(Collectors.toList());
    }

}
