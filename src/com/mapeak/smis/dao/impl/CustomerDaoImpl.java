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

	//注入 SessionFactory 对象
	@Resource
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	//hibernateTemplate 模板没有提供直接根据 id 来删除数据的方法，所以这里先根据
	//id 来查找对象，然后再将查找到的实体对象来删除
	
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
		//Hibernate 模板查询所有数据
		return this.getHibernateTemplate().loadAll(Customer.class);
	}


}
