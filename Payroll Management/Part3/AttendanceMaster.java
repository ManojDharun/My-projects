import java.util.LinkedHashMap;
import java.util.Map; 
import java.util.ArrayList;
import java.util.Scanner;
public class AttendanceMaster{
    private LinkedHashMap<Employee,Integer> empattendance;
    public AttendanceMaster(){
        this.empattendance = new LinkedHashMap<Employee,Integer>();
    }
    public LinkedHashMap<Employee,Integer> getEmployeeAttendance(){
        return this.empattendance;
    }
    public void setAttendanceForEmployees(MasterData masterdata,ArrayList<Employee> delete_emp,int att_flag){
        int i=0,flag = 0;
        Scanner input = new Scanner(System.in);
        do{
            do{
                try{
                    if(att_flag == 1){
                        System.out.println("!!ATTENDANCE WERE ALREADY ADDED TO THE EMPLOYEES!!");
                        return;
                    }
                    if((!(delete_emp.contains(masterdata.getEmployeeList().get(i)))) && (!(this.empattendance.containsKey(masterdata.getEmployeeList().get(i))))){
                        System.out.println("ENTER THE ATTENDANCE FOR AN EMPLOYEE ID "+masterdata.getEmployeeList().get(i).getEmpId());
                        flag = 1;
                        String days = input.nextLine();
                        int attendancedays = Integer.parseInt(days);
                        if(attendancedays >= 0){
                            this.empattendance.put(masterdata.getEmployeeList().get(i),attendancedays);
                            break;
                        }
                        else{
                            System.out.println("!!ATTENDANCE DAYS MUST BE EITHER 0 OR GREATER THAN 0!!");
                        }
                    }
                    else{
                        break;
                    }
                }catch(Exception ex){
                    System.out.println("!!ATTENDANCE DAYS MUST BE GIVEN IN NUMERICAL FORMAT!!");
                }
            }while(true);
            i++;
        }while(i<masterdata.getEmployeeList().size());
        if(flag != 1){
            System.out.println("YOU HAVE ADDED ATTENDANCE TO ALL EMPLOYEES");
        }
    }
    public int updateAttendance(int employeeid,int employeeattendance,MasterData masterdata){
        if(masterdata.getEmployeeList().size()==0){
            return -1;
        }
        for(Employee emp: masterdata.getEmployeeList()){
            if(emp.getEmpId() == employeeid){
                this.empattendance.put(emp,employeeattendance);
                return 1;
            }
        }
        return 0;
    }
    public ArrayList<Employee> filterEmployeeList(ArrayList<Employee> delete_emp){
        LinkedHashMap<Employee,Integer> temp_emp_attendance = this.empattendance;
        for(Map.Entry<Employee,Integer> attendance:temp_emp_attendance.entrySet()){
            Integer num_of_days = attendance.getValue();
            if(num_of_days <= 10){
                this.empattendance.remove(attendance.getKey());
                delete_emp.add(attendance.getKey());
            }
        }
        return delete_emp;
    }
    public void setEmployeeAttendance(LinkedHashMap<Employee,Integer> emp_attendance){
        this.empattendance = emp_attendance;
    }
    public void showEligibleList(MasterData masterdata){
        if(masterdata.getEmployeeList().size() == 0){
            System.out.println("!!NO EMPLOYEES FOUND!!");
            return;
        }
        if(this.empattendance.size() == 0){
            System.out.println("!!NO ELIGIBLE EMPLOYEES ARE THERE!!");
            return;
        }
        else{
            System.out.format("%15s %18s %19s %23s %17s \n\t--------------------------------------------------------------------------------------\n","ID","NAME","DEPARTMENT","DESIGNATION","SALARY"+"\n");
            for(Map.Entry<Employee,Integer> attendance:this.empattendance.entrySet()){
                Integer num_of_days = attendance.getValue();
                if(num_of_days > 10){
                    String details = attendance.getKey().toString();
                    String emp_det[] = details.split(",");
                    System.out.format("%15s %18s %19s %23s %18s",emp_det[0],emp_det[1],emp_det[2],emp_det[3],emp_det[4]+"\n");
                }
            }
        }
    }
}