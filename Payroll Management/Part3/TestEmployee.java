import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
public class TestEmployee{
    public static ArrayList<Employee> employees = new ArrayList<Employee>();
    public static AttendanceMaster attendancemaster = new AttendanceMaster();
    public static MasterData masterdata = new MasterData(employees);
    public static ArrayList<Employee> delete_emp = new ArrayList<Employee>();
    public static class SortByName implements Comparator<Employee>{
        public boolean isascending;
        public SortByName(boolean isascending){
            this.isascending = isascending;
        }
        public int compare(Employee emp1,Employee emp2){
            if(isascending){
                return emp1.getEmpName().toUpperCase().compareTo(emp2.getEmpName().toUpperCase());
            }
            else{
                return emp2.getEmpName().toUpperCase().compareTo(emp1.getEmpName().toUpperCase());
            }
        }
    }
    public static class SortByDepartment implements Comparator<Employee>{
        public boolean isascending;
        public SortByDepartment(boolean isascending){
            this.isascending = isascending;
        }
        public int compare(Employee emp1,Employee emp2){
            if(isascending){
                return emp1.getEmpDepartment().compareTo(emp2.getEmpDepartment());
            }
            else{
                return emp2.getEmpDepartment().compareTo(emp1.getEmpDepartment());
            }
        }
    }
    public static class SortByDesignation implements Comparator<Employee>{
        public boolean isascending;
        public SortByDesignation(boolean isascending){
            this.isascending = isascending;
        }
        public int compare(Employee emp1,Employee emp2){
            if(isascending){
                return emp1.getEmpDesignation().compareTo(emp2.getEmpDesignation());
            }
            else{
                return emp2.getEmpDesignation().compareTo(emp1.getEmpDesignation());
            }
        }
    }
    public static class SortBySalary implements Comparator<Employee>{
        public boolean isascending;
        public SortBySalary(boolean isascending){
            this.isascending = isascending;
        }
        public int compare(Employee emp1,Employee emp2){
            if(isascending){
                if(emp1.getEmpSalary() == emp2.getEmpSalary()){
                    return 0;
                }
                else if(emp1.getEmpSalary() > emp2.getEmpSalary()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            else{
                if(emp2.getEmpSalary() == emp1.getEmpSalary()){
                    return 0;
                }
                else if(emp2.getEmpSalary() > emp1.getEmpSalary()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        }
    }
    public static void display(MasterData masterdata){
        if(masterdata.getEmployeeList().size() == 0){
            System.out.println("!!NO EMPLOYEES ARE ADDED!!");
            return;
        }
        System.out.format("%15s %18s %19s %23s %17s \n\t--------------------------------------------------------------------------------------\n","ID","NAME","DEPARTMENT","DESIGNATION","SALARY"+"\n");
        for(Employee emp : masterdata.getEmployeeList()){
                String details = emp.toString();
                String emp_det[] = details.split(",");
                System.out.format("%15s %18s %19s %23s %18s",emp_det[0],emp_det[1],emp_det[2],emp_det[3],emp_det[4]+"\n");
        }
    }
    public static int validateEmployeeId(String employeeid,MasterData masterdata){
        Scanner input = new Scanner(System.in);
        do{
            try{
                int flag = 0;
                int emp_id = Integer.parseInt(employeeid);
                for(Employee emp : masterdata.getEmployeeList()){
                    if(emp.getEmpId() == emp_id){
                        flag = 1;   
                    }
                }
                if(flag == 1){
                    return emp_id;
                }
                else{
                    System.out.println("!!NO DETAILS FOUND WITH THE GIVEN EMPLOYEE ID!!"+"\n"+"ENTER THE EMPLOYEE ID :");
                    employeeid = input.nextLine();
                }
            }catch(Exception ex){
                System.out.println("!!ONLY NUMERICAL DATA ARE ALLOWED!!"+"\n"+"ENTER THE EMPLOYEE ID :");
                employeeid = input.nextLine();
            }
        }while(true);
    }
    public static int validateEmployeeAttendance(String days){
        Scanner input = new Scanner(System.in);
        do{
            try{
                int att_days = Integer.parseInt(days);
                if(att_days < 0){
                    System.out.println("!!ATTENDANCE DAYS MUST BE GREATER THAN OR EQUAL TO 0!!"+"\n"+"ENTER THE EMPLOYEE ATTENDANCE :");
                    days = input.nextLine();
                }
                return att_days;
            }catch(Exception ex){
                System.out.println("!!ONLY NUMERICAL DATA ARE ALLOWED!!"+"\n"+"ENTER THE EMPLOYEE ATTENDANCE :");
                days = input.nextLine();
            }
        }while(true);
    }
    public static int validateSortChoice(String asc_desc_choice){
        Scanner input = new Scanner(System.in);
        int asc_desc = 0;
        try{
            asc_desc = Integer.parseInt(asc_desc_choice);
            if(asc_desc > 2 || asc_desc < 1){
                System.out.println("!!SORTING CHOICE SHOULD BE EITHER 1 OR 2!!");
                asc_desc_choice = input.nextLine();
                asc_desc = validateSortChoice(asc_desc_choice);
            }
        }catch(Exception ex){
            System.out.println("!!ONLY NUMERICAL DATA ARE ALLOWED!!"+"\n"+"ENTER THE CHOICE:");
            asc_desc_choice = input.nextLine();
            asc_desc = validateSortChoice(asc_desc_choice);
        }
        return asc_desc;
    }
    public static void main(String args[]){
        int employee_choice = -1,fil_flag = 0,att_flag = 0;
        Scanner input = new Scanner(System.in);
        String employeechoice;
        do{
            System.out.println("\n"+"\n"+"1. ADD EMPLOYEE DETAILS"+"\n"+"2. SET EMPLOYEES ATTENDANCE"+"\n"+"3. UPDATE EMPLOYEE ATTENDANCE"+"\n"+"4. FILTER EMPLOYEES"+"\n"+"5. SORT EMPLOYEE DETAIL"+"\n"+"6. SHOW ELIGIBLE EMPLOYEES"+"\n"+"7. CALCULATE SALARY FOR EMPLOYEES"+"\n"+"8. DISPLAY EMPLOYEE DETAILS"+"\n"+"9.TO EXIT"+"\n"+"ENTER THE CHOICE :");
            try{
                employeechoice = input.nextLine();
                employee_choice = Integer.parseInt(employeechoice);
                switch(employee_choice){
                    case 1:
                        Employee employee = new Employee();
                        System.out.print("ENTER THE EMPLOYEE DETAILS"+"\n"+"ENTER THE NAME :"); 
                        String empname = input.nextLine();
                        employee.setEmpName(empname);
                        System.out.println("ENTER THE EMPLOYEE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2. IT"+"\n"+"3. FINANCE"+"\n"+"4. MARKETING"+"\n"+"5. R&D"+"\n"+"6. PRODUCTION");
                        String empdepartment = input.nextLine();
                        employee.setEmpDepartment(empdepartment);
                        System.out.println("ENTER THE EMPLOYEE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
                        String empdesignation = input.nextLine();
                        employee.setEmpDesignation(empdesignation);
                        System.out.println("ENTER THE EMPLOYEE SALARY :");
                        String empsalary = input.nextLine();
                        employee.setEmpSalary(empsalary);
                        masterdata.getEmployeeList().add(employee);
                        att_flag = 0;
                        fil_flag = 0;
                        break;
                    case 2:
                        if(masterdata.getEmployeeList().size()==0){
                            System.out.println("!!NO EMPLOYEES FOUND!!");
                        }
                        else{
                            attendancemaster.setAttendanceForEmployees(masterdata,delete_emp,att_flag);
                        }
                        att_flag = 1;
                        break;
                    case 3:
                        if(masterdata.getEmployeeList().size()==0){
                            System.out.println("!!NO EMPLOYEES FOUND!!");
                            break;
                        }
                        System.out.println("ENTER THE EMPLOYEE ID :");
                        String empid = input.nextLine();
                        int emp_id = validateEmployeeId(empid,masterdata);
                        System.out.println("ENTER THE EMPLOYEE ATTENDANCE :");
                        String empattendance = input.nextLine();
                        int emp_attendance = validateEmployeeAttendance(empattendance);
                        int result = attendancemaster.updateAttendance(emp_id,emp_attendance,masterdata);
                        if(result == -1){
                            System.out.println("!!NO EMPLOYEES FOUND!!");
                        }
                        else if(result == 1){
                            System.out.println("ATTENDANCE UPDATED SUCCESFULLY");
                        }
                        else{
                            System.out.println("!!NO SUCH EMPLOYEE FOUND!!");
                        }
                        fil_flag = 0;
                        break;
                    case 4:
                        //@SuppressWarnings("unchecked")
                        //LinkedHashMap<Employee,Integer> temp_emp_attendance = (LinkedHashMap<Employee,Integer>)attendancemaster.getEmployeeAttendance().clone();
                        int att_add = 0;
                        for(Employee emp :  masterdata.getEmployeeList()){
                            if(!(attendancemaster.getEmployeeAttendance().containsKey(emp)) && !(delete_emp.contains(emp))){
                                System.out.println("YOU HAVE NOT ADDED ATTENDANCE TO ALL THE EMPLOYEES");
                                att_add = 1;
                                break;
                            }
                        }
                        if(att_add == 0){
                            delete_emp = attendancemaster.filterEmployeeList(delete_emp);
                        }
                        fil_flag = 1;
                        attendancemaster.showEligibleList(masterdata);
                        break;
                    case 5:
                        do{
                            if(masterdata.getEmployeeList().size() == 0){
                                System.out.println("!!NO EMPLOYEES FOUND!!");
                                break;
                            }
                            System.out.println("1. SORT BY EMPLOYEE NAME"+"\n"+"2. SORT BY EMPLOYEE DEPARTMENT"+"\n"+"3. SORT BY EMPLOYEE DESIGNATION"+"\n"+"4. SORT BY EMPLOYEE SALARY"+"\n"+"5. TO EXIT");
                            int sort_choice = input.nextInt();
                            input.nextLine();
                            int flag = 0,asc_desc;
                            String asc_desc_choice;
                            switch(sort_choice){
                                case 1:
                                    System.out.println("1. SORT IN ASCENDING ORDER"+"\n"+"2. SORT IN DESCENDING ORDER");
                                    asc_desc_choice = input.nextLine();
                                    asc_desc = validateSortChoice(asc_desc_choice);
                                    if(asc_desc == 1){
                                        masterdata.getEmployeeList().sort(new SortByName(true));
                                    }
                                    else{
                                        masterdata.getEmployeeList().sort(new SortByName(false));
                                    }
                                    display(masterdata);
                                    flag = 1;
                                    break;
                                case 2:
                                    System.out.println("1. SORT IN ASCENDING ORDER"+"\n"+"2. SORT IN DESCENDING ORDER");
                                    asc_desc_choice = input.nextLine();
                                    asc_desc = validateSortChoice(asc_desc_choice);
                                    if(asc_desc == 1){
                                        masterdata.getEmployeeList().sort(new SortByDepartment(true));
                                    }
                                    else{
                                        masterdata.getEmployeeList().sort(new SortByDepartment(false));
                                    }
                                    display(masterdata);
                                    flag = 1;
                                    break;
                                case 3:
                                    System.out.println("1. SORT IN ASCENDING ORDER"+"\n"+"2. SORT IN DESCENDING ORDER");
                                    asc_desc_choice = input.nextLine();
                                    asc_desc = validateSortChoice(asc_desc_choice);
                                    if(asc_desc == 1){
                                        masterdata.getEmployeeList().sort(new SortByDesignation(true));
                                    }
                                    else{
                                        masterdata.getEmployeeList().sort(new SortByDesignation(false));
                                    }
                                    display(masterdata);
                                    flag = 1;
                                    break;
                                case 4:
                                    System.out.println("1. SORT IN ASCENDING ORDER"+"\n"+"2. SORT IN DESCENDING ORDER");
                                    asc_desc_choice = input.nextLine();
                                    asc_desc = validateSortChoice(asc_desc_choice);
                                    if(asc_desc == 1){
                                        masterdata.getEmployeeList().sort(new SortBySalary(true));
                                    }
                                    else{
                                        masterdata.getEmployeeList().sort(new SortBySalary(false));
                                    }
                                    display(masterdata);
                                    flag = 1;
                                    break;
                                case 5:
                                    flag = 1;
                                    break;
                                default:
                                    System.out.println("!!YOU HAVE ENTERED THE WRONG OPTION!!");
                                    break;
                            }
                            if(flag == 1){
                                break;
                            }
                        }while(true);
                        break;
                    case 6:
                        attendancemaster.showEligibleList(masterdata);
                        break;
                    case 7:
                        if(masterdata.getEmployeeList().size()==0){
                            System.out.println("!!NO EMPLOYEES ARE ADDED!!");
                            break;
                        }
                        else{
                            SalCalculator sal_cal = new SalCalculator();
                            sal_cal.calculateSalary(attendancemaster.getEmployeeAttendance(),fil_flag);
                        }
                        break;
                    case 8:
                        display(masterdata);
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("!!ENTER THE CORRECT OPTION!!");
                        break;
                }
            }catch(Exception ex){
                System.out.println("!!INVALID OPTION, ONLY NUMERICAL DATA ARE ALLOWED!! RE-ENTER");
            }
        }while(employee_choice!=9);
    }
}