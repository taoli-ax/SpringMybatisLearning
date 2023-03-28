package com.jack.dao;

import com.jack.pojo.department;
import com.jack.pojo.deptDemo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentDao {
    @Select("select * from department")
    List<department> findAll();
    @Select("select * from department where id=#{id}")
    department findOneById(int id);
    @Insert("insert into department(name,deptNo,loc) values(#{name},#{deptNo},#{loc})")
    int InsertOne(department department);

    int countDept(deptDemo deptDemo);
}
