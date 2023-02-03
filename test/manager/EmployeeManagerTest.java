package manager;

import employee.Employee;
import employee.FullTimeEmployee;
import employee.PartTimeEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {
    EmployeeManager test1=new EmployeeManager();
    ArrayList<Employee> employees=new ArrayList<>();
    EmployeeManager test2=new EmployeeManager(employees);
    Employee result;
    Employee expected;
    Employee demo1;
    Employee demo2;
    Employee demo3;
    Employee demo4;
    @BeforeEach
    void initialData(){
        demo1=new PartTimeEmployee("4","11",44,999999,"ddd@mail",33);
        demo2=new PartTimeEmployee("tt","22",333,2222,"ppp@mail",22);
        demo3=new FullTimeEmployee("33","vvvv",33,22222,"fff@mail",555,3333,22222);
        demo4=new FullTimeEmployee("11","44444",9,8889,"fffg@mail",444,33,2222);
        test1.add(demo1);
        test1.add(demo3);
        employees.add(demo2);
        employees.add(demo4);
    }
    @Test
    void testGetByIndex(){
        result= test1.get(0);
        expected=demo1;
        compare2Employee(result, expected);

        result=test1.get(1);
        expected=demo3;
        compare2Employee(result, expected);

        result=test2.get(0);
        expected=demo2;
        compare2Employee(result,expected);

        result=test2.get(1);
        expected=demo4;
        compare2Employee(result,expected);

        result=test2.get(-1);
        expected=null;
        assertNull(result);

        result=test2.get(3);
        assertNull(result);

        result=test1.get(2);
        assertNull(result);
    }
    private static void compare2Employee(Employee r, Employee e) {
        if(r instanceof PartTimeEmployee&&e instanceof PartTimeEmployee){
            PartTimeEmployee result=(PartTimeEmployee)r;
            PartTimeEmployee expected=(PartTimeEmployee) e;
            assertEquals(result.getWorkingHour(),expected.getWorkingHour());
        } else if (e instanceof FullTimeEmployee&&r instanceof FullTimeEmployee) {
            FullTimeEmployee result=(FullTimeEmployee) r;
            FullTimeEmployee expected=(FullTimeEmployee) e;
            assertEquals(result.getSalary(),expected.getSalary());
            assertEquals(result.getFine(),expected.getFine());
            assertEquals(result.getBonus(),expected.getBonus());
        }
        assertEquals(r.getId(), e.getId());
        assertEquals(r.getName(), e.getName());
        assertEquals(r.getAge(), e.getAge());
        assertEquals(r.getPhone(), e.getPhone());
        assertEquals(r.getEmail(), e.getEmail());

    }
    @Test
    void testDeleteEmployee(){
        test1.delete(0);
        result= test1.get(0);
        expected=demo3;
        compare2Employee(expected,result);
        result= test1.get(1);
        assertNull(result);

        test1.delete(0);
        result= test1.get(0);
        assertNull(result);

        test2.delete(1);
        result= test2.get(0);
        expected=demo2;
        compare2Employee(expected,result);
        result= test2.get(1);
        assertNull(result);
    }
    @Test
    void testUpdateEmployee(){
        test1.update(demo2,1);
        result=test1.get(1);
        expected=demo2;
        compare2Employee(expected,result);
        result=test1.get(2);
        assertNull(result);

        test2.update(demo4,0);
        result=test2.get(0);
        expected=demo4;
        compare2Employee(expected,result);
        result=test2.get(1);
        expected=demo4;
        compare2Employee(expected,result);
    }
    @Test
    void testAveragePaid(){
        assertEquals(1659722,test1.getAveragePaid());
        test2.add(demo1);
        assertEquals(1834211,test2.getAveragePaid());
        test1.delete(0);
        test1.delete(0);
        assertEquals(0,test1.getAveragePaid());
    }
}