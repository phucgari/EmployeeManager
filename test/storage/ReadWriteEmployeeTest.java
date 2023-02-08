package storage;

import employee.Employee;
import employee.FullTimeEmployee;
import employee.PartTimeEmployee;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadWriteEmployeeTest {
    @Test
    void testReader(){
        List<Employee> result=ReadWriteEmployee.readObjects("test/testFileCases/test.dat");
        Employee expected= new FullTimeEmployee("12","23123",3123,3123123,"4443@mail",23424,333,2323);
        assertEquals(expected.toString(),result.get(0).toString());
        expected= new PartTimeEmployee("22","324234",3123,3123123,"4343@mail",321);
        assertEquals(expected.toString(),result.get(1).toString());

        result=ReadWriteEmployee.readObjects("testNull.dat");
        assertEquals("[]",result.toString());
    }
    @Test
    void testWriter(){
        Employee test1=new FullTimeEmployee("testWriter","writer",111222,222,"33243@mail",1,22,2323);
        Employee test2=new PartTimeEmployee("testWriter1","write",222,312322123,"43ee3@mail",32331);
        List<Employee> employees=new LinkedList<>();
        employees.add(test1);
        employees.add(test2);
        ReadWriteEmployee.writeObjects(employees,"test/testFileCases/testWriter.dat");
        List<Employee> result=ReadWriteEmployee.readObjects("test/testFileCases/testWriter.dat");
        assertEquals(result.toString(),employees.toString());

        employees.remove(0);
        ReadWriteEmployee.writeObjects(employees,"test/testFileCases/testWriter.dat");
        result=ReadWriteEmployee.readObjects("test/testFileCases/testWriter.dat");
        assertEquals(result.toString(),employees.toString());
    }
}