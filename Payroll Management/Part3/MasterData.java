import java.util.ArrayList;
public class MasterData{
    private ArrayList<Employee> employeeslist = new ArrayList<Employee>();
    public MasterData(ArrayList<Employee> employee){
        this.employeeslist = employee;
    }
    public ArrayList<Employee> getEmployeeList(){
        return this.employeeslist;
    }
    public void setEmployeeList(ArrayList<Employee> employeelist){
        this.employeeslist = employeelist;
    }
}