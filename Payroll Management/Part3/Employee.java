import java.util.Scanner;
public class Employee{
    private static int empcounter = 1001;
    private int empid;
    private String empname;
    private String empdepartment;
    private String empdesignation;
    private double empsalary;
    public Employee(){
        this.empid = empcounter++;
    }
    public Employee(String empname,String empdepartment,String empdesignation,double empsalary){
        this.empname = empname;
        this.empdepartment = empdepartment;
        this.empdesignation = empdesignation;
        this.empsalary = empsalary;
        this.empid = empcounter++;
    }
    public int getEmpId(){
        return this.empid;
    }
    public void setEmpId(int empid){
        this.empid = empid;
    }
    public String getEmpName(){
        return this.empname;
    }
    public void setEmpName(String empname){
        String regex = "^([a-zA-Z\\s]){3,20}$";
        if(empname.matches(regex)){
            this.empname = empname;
            return;
        }
        else{
            System.out.println("!!EMPLOYEE NAME SHOULD BE THE LENGTH OF 3 TO 20 CHARACTERS AND SHOULD CONTAIN ONLY ALHABETS!!");
            System.out.println("ENTER THE NAME :");
            Scanner input = new Scanner(System.in);
            empname = input.nextLine();
            setEmpName(empname);
        }
    }
    public String getEmpDepartment(){
        return this.empdepartment;
    }
    public void setEmpDepartment(String department){
        String emp_department = "";
        Scanner input = new Scanner(System.in);
        try{
            int choice = Integer.parseInt(department);
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
                    System.out.println("!!ENTER THE CORRECT OPTION!!"+"\n"+"\n"+"ENTER THE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2.IT"+"\n"+"3.FINANCE"+"\n"+"4.MARKETING"+"\n"+"5.R&D"+"\n"+"6.PRODUCTION");
                    emp_department = input.nextLine();
                    setEmpDepartment(emp_department);
                    break;
            }
        }catch(Exception ex){
            System.out.println("\n"+"!!ONLY NUMBERS ARE ALLOWED, ALHABETS OR ANY OTHER SPECIAL CHARACTERS ARE NOT ALLWOED!!"+"\n"+"\n"+"ENTER THE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2.IT"+"\n"+"3.FINANCE"+"\n"+"4.MARKETING"+"\n"+"5.R&D"+"\n"+"6.PRODUCTION");
            emp_department = input.nextLine();
            setEmpDepartment(emp_department);
        }
    }
    public String getEmpDesignation(){
        return this.empdesignation;
    }
    public void setEmpDesignation(String designation){
        String emp_designation = "";
        Scanner input = new Scanner(System.in);
        try{
            int choice = Integer.parseInt(designation);
            switch(choice){
                case 1:
                    emp_designation = "TRAINEE ENGINEER";
                    this.empdesignation = emp_designation;
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
                    System.out.println("!! ENTER THE CORRECT OPTION !!"+"\n"+"\n"+"ENTER THE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
                    emp_designation = input.nextLine();
                    setEmpDesignation(emp_designation);
                    break;
            }
        }catch(Exception ex){
            System.out.println("\n"+"!!ONLY NUMBERS ARE ALLOWED, ALHABETS OR ANY OTHER SPECIAL CHARACTERS ARE NOT ALLWOED!!"+"\n"+"\n"+"ENTER THE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
            emp_designation = input.nextLine();
            setEmpDesignation(emp_designation);
        }
    }
    public double getEmpSalary(){
        return this.empsalary;
    }
    public void setEmpSalary(String Salary){
        String salary = "";
        Scanner input = new Scanner(System.in);
        try{
            double emp_salary = Double.parseDouble(Salary);
            if(emp_salary < 5000 || emp_salary > 1000000){
                System.out.println("!!EMPLOYEE SALARY SHOULD BE GREATER THAN 5000 AND LESS THAN 1000000!! PLEASE ENTER THE VALID SALARY");
                salary = input.nextLine();
                setEmpSalary(salary);
            }
            else{
                this.empsalary = emp_salary;
            }
        }catch(Exception ex){
            System.out.println("!!SPECIAL CHARACTERS AND ALHABETS ARE NOT ALLOWED!! PLEASE ENTER THE VALID SALARY");
            salary = input.nextLine();
            setEmpSalary(salary);
        }
    }
    public void setAllowance(){
        double allow = 0.0;
        String designation = this.empdesignation;
        designation = designation.toUpperCase();
        if(designation.contains("MANAGER")){
            allow = (20 * this.empsalary)/100;
        }
        else {
            allow = (10 * this.empsalary)/100;
        }
        this.empsalary += allow;
    }
    public String toString(){
        String details = this.getEmpId()+","+this.getEmpName()+","+this.getEmpDepartment()+","+this.getEmpDesignation()+","+this.getEmpSalary()+"\n";
        return details;
    }
}