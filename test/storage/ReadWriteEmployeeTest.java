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
        List<Employee> result=ReadWriteEmployee.readObjects("test.dat");
        Employee expected= new FullTimeEmployee("12","23123",3123,3123123,"4443@mail",23424,333,2323);
        assertEquals(expected.toString(),result.get(0).toString());
        expected= new PartTimeEmployee("22","324234",3123,3123123,"4343@mail",321);
        assertEquals(expected.toString(),result.get(1).toString());

        result=ReadWriteEmployee.readObjects("testnull.dat");
        assertEquals("[]",result.toString());
    }
}