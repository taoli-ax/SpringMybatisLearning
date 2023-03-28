package com.coh.test;

import com.coh.dao.DepartmentDao;
import com.coh.pojo.Department;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    @Test
    public void SMTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("file:src/main/resources/app.xml");
        DepartmentDao departmentDao=(DepartmentDao)applicationContext.getBean("departmentDao");
        Department department =departmentDao.selectByPrimaryKey(33);
        System.out.println(department);

}
}
