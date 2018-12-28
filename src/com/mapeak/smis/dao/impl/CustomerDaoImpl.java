package com.mapeak.smis.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.mapeak.smis.dao.CustomerDao;
import com.mapeak.smis.domain.Customer;
 
@Repository
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	//ע�� SessionFactory ����
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	//hibernateTemplate ģ��û���ṩֱ�Ӹ��� id ��ɾ�����ݵķ��������������ȸ���
	//id �����Ҷ���Ȼ���ٽ����ҵ���ʵ�������ɾ��
	
	@Override
	public void delete(Long id) {
		this.getHibernateTemplate().delete(findById(id));
	}

	@Override
	public void update(Customer customer) {
		this.getHibernateTemplate().update(customer);
	}
 
	@Override
	public Customer findById(Long id) {
		return this.getHibernateTemplate().get(Customer.class, id);
	}
	   
	@Override
	public void save(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	@Override
	public List<Customer> findAll() {
		//Hibernate ģ���ѯ��������
		return this.getHibernateTemplate().loadAll(Customer.class);
	}


}
