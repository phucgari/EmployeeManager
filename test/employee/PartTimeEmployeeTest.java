package employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartTimeEmployeeTest {
    PartTimeEmployee test1=new PartTimeEmployee();
    PartTimeEmployee test2=new PartTimeEmployee("ff","test2",20,33,"yes@gmail",33);
    @BeforeEach
    void init(){
        test1.setId("44");
        test1.setName("test1");
        test1.setAge(33);
        test1.setPhone(55);
        test1.setEmail("pop@gmail");
        test1.setWorkingHour(22);
    }
    @Test
    void testSetGet(){
        assertEquals("44",test1.getId());
        assertEquals("test1",test1.getName());
        assertEquals(33,test1.getAge());
        assertEquals(55,test1.getPhone());
        assertEquals("pop@gmail",test1.getEmail());
        assertEquals(22,test1.getWorkingHour());

        assertEquals("ff",test2.getId());
        assertEquals("test2",test2.getName());
        assertEquals(20,test2.getAge());
        assertEquals(33,test2.getPhone());
        assertEquals("yes@gmail",test2.getEmail());
        assertEquals(33,test2.getWorkingHour());

        test2.setId("66");
        test2.setName("test3");
        test2.setAge(111);
        test2.setPhone(5555);
        test2.setEmail("pddd@gmail");
        test2.setWorkingHour(44);

        assertEquals("66",test2.getId());
        assertEquals("test3",test2.getName());
        assertEquals(111,test2.getAge());
        assertEquals(5555,test2.getPhone());
        assertEquals("pddd@gmail",test2.getEmail());
        assertEquals(44,test2.getWorkingHour());
    }
    @Test
    void testGetRealSalary(){
        assertEquals(2200000,test1.getRealSalary());
        assertEquals(3300000,test2.getRealSalary());
    }
    @Test
    void testToString(){
        assertEquals("PartTimeEmployee{id='44', name='test1', age=33, phone=55, email='pop@gmail', workingHour=22} ",test1.toString());
        assertEquals("PartTimeEmployee{id='ff', name='test2', age=20, phone=33, email='yes@gmail', workingHour=33} ",test2.toString());
        PartTimeEmployee test3=new PartTimeEmployee();
    }
}