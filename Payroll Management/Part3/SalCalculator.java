import java.util.Map;
import java.util.LinkedHashMap;
public class SalCalculator{
    public void calculateSalary(LinkedHashMap<Employee,Integer> eligiblelist,int fil_flag){
        if(fil_flag == 0){
            System.out.println("!!YOU HAVE NOT FILTERED THE EMPLOYEES YET!!");
            return;
        }
        if(eligiblelist.size() == 0){
            System.out.println("!!NO ELIGIBLE EMPLOYEES ARE THERE!!");
            return;
        }
        System.out.format("%15s %13s %17s %22s %18s %14s %13s %13s %20s \n\t--------------------------------------------------------------------------------------------------------------------------------------------------\n","ID","NAME","DEPARTMENT","DESIGNATION","SALARY","GROSS","PF","NET","NUMBER_OF_DAYS"+"\n");
        for(Map.Entry<Employee,Integer> emp : eligiblelist.entrySet())
        {
            double allowance = 0.0;
            if(emp.getKey().getEmpDesignation().contains("MANAGER")){
                allowance = (20 * emp.getKey().getEmpSalary())/100;
            }
            else{
                allowance = (10 * emp.getKey().getEmpSalary())/100;
            }
            double gross = emp.getKey().getEmpSalary() + allowance;
            double pf = (10 * gross)/100;
            double net_salary = gross - pf;
            System.out.format("%15s %13s %17s %22s %18s %14s %13s %13s %20s",emp.getKey().getEmpId(),emp.getKey().getEmpName(),emp.getKey().getEmpDepartment(),emp.getKey().getEmpDesignation(),emp.getKey().getEmpSalary(),gross,pf,net_salary,emp.getValue()+"\n\n");
        }
    }       
}

