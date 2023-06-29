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
    public String getName(){
        return this.empname;
    }
    public void setName(String empname){
        String regex = "^([a-zA-Z][.]{0,1}){1,}([a-zA-Z\\s]){3,20}$";
        if(empname.matches(regex)){
            this.empname = empname;
            return;
        }
        else{
            System.out.println("!!ENTER THE VALID EMPLOYEE NAME!!");
            System.out.println("ENTER THE NAME :");
            Scanner input = new Scanner(System.in);
            empname = input.nextLine();
            setName(empname);
        }
    }
    public String getDepartment(){
        return this.empdepartment;
    }
    public void setDepartment(String department){
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
                    System.out.println("!! WRONG ENTRY !!"+"\n"+"\n"+"ENTER THE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2.IT"+"\n"+"3.FINANCE"+"\n"+"4.MARKETING"+"\n"+"5.R&D"+"\n"+"6.PRODUCTION");
                    emp_department = input.nextLine();
                    setDepartment(emp_department);
                    break;
            }
        }catch(Exception ex){
            System.out.println("!! WRONG ENTRY !!"+"\n"+"\n"+"ENTER THE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2.IT"+"\n"+"3.FINANCE"+"\n"+"4.MARKETING"+"\n"+"5.R&D"+"\n"+"6.PRODUCTION");
            emp_department = input.nextLine();
            setDepartment(emp_department);
        }
    }
    public String getDesignation(){
        return this.empdesignation;
    }
    public void setDesignation(String designation){
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
                    System.out.println("!! WRONG ENTRY !!"+"\n"+"\n"+"ENTER THE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
                    emp_designation = input.nextLine();
                    setDepartment(emp_designation);
                    break;
            }
        }catch(Exception ex){
            System.out.println("!! WRONG ENTRY !!"+"\n"+"\n"+"ENTER THE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
            emp_designation = input.nextLine();
            setDepartment(emp_designation);
        }
    }
    public double getSalary(){
        return this.empsalary;
    }
    public void setSalary(String Salary){
        String salary = "";
        Scanner input = new Scanner(System.in);
        try{
            double emp_salary = Double.parseDouble(Salary);
            if(emp_salary < 5000 || emp_salary > 1000000){
                System.out.println("!!WRONG ENTRY!! PLEASE ENTER THE VALID SALARY");
                salary = input.nextLine();
                setSalary(salary);
            }
            else{
                this.empsalary = emp_salary;
            }
        }catch(Exception ex){
            System.out.println("!!WRONG ENTRY!! PLEASE ENTER THE VALID SALARY");
            salary = input.nextLine();
            setSalary(salary);
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
    // public void getattribute(String para){
    //     if(para == "empid"){
    //         getEmpId();
    //     }
    //     else if(para == "empname"){
    //         getName();
    //     }
    //     else if(para == "empdepartment"){
    //         getDepartment();
    //     }
    //     else if(param == "empdesignation"){
    //         getDesignation();
    //     }
    //     else if(param == "empsalary"){
    //         getSalary();
    //     }
    // }
    public String toString(){
        String details = "\n"+"EMPLOYEE ID: "+this.empid+"\n"+"EMPLOYEE NAME :"+this.empname+"\n"+"EMPLOYEE DEPARTMENT: "+this.empdepartment+"\n"+"EMPLOYEE DESIGNATION :"+this.empdesignation+"\n"+"EMPLOYEE SALARY :"+this.empsalary;
        return details;
    }
}
