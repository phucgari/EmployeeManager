package manager;

import employee.Employee;
import employee.FullTimeEmployee;
import employee.PartTimeEmployee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {
    EmployeeManager test1=new EmployeeManager();
    List<Employee> employees=new ArrayList<>();
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
    @Test
    void getLowSalaryFullTimeEmployee(){
        Employee[] result=test1.getLowSalaryFullTimeEmployee();
        Employee[] expected=new Employee[]{demo3};
        for (int i = 0; i < result.length; i++) {
            compare2Employee(result[i],expected[i]);
        }

        result=test2.getLowSalaryFullTimeEmployee();
        expected=new Employee[]{demo4};
        for (int i = 0; i < result.length; i++) {
            compare2Employee(result[i],expected[i]);
        }

        Employee demo5=new FullTimeEmployee("11","44444",9,8889,"fffg@mail",4440,33,22220);
        result=test2.getLowSalaryFullTimeEmployee();
        expected=new Employee[]{demo4,demo5};
        for (int i = 0; i < result.length; i++) {
            compare2Employee(result[i],expected[i]);
        }

        Employee demo6=new FullTimeEmployee("11","44444",9,8889,"fffg@mail",4440,33,22220000);
        result=test2.getLowSalaryFullTimeEmployee();
        expected=new Employee[]{demo4,demo5};
        for (int i = 0; i < result.length; i++) {
            compare2Employee(result[i],expected[i]);
        }

        test1.delete(1);
        result= test1.getLowSalaryFullTimeEmployee();
        assertNull(result);
    }
    @Test
    void testTotalSalaryPartTime(){
        assertEquals(3300000,test1.getTotalSalaryPartTime());
        assertEquals(2200000,test2.getTotalSalaryPartTime());
        test1.add(demo2);
        assertEquals(5500000,test1.getTotalSalaryPartTime());
        test2.delete(0);
        assertEquals(0,test2.getTotalSalaryPartTime());
    }
    @Test
    void sortFullTimeEmployee(){
        test1.add(demo4);
        List<Employee> result = test1.sortFullTimeEmployee();
        List<Employee> expected=new ArrayList<>();
        expected.add(demo4);
        expected.add(demo3);
        for (int i = 0; i < 2; i++) {
            compare2Employee(result.get(i),expected.get(i));
        }

        Employee demo5= new FullTimeEmployee("11","44444",9,8889,"fffg@mail",444,33,7777);
        test1.add(demo5);
        result=test1.sortFullTimeEmployee();
        expected.add(1,demo5);
        for (int i = 0; i < 3; i++) {
            compare2Employee(result.get(i),expected.get(i));
        }

        test2.delete(1);
        result=test2.sortFullTimeEmployee();
        expected=new ArrayList<>();
        assertTrue(result.equals(expected));
    }
    @Test
    void testToString(){
        assertEquals("Employee(s) list:\n" +
                "PartTimeEmployee{id='4', name='11', age=44, phone=999999, email='ddd@mail', workingHour=33} \n" +
                "FullTimeEmployee{id='33', name='vvvv', age=33, phone=22222, email='fff@mail', bonus=555, fine=3333, salary=22222} \n",test1.toString());
        assertEquals("Employee(s) list:\n" +
                "PartTimeEmployee{id='4', name='11', age=44, phone=999999, email='ddd@mail', workingHour=33} \n" +
                "FullTimeEmployee{id='33', name='vvvv', age=33, phone=22222, email='fff@mail', bonus=555, fine=3333, salary=22222} \n",test1.toString());
    }
    @Test
    void testSize() {
        assertEquals(2, test1.size());
        test1.delete(1);
        assertEquals(1, test1.size());
        assertEquals(2, test2.size());
    }
}