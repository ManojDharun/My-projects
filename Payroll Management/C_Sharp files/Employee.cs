using System;
using System.Text.RegularExpressions;
namespace EMP{
public class Employee{
    private static int empcounter = 1001;
    private int empid;
    public int EmpId{
        get{
            return empid;
        }
        set{
            this.empid = value;
        }
    }
    private string empname;
    public string EmpName{
        get{
            return empname;
        }
        set{
            ValidateName(value);
        }
    }                                          
    private string empdesignation;
    public string Designation{
        get{
            return empdesignation;
        }
        set{
            ValidateDesignation(value);
        }
    }
    private string empdepartment;
    public string Department{
        get{
            return empdepartment;
        }
        set{
            ValidateDepartment(value);
        }
    }
    private double empsalary;
    public double Salary{
        get{
            return empsalary;
        }
        set{
            ValidateSalary(value);
        }
    }
    public Employee(){
        empid = empcounter++;
    }
    public void ValidateName(string name){
        string regex_name = "^([a-zA-Z][.]{0,1}){1,}([a-zA-Z\\s]){3,20}$";
        Regex regex = new Regex(regex_name);
        if(regex.IsMatch(name)){
            this.empname = name;
            return;
        }
        else{
            Console.WriteLine("!!ENTER THE VALID EMPLOYEE NAME!!");
            Console.WriteLine("ENTER THE NAME :");
            name = Console.ReadLine();
            ValidateName(name);
        }
    }
    public void ValidateDepartment(string department){
        string emp_department = "";
        try{
            int choice = Int32.Parse(department);
            switch(choice){
                case 1:
                    emp_department = "HUMAN RESOURCE";
                    this.empdepartment = emp_department;
                    break;
                case 2:
                    emp_department = "IT";
                    this.empdepartment = emp_department;
                    break;
                case 3:
                    emp_department = "FINANCE";
                    this.empdepartment = emp_department;
                    break;
                case 4:
                    emp_department = "MARKETING";
                    this.empdepartment = emp_department;
                    break;
                case 5:
                    emp_department = "R&D";
                    this.empdepartment = emp_department;
                    break;
                case 6:
                    emp_department = "PRODUCTION";
                    this.empdepartment = emp_department;
                    break;
                default:
                    Console.WriteLine("!! WRONG ENTRY !!"+"\n"+"\n"+"ENTER THE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2.IT"+"\n"+"3.FINANCE"+"\n"+"4.MARKETING"+"\n"+"5.R&D"+"\n"+"6.PRODUCTION");
                    emp_department = Console.ReadLine();
                    ValidateDepartment(emp_department);
                    break;
            }
        }catch{
            Console.WriteLine("!! WRONG ENTRY !!"+"\n"+"\n"+"ENTER THE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2.IT"+"\n"+"3.FINANCE"+"\n"+"4.MARKETING"+"\n"+"5.R&D"+"\n"+"6.PRODUCTION");
            emp_department = Console.ReadLine();
            ValidateDepartment(emp_department);
        }
    }
    public void ValidateDesignation(string designation){
        string emp_designation = "";
        try{
            int choice = Int32.Parse(designation);
            switch(choice){
                case 1:
                    emp_designation = "TRAINEE ENGINEER";
                    this.empdepartment = emp_designation;
                    break;
                case 2:
                    emp_designation = "SOFTWARE ENGINEER";
                    this.empdesignation = emp_designation;
                    break;
                case 3:
                    emp_designation = "PROJECT LEAD";
                    this.empdesignation = emp_designation;
                    break;
                case 4:
                    emp_designation = "PROJECT MANAGER";
                    this.empdesignation = emp_designation;
                    break;
                case 5:
                    emp_designation = "PROGRAM MANAGER";
                    this.empdesignation = emp_designation;
                    break;
                case 6:
                    emp_designation = "HR MANAGER";
                    this.empdesignation = emp_designation;
                    break;
                default:
                    Console.WriteLine("!! WRONG ENTRY !!"+"\n\n"+"ENTER THE EMPLOYEE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
                    emp_designation = Console.ReadLine();
                    ValidateDesignation(emp_designation);
                    break;
            }
        }catch{
            Console.WriteLine("!! WRONG ENTRY !!"+"\n\n"+"ENTER THE EMPLOYEE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
            emp_designation = Console.ReadLine();
            ValidateDesignation(emp_designation);
        }
    }
    public void ValidateSalary(double Salary){
        if(Salary < 5000 || Salary > 1000000){
            Console.WriteLine("!!WRONG ENTRY!! PLEASE ENTER THE VALID SALARY");
            double salary = Double.Parse(Console.ReadLine());
            ValidateSalary(salary);
        }
        else{
            this.empsalary = Salary;
        }
    }
    public override string ToString(){
        String details = "\n"+"EMPLOYEE ID: "+this.empid+"\n"+"EMPLOYEE NAME :"+this.empname+"\n"+"EMPLOYEE DEPARTMENT: "+this.empdepartment+"\n"+"EMPLOYEE DESIGNATION :"+this.empdesignation+"\n"+"EMPLOYEE SALARY :"+this.empsalary;
        return details;
    }
}
}
