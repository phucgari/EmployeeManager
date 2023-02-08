package storage;

import employee.Employee;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteEmployee {
    public static List<Employee> readObjects(String s) {
        List<Employee> result;
        //Catch emptyErr
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

    public static void writeObjects(List<Employee> employees, String s) {
        try(ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(s))){
            objectOutputStream.writeObject(employees);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
