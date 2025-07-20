package Java8API;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Employee {
    String name;
    String Department;
    int age;
    int salary;
    String Gender;
    public Employee(String name, int age, String Department, int salary, String Gender) {
        this.name = name;
        this.age = age;
        this.Department = Department;
        this.salary = salary; // Default salary
        this.Gender = Gender;
    }
    public String getName() {
        return name;
    }
    public String getDept() {
        return Department;
    }

    public int getAge() {
        return age;
    }
    public double getSalary() {
        return salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Department='" + Department + '\'' +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        Employee emp1 = new Employee("John", 30, "HR", 50000, "F");
        Employee emp2 = new Employee("Jane", 25, "Finance", 60000, "M");
        Employee emp3 = new Employee("Mike", 35, "IT", 50000, "M");
        Employee emp4 = new Employee("Sara", 28, "HR", 75000, "F");
        Employee emp5 = new Employee("Tom", 32, "Finance", 20000, "M");
        List<Employee> employee = List.of(emp1, emp2, emp3, emp4, emp5);
        Map<String, List<Employee>> empMap = employee.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.toList()));
        System.out.println(empMap);
        //names of employee groupby department
        Map<String, List<String>> namesEmp = employee.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(namesEmp);
        //count of employee groupby department
        Map<String, Integer> countEmp = employee.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.summingInt(n -> 1)));
        System.out.println(countEmp);//Given a list of employee objects, filter those with salary > 50,000.
        List<Employee> emp = employee.stream().filter(e -> e.getSalary() > 50000).collect(Collectors.toList());
        System.out.println(emp);

        //From a list of employees, filter by department "HR", then map their salaries, and sum them.
        double sum = employee.stream().filter(e->e.getDept().equals("HR")).map(s->s.getSalary())
                .reduce(0.0,Double::sum);
        System.out.println("Sum of salaries in HR department: " + sum);
    }
}
