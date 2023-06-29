import java.util.Scanner;
import java.util.ArrayList;
public class TestEmployee{
    // public static void quicksort(ArrayList<Employee> employees,int start,int end,String param){
    //     if(start<end){
    //         int part = partition(employees,start,end,param);
    //         quicksort(employees,start,part-1,param);
    //         quicksort(employees,part+1,end,param);
    //     }
    // }
    
    // public static int partition(ArrayList<Employee> employees,int start,int end,String param){
    //     String pivot = employees.get(end).getattribute(param);
    //     int pindex = start;
    //     for(int i=start;i<end;i++){
    //         if(pivot.compareTo(employees.get(i).getattribute(param)) > 0){
    //             Employee temp = new Employee(employees.get(i).getEmpId(),employees.get(i).getEmpName(),employees.get(i).getEmpdepartment(),employees.get(i).getEmpDesignation(),employees.get(i).getEmpSalary());
    //             employees.get(i) = employees.get(pindex);
    //             employees.get(pindex) = temp;
    //             // temp.empid = employees.get(i).empid;
    //             // temp.empname = employees.get(i).empname;
    //             // temp.empdepartment = employees.get(i).empdepartment;
    //             // temp.empdesignation = employees.get(i).empdesignation;
    //             // temp.empsalary = employees.get(i).empsalary;
    //             // employees.get(i).empid = employees.get(pindex).empid;
    //             // employees.get(i).empname = employees.get(pindex).empname;
    //             // employees.get(i).empdepartment = employees.get(pindex).empdepartment;
    //             // employees.get(i).empdesignation = employees.get(pindex).empdesignation;
    //             // employees.get(i).empsalary = employees.get(pindex).empsalary;
    //             // employees.get(pindex).empid = temp.empid;
    //             // employees.get(pindex).empname = temp.empname;
    //             // employees.get(pindex).empdepartment = temp.empdepartment;
    //             // employees.get(pindex).empdesignation = temp.empdesignation;
    //             // employees.get(pindex).empsalary = temp.empsalary;
    //             pindex++;
    //         }
    //     }
    //     Employee temp = new Employee(employees.get(end).getEmpId(),employees.get(end).getEmpName(),employees.get(end).empdepartment,employees.get(end).empdesignation,employees.get(end).empsalary);
    //     employees.get(end) = employees.get(pindex);
    //     employees.get(pindex) = temp;
    //     // temp.empid = employees.get(end).empid;
    //     // temp.empname = employees.get(end).empname;
    //     // temp.empdepartment = employees.get(end).empdepartment;
    //     // temp.empdesignation = employees.get(end).empdesignation;
    //     // temp.empsalary = employees.get(end).empsalary;
    //     // employees.get(end).empid = employees.get(pindex).empid;
    //     // employees.get(end).empname = employees.get(pindex).empname;
    //     // employees.get(end).empdepartment = employees.get(pindex).empdepartment;
    //     // employees.get(end).empdesignation = employees.get(pindex).empdesignation;
    //     // employees.get(end).empsalary = employees.get(pindex).empsalary;
    //     // employees.get(pindex).empid = employees.get(pindex).empid;
    //     // employees.get(pindex).empsalary = employees.get(pindex).empname;
    //     // employees.get(pindex).empdesignation = employees.get(pindex).empdesignation;
    //     // employees.get(pindex).empdepartment = employees.get(p)
    //     // employees.get(pindex).id = temp.id;
    //     return pindex;
    // }

    public static void setAttendanceForEmployees(MasterData masterdata,AttendanceMaster attendancemaster){
        System.out.println("SET ATTENDANCE FOR ADDED EMPLOYEES"+"\n");
        int i=0;
        do{
            do{
                try{
                    if(!(attendancemaster.getEmployeeAttendance().containsKey(masterdata.getEmployeeList().get(i)))){
                        System.out.println("ENTER THE ATTENDANCE FOR AN EMPLOYEE ID "+masterdata.getEmployeeList().get(i).getEmpId());
                        Scanner input = new Scanner(System.in);
                        String days = input.nextLine();
                        int attendancedays = Integer.parseInt(days);
                        if(attendancedays >= 0){
                            attendancemaster.getEmployeeAttendance().put(masterdata.getEmployeeList().get(i),attendancedays);
                            break;
                        }
                        else{
                            System.out.println("!!WRONG ENTRY!!");
                        }
                    }
                    else{
                        i++;
                        continue;
                    }
                }catch(Exception ex){
                    System.out.println("!!WRONG ENTRY!!");
                }
            }while(true);
            i++;
        }while(i<masterdata.getEmployeeList().size());
    }
    public static int validateEmployeeId(String employeeid){
        Scanner input = new Scanner(System.in);
        do{
            try{
                int emp_id = Integer.parseInt(employeeid);
                if(emp_id > 1000){
                    return emp_id;
                }
                else{
                    System.out.println("!!WRONG ENTRY!!");
                    System.out.println("ENTER THE EMPLOYEE ID :");
                    employeeid = input.nextLine();
                }
            }catch(Exception ex){
                System.out.println("!!WRONG ENTRY!!");
                System.out.println("ENTER THE EMPLOYEE ID :");
                employeeid = input.nextLine();
            }
        }while(true);
    }
    public static int validateEmployeeAttendance(String days){
        Scanner input = new Scanner(System.in);
        do{
            try{
                int att_days = Integer.parseInt(days);
                return att_days;
            }catch(Exception ex){
                System.out.println("!!WRONG ENTRY!!");
                System.out.println("ENTER THE EMPLOYEE ATTENDANCE :");
                days = input.nextLine();
            }
        }while(true);
    }
    public static void main(String args[]){
        ArrayList<Employee> employees = new ArrayList<Employee>();
        AttendanceMaster attendancemaster = new AttendanceMaster();
        MasterData masterdata = new MasterData(employees);
        System.out.println("------------------------------------");
        while(true){
            System.out.println("DO YOU WANT TO ADD THE EMPLOYEE? yes or no");
            Scanner option = new Scanner(System.in);
            String choice = option.next();
            if(choice.equals("yes")){
                System.out.println("ENTER THE CHOICE :"+"\n"+"1. ADD EMPLOYEE DETAILS"+"\n"+"2. SET EMPLOYEES ATTENDANCE"+"\n"+"3. UPDATE EMPLOYEE ATTENDANCE");
                Scanner input = new Scanner(System.in);
                int employeechoice = input.nextInt();
                if(employeechoice == 1){
                    Employee employee = new Employee();
                    System.out.print("ENTER THE EMPLOYEE DETAILS"+"\n"+"ENTER THE NAME :");
                    input.nextLine();
                    String empname = input.nextLine();
                    employee.setName(empname);
                    System.out.println("ENTER THE EMPLOYEE DEPARTMENT :"+"\n"+"1. HUMAN RESOURCE"+"\n"+"2. IT"+"\n"+"3. FINANCE"+"\n"+"4. MARKETING"+"\n"+"5. R&D"+"\n"+"6. PRODUCTION");
                    String empdepartment = input.nextLine();
                    employee.setDepartment(empdepartment);
                    System.out.println("ENTER THE EMPLOYEE DESIGNATION"+"\n"+"1. TRAINEE ENGINEER"+"\n"+"2. SOFTWARE ENGINEER"+"\n"+"3. PROJECT LEAD"+"\n"+"4. PROJECT MANAGER"+"\n"+"5. PROGRAM MANAGER"+"\n"+"6. HR MANAGER");
                    String empdesignation = input.nextLine();
                    employee.setDesignation(empdesignation);
                    System.out.println("ENTER THE EMPLOYEE SALARY :");
                    String empsalary = input.nextLine();
                    employee.setSalary(empsalary);
                    employees.add(employee);
                }
                else if(employeechoice == 2){
                    masterdata.setEmployeeList(employees);
                    if(employees.size()==0){
                        System.out.println("!!There is no Employee found!!");
                    }
                    else{
                        setAttendanceForEmployees(masterdata,attendancemaster);
                    }
                }
                else if(employeechoice == 3){
                    masterdata.setEmployeeList(employees);
                    System.out.println("ENTER THE EMPLOYEE ID :");
                    String empid = input.nextLine();
                    int emp_id = validateEmployeeId(empid);
                    System.out.println("ENTER THE EMPLOYEE ATTENDANCE :");
                    String empattendance = input.nextLine();
                    int emp_attendance = validateEmployeeAttendance(empattendance);
                    int result = attendancemaster.updateAttendance(emp_id,emp_attendance);
                    if(result == 1){
                        System.out.println("ATTENDANCE UPDATED SUCCESFULLY");
                    }
                    else{
                        System.out.println("!!NO SUCH EMPLOYEE FOUND!!");
                    }
                }
                else{
                    break;
                }
            }
            else{
                break;
            }
        }
        if(employees.size() == 0){
            System.out.println("!!No employee were added!!");
        }
        else{
            System.out.println("\n"+"EMPLOYEE DETAILS :");
            for(int i=0;i<masterdata.getEmployeeList().size();i++){
                System.out.println("\n");
                String emp_details = masterdata.getEmployeeList().get(i).toString();
                System.out.println(emp_details);
                employees.get(i).setAllowance();
                System.out.println("\n"+"\n"+"AFTER ALLOWANCE :");
                emp_details = masterdata.getEmployeeList().get(i).toString();
                System.out.println(emp_details);
            }
            System.out.println("ELIGIBLE EMPLOYEES ARE :");
            attendancemaster.showEligibleList();
        }
    }
}
