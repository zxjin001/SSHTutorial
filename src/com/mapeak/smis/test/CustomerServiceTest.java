package com.mapeak.smis.test;

import java.io.PrintWriter;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mapeak.smis.domain.Customer;
import com.mapeak.smis.service.CustomerService;

import antlr.collections.List;

public class CustomerServiceTest {

	 public static void main(String[] args){
	 		
		Customer customer = new Customer();
		customer.setName("������");
		customer.setTelephone("13290750669");
		
		//��ȡ�����ļ����� applicationContext.xml �ļ�
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//�� IOC �����л�ȡ CustomerService ����
		CustomerService cs = (CustomerService)ac.getBean("customerServiceImpl");
		
		//���ݱ��洢�����ݿ���
		cs.save(customer);

	}
	 
	 //@Test
	 public void test2(){
		 ApplicationContext ac = 
					new ClassPathXmlApplicationContext("applicationContext.xml");
			
			//�� IOC �����л�ȡ CustomerService ����
			CustomerService cs = (CustomerService)ac.getBean("customerServiceImpl");
		 java.util.List<Customer> list = cs.findAll();
		 for (Customer customer : list) {
			 System.out.println(customer.getName());
		 }
	 }
}
