package com.mapeak.smis.dao;

import com.mapeak.smis.domain.Customer;

import antlr.collections.List;
import java.util.*;

public interface CustomerDao {

	//删除
	public void delete(Long id);
	
	//更新客户
	public void update(Customer customer);
	
	//保存
	public void save(Customer customer);
	 
	//查询所有
	public java.util.List<Customer> findAll();
	
	//查询一个客户
	public Customer findById(Long id);
	
}
