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

    @Override
    public int calcsalary(Employee emp) {
        
        int it = emp.getExp();
        return it * 4230 / 2;

    }
}


class FullTime implements calculatSalary {

    @Override
    public int calcsalary(Employee emp) {
        int it = emp.getExp();
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

        System.out.println("Hello Employee Inhouse");

        // Create Employee Objects
        Employee emp1 = new Employee("Vijay", 101, "Intern", 2);
        Employee emp2 = new Employee("Ajay", 102, "PartTime", 3);
        Employee emp3 = new Employee("Ravi", 103, "FullTime", 5);

        // Employee Service
        EmployeeService service = new EmployeeService();

        // Show Salary Details
        service.showEmployeeSalary(emp1);

        System.out.println("-------------------");

        service.showEmployeeSalary(emp2);

        System.out.println("-------------------");

        service.showEmployeeSalary(emp3);
    }
}

