package com.jack.test;

import com.jack.dao.BalanceDao;
import com.jack.dao.DepartmentDao;
import com.jack.pojo.Balance;
import com.jack.pojo.BalanceExample;
import com.jack.pojo.department;
import com.jack.pojo.deptDemo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class AppTest {
    @Test
    public  void  TestFindAll() throws IOException {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession =builder.openSession();
        DepartmentDao departmentDao=sqlSession.getMapper(DepartmentDao.class);
        List<department> departmentList=departmentDao.findAll();
        for (department department: departmentList) {
            System.out.println(department);
        }
//        sqlSession.commit();
        sqlSession.close();
        }

    @Test
    public  void  TestFindOneById() throws IOException {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession =builder.openSession();
        DepartmentDao departmentDao=sqlSession.getMapper(DepartmentDao.class);
        department dept=departmentDao.findOneById(1);

        System.out.println(dept);

//        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public  void  TestInsertOne() throws IOException {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession =builder.openSession();
        DepartmentDao departmentDao=sqlSession.getMapper(DepartmentDao.class);
        department d=new department();
        d.setName("IT");
        d.setLoc("Califonia");
        d.setDeptNo(1);
        int n=departmentDao.InsertOne(d);

        System.out.println(n);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void  TestCountDept() throws IOException {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession =builder.openSession();
        DepartmentDao departmentDao=sqlSession.getMapper(DepartmentDao.class);
        deptDemo d=new deptDemo();
        d.setNameLike("%IT%");
        int n=departmentDao.countDept(d);

        System.out.println(n);

        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public  void  TestCountDept2() throws IOException {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession =builder.openSession();
        BalanceDao balanceDao=sqlSession.getMapper(BalanceDao.class);
        BalanceExample example=new BalanceExample();
        BalanceExample.Criteria criteria=example.createCriteria();
        criteria.andNameLike("B%");
        criteria.andAmountGreaterThanOrEqualTo("5000");
        long n=balanceDao.countByExample(example);
        System.out.println(n);

        sqlSession.commit();
        sqlSession.close();
    }
}

