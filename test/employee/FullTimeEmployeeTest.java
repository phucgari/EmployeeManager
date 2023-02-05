package employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FullTimeEmployeeTest {
    FullTimeEmployee test1=new FullTimeEmployee();
    FullTimeEmployee test2=new FullTimeEmployee("ff","test2",20,33,"yes@gmail",33,222,333);
    @BeforeEach
    void init(){
        test1.setAge(22);
        test1.setFine(11);
        test1.setName("test1");
        test1.setId("pp");
        test1.setPhone(3333344);
        test1.setEmail("ff@mail.com");
        test1.setBonus(22);
        test1.setSalary(333);
    }
    @Test
    void testGetSet(){
        assertEquals(22,test1.getAge());
        assertEquals(11,test1.getFine());
        assertEquals("test1",test1.getName());
        assertEquals("pp",test1.getId());
        assertEquals(3333344,test1.getPhone());
        assertEquals("ff@mail.com",test1.getEmail());
        assertEquals(22,test1.getBonus());
        assertEquals(333,test1.getSalary());

        assertEquals(20,test2.getAge());
        assertEquals(222,test2.getFine());
        assertEquals("test2",test2.getName());
        assertEquals("ff",test2.getId());
        assertEquals(33,test2.getPhone());
        assertEquals("yes@gmail",test2.getEmail());
        assertEquals(33,test2.getBonus());
        assertEquals(333,test2.getSalary());

        test2.setAge(66);
        test2.setFine(55);
        test2.setName("test3");
        test2.setId("TT");
        test2.setPhone(33332222);
        test2.setEmail("gg@mail.com");
        test2.setBonus(11);
        test2.setSalary(2222);

        assertEquals(66,test2.getAge());
        assertEquals(55,test2.getFine());
        assertEquals("test3",test2.getName());
        assertEquals("TT",test2.getId());
        assertEquals(33332222,test2.getPhone());
        assertEquals("gg@mail.com",test2.getEmail());
        assertEquals(11,test2.getBonus());
        assertEquals(2222,test2.getSalary());
    }
    @Test
    void testGetRealSalary(){
        assertEquals(344,test1.getRealSalary());
        assertEquals(144,test2.getRealSalary());
    }
    @Test
    void testToString(){
        assertEquals("FullTimeEmployee{id='pp', name='test1', age=22, phone=3333344, email='ff@mail.com', bonus=22, fine=11, salary=333} ",test1.toString());
        assertEquals("FullTimeEmployee{id='ff', name='test2', age=20, phone=33, email='yes@gmail', bonus=33, fine=222, salary=333} ",test2.toString());
    }
}