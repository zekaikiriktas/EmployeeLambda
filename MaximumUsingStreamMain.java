package lambdapractice.employeeage;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumUsingStreamMain {
    public static void main(String args[])
    {
        List<Employee> employeeList = createEmployeeList();
        List<String> employeeFilteredList = employeeList.stream()
                .filter(e->e.getAge()>20)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("Employee names of lower than 20 age:");
        employeeFilteredList.forEach((name)-> System.out.println(name));
        System.out.println("Employee ages list of lower than 20 :");
        getEmployeesLower20Age(employeeList);
        System.out.println();
        getEmployeesLower5000Salary(employeeList);

    }
    public static void getEmployeesLower20Age(List<Employee> employees){
        employees.stream().filter(t-> t.getAge()<=20).map(t->t.getAge()).collect(Collectors.toList()).forEach(System.out::println);
    }
    public static void getEmployeesLower5000Salary(List<Employee> employees){
       long count= employees.stream().filter(t->t.getSalary()<=5000).collect(Collectors.toList()).stream().count();
        System.out.println("Salary lower 5000 employee count ="+(int)count);
        employees.stream().filter(t->t.getSalary()<=5000).collect(Collectors.toList()).forEach(System.out::println);

    }
    public static List<Employee> createEmployeeList()
    {
        List<Employee> employeeList=new ArrayList<>();
        Employee e1=new Employee("John",21,5000);
        Employee e2=new Employee("Martin",19,4500);
        Employee e3=new Employee("Mary",31,6000);
        Employee e4=new Employee("Stephan",18,6500);
        Employee e5=new Employee("Gary",26,9000);

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        return employeeList;
    }
}
