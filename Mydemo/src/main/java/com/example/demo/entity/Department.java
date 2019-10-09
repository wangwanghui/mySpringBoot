package com.example.demo.entity;


import java.util.Date;
import java.util.List;

public class Department {
        private Long id;

        private String deptName;

        private String descr;

        private Date createTime;

        List<Employee> employees;
      public  Department(){

      }

    public Department(Long id,String deptName, String descr, Date createTime) {
        this.id = id;
        this.deptName = deptName;
        this.descr = descr;
        this.createTime = createTime;
    }



}
