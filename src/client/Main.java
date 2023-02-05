package client;

import employee.Employee;
import employee.FullTimeEmployee;
import employee.PartTimeEmployee;
import manager.EmployeeManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Employee> employees = new ArrayList<>();
    static EmployeeManager manager = new EmployeeManager(employees);
    public static void main(String[] args) {
        initData(employees);
        System.out.println(manager);
        run();
    }
    private static void run() {
        int action;
        do{
        System.out.println("Pick action:\n" +
                "1.Add new Employee\n" +
                "2.Update new Employee by index\n" +
                "3.Remove an Employee\n" +
                "4.View Employees\n" +
                "5.Get out");
        action=getAction();
        execute(action);
        }while (action!=5);
    }
    private static void execute(int action) {
        switch (action){
            case 1:
                addNewEmployee();
                break;
            case 2:
                updateEmployee();
                break;
            case 3:
                removeEmployee();
                break;
            case 4:
                viewEmployee();
                break;
        }
    }
    private static void addNewEmployee() {
        System.out.println("Add new Employee selected");
        Employee inputEmployee=userInputEmployee();
        manager.add(inputEmployee);
    }

    private static void updateEmployee() {
        System.out.println("Update new Employee by index selected");
        if(manager.size()==0){
            System.out.println("No Employee detected. Return to Main menu");
            return;
        }
        int index=inputIndexToAct();
        Employee inputEmployee=userInputEmployee();
        manager.update(inputEmployee,index);
    }

    private static void removeEmployee() {
        System.out.println("Remove an Employee selected");
        if(manager.size()==0){
            System.out.println("No Employee detected. Return to Main menu");
            return;
        }
        int index=inputIndexToAct();
        manager.delete(index);
    }

    private static void viewEmployee() {
        System.out.println("View Employee selected");
        System.out.println(manager);
    }
    private static Employee userInputEmployee() {
        int typeOfEmployee;
        typeOfEmployee = getTypeOfEmployee();
        if (typeOfEmployee==3)return null;

        return InputEmployeeBasedOnType(typeOfEmployee) ;
    }
    private static int inputIndexToAct() {
        int result=-1;
        int size= manager.size();
        do{
            System.out.println("Input index");
            System.out.println("Current size is "+size);
            result=inputPositiveNumber();
        }while (result>=size);
        return result ;
    }
    private static Employee InputEmployeeBasedOnType(int typeOfEmployee) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input id");
        String id=scanner.nextLine();
        System.out.println("Input name");
        String name=scanner.nextLine();
        System.out.println("input age");
        int age=inputPositiveNumber();
        System.out.println("input phone");
        int phone=inputPositiveNumber();
        System.out.println("input email");
        String email=scanner.nextLine();
        if(typeOfEmployee==1){
            System.out.println("input bonus");
            int bonus=inputPositiveNumber();
            System.out.println("input fine");
            int fine=inputPositiveNumber();
            System.out.println("input salary");
            int salary=inputPositiveNumber();
            return new FullTimeEmployee(id,name,age,phone,email,bonus,fine,salary);
        }else if (typeOfEmployee==2){
            System.out.println("input workingHour");
            int workingHour=inputPositiveNumber();
            return new PartTimeEmployee(id,name,age,phone,email,workingHour);
        }
        throw new RuntimeException("Input typeOfEmployee is not 1 or 2");
    }
    private static int getTypeOfEmployee() {
        Scanner scanner=new Scanner(System.in);
        int index;
        do{
            System.out.println("What kind of Employee do you want to input");
            System.out.println("1. FullTimeEmployee");
            System.out.println("2. PartTimeEmployee");
            System.out.println("3. Get out");
            try {
                index = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                index = 0;
            }
        }while(index>3||index<1);
        return index;
    }
    private static int getAction() {
        int result=-1;
        try {
            System.out.println("input your action:");
            Scanner scanner = new Scanner(System.in);
            result = Integer.parseInt(scanner.nextLine());
        }catch (Exception e){}
        return result;
    }
    private static int inputPositiveNumber() {
        Scanner scanner=new Scanner(System.in);
        int num;
        do{
            System.out.println("input positive Integer");
            try {
                num = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                num=-1;
            }
        }while (num<0);
        return num;
    }
    private static void initData(List<Employee> employees) {
        Employee init1=new FullTimeEmployee("d","phuc",24,555443,"mail@mail",222,8888,99999);
        Employee init2=new PartTimeEmployee("d","phuc1",33,222222,"mail2@mail",11);
        employees.add(init1);
        employees.add(init2);
    }
}
