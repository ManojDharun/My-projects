import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class AttendanceMaster{
    private LinkedHashMap<Employee,Integer> empattendance;
    public AttendanceMaster(){
        this.empattendance = new LinkedHashMap<Employee,Integer>();
    }
    public LinkedHashMap<Employee,Integer> getEmployeeAttendance(){
        return this.empattendance;
    }
    public int updateAttendance(int employeeid,int employeeattendance){
        for(Map.Entry<Employee,Integer> attendance:this.empattendance.entrySet()){
            if(attendance.getKey().getEmpId() == employeeid){
                this.empattendance.replace(attendance.getKey(),employeeattendance);
                return 1;
            }
        }
        return 0;
    }
    public void showEligibleList(){
        if(this.empattendance.size() == 0){
            System.out.println("NO ELIGIBLE EMPLOYEES WERE THERE");
        }
        else{
            for(Map.Entry<Employee,Integer> attendance:this.empattendance.entrySet()){
                Integer num_of_days = attendance.getValue();
                if(num_of_days > 10){
                    String details = attendance.getKey().toString();
                    System.out.println(details);
                }
            }
        }
    }
}
