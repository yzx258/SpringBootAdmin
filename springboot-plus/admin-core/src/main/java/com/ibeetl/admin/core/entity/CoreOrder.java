package com.ibeetl.admin.core.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.beetl.sql.core.annotatoin.AutoID;
import org.beetl.sql.core.annotatoin.SeqID;

import com.ibeetl.admin.core.util.ValidateConfig;

import org.beetl.sql.core.TailBean;
import java.math.*;

import com.ibeetl.admin.core.annotation.Dict;
import com.ibeetl.admin.core.entity.BaseEntity;

/* 
* 
* gen by Spring Boot2 Admin 2018-11-27
*/
public class CoreOrder extends BaseEntity{

    @NotNull(message = "ID不能为空", groups =ValidateConfig.UPDATE.class)
    @SeqID(name = ORACLE_CORE_SEQ_NAME)
    @AutoID	
	
    private Integer id ;
	
	
    private String name ;
	
	
    private String age ;
	
	
    private String address ;
	
    public CoreOrder()
    {
    }

    public Integer getId(){
	    return  id;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
	    return  name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getAge(){
	    return  age;
    }
    public void setAge(String age){
        this.age = age;
    }

    public String getAddress(){
	    return  address;
    }
    public void setAddress(String address){
        this.address = address;
    }


}
