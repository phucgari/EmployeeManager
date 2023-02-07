package storage;

import employee.Employee;
import employee.FullTimeEmployee;
import employee.PartTimeEmployee;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteEmployee {
    public static List<Employee> readObjects(String s) {
        List<Employee> result;
        try {
            ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(s));
        } catch (IOException e) {
            return result=new LinkedList<>();
        }
        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(s))) {
            result= (List<Employee>) objectInputStream.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ;

        return result;
    }
}
