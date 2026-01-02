// package Acess;

// class Employee {
//     private int empid;
//     private String name;
//     private boolean active;

//     public Employee(String name, boolean active, int empid) {
//         this.empid = empid;
//         this.name = name;
//         this.active = active;

//     }

//     public String getname() {
//         return name;
//     }

//     public int getempid() {
//         return empid;
//     }

//     public boolean getactivestatus() {
//         return active;
//     }
// }


// class AcessRole {
//     private String Role;
//     private int cardId;
//     private int userid;
//     private Employee emp;

//     public AcessRole(String Role, int cardId, Employee emp) {
//         this.emp = emp;
//         this.Role = Role;
//         this.cardId = cardId;
//         this.userid = emp.getempid();
//     }

//     public String getRole() {
//         return Role;
//     }

//     public int getcardId() {
//         return cardId;
//     }

// }


// abstract class AcessRoleController {
//     abstract String controller(AcessRole as);
// }


// class staff extends AcessRoleController {
//     @Override
//     public String controller(AcessRole as) {
//         return "staff";
//     }
// }


// class Engineer extends AcessRoleController {
//     @Override
//     public String controller(AcessRole as) {
//         return "Engineer";
//     }
// }


// class Admin extends AcessRoleController {
//     @Override
//     public String controller(AcessRole as) {
//         return "Admin";
//     }
// }
// class 
