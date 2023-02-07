import employee.Employee;
import employee.FullTimeEmployee;
import employee.PartTimeEmployee;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        File file =new File("test.dat");
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        Employee test1=new FullTimeEmployee("12","23123",3123,3123123,"4443@mail",23424,333,2323);
        Employee test2=new PartTimeEmployee("22","324234",3123,3123123,"4343@mail",321);
        List<Employee> employees=new LinkedList<>();
        employees.add(test1);
        employees.add(test2);
        objectOutputStream.writeObject(employees);
    }
}
