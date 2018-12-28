package com.mapeak.smis.service;
 
import java.util.List;

import com.mapeak.smis.domain.Customer;

public interface CustomerService {

	//���� id ֵ����ɾ��
	public void delete(Long[] ids);
	
	//���¶���
	public void update(Customer customer);
	
	//�������
	public void save(Customer customer);
	
	//��ѯ����
	public List<Customer> findAll();
	
	//���� id ��ѯ�ͻ�
	public Customer findById(Long id);
	
}
