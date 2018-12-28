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
		customer.setName("白世镜");
		customer.setTelephone("13290750669");
		
		//读取配置文件，即 applicationContext.xml 文件
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//从 IOC 容器中获取 CustomerService 对象
		CustomerService cs = (CustomerService)ac.getBean("customerServiceImpl");
		
		//数据被存储到数据库中
		cs.save(customer);

	}
	 
	 //@Test
	 public void test2(){
		 ApplicationContext ac = 
					new ClassPathXmlApplicationContext("applicationContext.xml");
			
			//从 IOC 容器中获取 CustomerService 对象
			CustomerService cs = (CustomerService)ac.getBean("customerServiceImpl");
		 java.util.List<Customer> list = cs.findAll();
		 for (Customer customer : list) {
			 System.out.println(customer.getName());
		 }
	 }
}
