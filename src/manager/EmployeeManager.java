package manager;

import employee.Employee;

import java.util.ArrayList;

public class EmployeeManager {
    ArrayList<Employee> employees=new ArrayList<>();

    public EmployeeManager() {
    }
    public EmployeeManager(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public Employee get(int index) {
        if (index>=employees.size()||index<0)return null;
        return employees.get(index);
    }
    public void update(Employee employee,int index){
        employees.remove(index);
        employees.add(index,employee);
    }

    public void delete(int i) {
        employees.remove(i);
    }

    public int getAveragePaid() {
        if(employees.size()==0)return 0 ;
        int result=0;
        for (Employee employee:employees) {
            result+=employee.getRealSalary();
        }
        return result/employees.size();
    }
}
