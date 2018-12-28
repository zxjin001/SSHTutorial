package com.mapeak.smis.service;
 
import java.util.List;

import com.mapeak.smis.domain.Customer;

public interface CustomerService {

	//根据 id 值数组删除
	public void delete(Long[] ids);
	
	//更新对象
	public void update(Customer customer);
	
	//保存对象
	public void save(Customer customer);
	
	//查询所有
	public List<Customer> findAll();
	
	//根据 id 查询客户
	public Customer findById(Long id);
	
}
