using System;
using System.Collections.Generic;
using EMP;
public class TestEmployee{
    public static void Main(string[] args){
        List<Employee> employees = new List<Employee>();
        while(true){
            Console.WriteLine("DO YOU WANT TO PROCEED? yes or no :");
            string choice = Console.ReadLine();
            if(choice.Equals("yes")){
                Employee employee = new Employee();
                Console.WriteLine("ENTER THE EMPLOYEE NAME WITH ID: "+employee.EmpId);
                string name = Console.ReadLine();
                employee.EmpName = name;
                Console.WriteLine("ENTER THE EMPLOYEE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2. IT"+"\n"+"3. FINANCE"+"\n"+"4. MARKETING"+"\n"+"5. R&D"+"\n"+"6. PRODUCTION");
                string department = Console.ReadLine();
                employee.Department = department;
                Console.WriteLine("ENTER THE EMPLOYEE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
                string designation = Console.ReadLine();
                employee.Designation = designation;
                Console.WriteLine("ENTER THE EMPLOYEE SALARY :");
                double salary = Double.Parse(Console.ReadLine());
                employee.Salary = salary;
                employees.Add(employee);
            }
            else{
                break;
            }
        }
        for(int i=0;i<employees.Count;i++){
            string details = employees[i].ToString();
            Console.WriteLine(details);
        }
    }
}
