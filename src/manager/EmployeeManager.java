package manager;

import employee.Employee;
import employee.FullTimeEmployee;
import employee.PartTimeEmployee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeManager {
    List<Employee> employees=new ArrayList<>();

    public EmployeeManager() {
    }
    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
    }

    public void add(Employee employee) {
        if(employee==null)return;
        employees.add(employee);
    }

    public Employee get(int index) {
        if (index>=employees.size()||index<0)return null;
        return employees.get(index);
    }
    public void update(Employee employee,int index){
        if(employee==null)return;
        employees.remove(index);
        employees.add(index,employee);
    }
    public int size(){
        return employees.size();
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

    public Employee[] getLowSalaryFullTimeEmployee() {
        ArrayList<Employee> list=new ArrayList<>();
        Employee[]result=new Employee[0];
        for (Employee employee:employees) {
            if(employee.getRealSalary()<getAveragePaid()&&employee instanceof FullTimeEmployee){
                list.add(employee);
            }
        }
        return list.toArray(result);
    }

    public int getTotalSalaryPartTime() {
        int result = 0;
        for (Employee employee:employees) {
            if(employee instanceof PartTimeEmployee)result+=employee.getRealSalary();
        }
        return result;
    }

    public List<Employee> sortFullTimeEmployee() {
        List<Employee>result=new ArrayList<>();
        Comparator<Employee> comparator=new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getRealSalary()- o2.getRealSalary();
            }
        };
        Collections.sort(employees,comparator);
        for (Employee employee:employees) {
            if(employee instanceof FullTimeEmployee){
                result.add(employee);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result="Employee(s) list:\n";
        for (Employee employee:employees) {
            result+=employee.toString()+"\n";
        }
        return result;
    }
}
