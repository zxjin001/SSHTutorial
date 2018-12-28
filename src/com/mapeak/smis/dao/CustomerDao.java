package com.mapeak.smis.dao;

import com.mapeak.smis.domain.Customer;

import antlr.collections.List;
import java.util.*;

public interface CustomerDao {

	//ɾ��
	public void delete(Long id);
	
	//���¿ͻ�
	public void update(Customer customer);
	
	//����
	public void save(Customer customer);
	 
	//��ѯ����
	public java.util.List<Customer> findAll();
	
	//��ѯһ���ͻ�
	public Customer findById(Long id);
	
}
