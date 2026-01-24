error id: file:///C:/Projects/LearnJava/EmployeeInhouse.java:java/lang/System#
file:///C:/Projects/LearnJava/EmployeeInhouse.java
empty definition using pc, found symbol in pc: java/lang/System#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 2723
uri: file:///C:/Projects/LearnJava/EmployeeInhouse.java
text:
```scala
class Employee {
    private String Name;
    private int id;
    String EmpRole;
    int Experience;

   public  Employee(String Name, int id, String EmpRole, int Experience) {
        this.EmpRole = EmpRole;
        this.id = id;
        this.Name = Name;
        this.EmpRole = EmpRole;
        this.Experience = Experience;
    }

    String getName() {
        return Name;
    }

    int getid() {
        return id;
    }

    int getExp() {
        return Experience;
    }

    String getEmpRole() {
        return EmpRole;
    }

}


interface calculatSalary {
    int calcsalary(Employee emp);
}


class Interns implements calculatSalary {
    private Employee Employee;

    @Override
    public int calcsalary(Employee emp) {
        this.Employee = emp;
        int it = Employee.getExp();
        return it * 2500 / 2;

    }
}


class ParTime implements calculatSalary {
    private Employee Employee;

    @Override
    public int calcsalary(Employee emp) {
        this.Employee = emp;
        int it = Employee.getExp();
        return it * 4230 / 2;

    }
}


class FullTime implements calculatSalary {
    private Employee Employee;

    @Override
    public int calcsalary(Employee emp) {
        this.Employee = emp;
        int it = Employee.getExp();
        return it * 120000 / 2;

    }
}


class PrintEmployee {
    calculatSalary calculatSalary;
    Employee employee;

    public PrintEmployee(calculatSalary calculatSalary, Employee employee) {
        this.calculatSalary = calculatSalary;
        this.employee = employee;
    }

    public void printSalary() {
        int salary = calculatSalary.calcsalary(employee);

        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Role: " + employee.getEmpRole());
        System.out.println("Salary: " + salary);
    }
}
class EmployeeService {

    public void showEmployeeSalary(Employee emp) {

        if (emp.getEmpRole().equals("Intern")) {

            PrintEmployee pe =
                    new PrintEmployee(new Interns(), emp);
            pe.printSalary();

        } else if (emp.getEmpRole().equals("PartTime")) {

            PrintEmployee pe =
                    new PrintEmployee(new ParTime(), emp);
            pe.printSalary();

        } else if (emp.getEmpRole().equals("FullTime")) {

            PrintEmployee pe =
                    new PrintEmployee(new FullTime(), emp);
            pe.printSalary();
        }
    }
}



class EmployeeServiece {

}


public class EmployeeInhouse {
    public static void main(String[] args) {
        @@System.out.println("Hello Employee Inhouse");
    }
}

```


#### Short summary: 

empty definition using pc, found symbol in pc: java/lang/System#