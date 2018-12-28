package com.mapeak.smis.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapeak.smis.dao.CustomerDao;
import com.mapeak.smis.domain.Customer;
import com.mapeak.smis.service.CustomerService;

//���ö���ע�� IOC ����
@Service
//��ʼ����
@Transactional
public class CustomerServiceImpl implements CustomerService {

	//�� IOC �����л�ȡ DAO ����
	@Resource
	private CustomerDao customerDao;

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			this.customerDao.delete(id);
		}
	}

	@Override
	public void update(Customer customer) {
		this.customerDao.update(customer); 
	}

	@Override
	public void save(Customer customer) {
		this.customerDao.save(customer);
	}
 
	@Override
	public List<Customer> findAll() {
		return this.customerDao.findAll();
	}

	@Override
	public Customer findById(Long id) {
		return this.customerDao.findById(id);
	}

} 
