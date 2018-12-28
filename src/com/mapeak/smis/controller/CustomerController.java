package com.mapeak.smis.controller;
  
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebParam.Mode;

import org.hibernate.sql.Delete;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mapeak.smis.domain.Customer;
import com.mapeak.smis.service.CustomerService;

import antlr.collections.List;
 
@Controller
@RequestMapping("/customer")
public class CustomerController {

	//因为 save.jsp 页面在 WEB-INF 文件夹下，外部（浏览器）无法直接访问
	//用于跳转到 WEB-INF/jsp/save.jsp 页面
	@RequestMapping("/saveUI")
	public String saveUI(){
		return "save";
	}  
	 
	//注入 CustomerService 对象
	@Resource
	private CustomerService customerService;
	
	//删除客户
	//接收页面传过来的 id 集合，名称必须一致
	//restful 风格，DELETE 请求方式，即为：DELETE
	//PUT、DELETE 方式必须加上 @ResponseBody 注解，不然会报错
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE)
	public String delete(Long[] ids, Model model) {
		this.customerService.delete(ids);
		model.addAttribute("msg", "删除成功");
		return "success";
	}
	
	
	//修改客户
	//将前端返回的数据封装到 JavaBean 对象
	//restful 风格，PUT 请求方式，即为：UPDATE
	//PUT、DELETE 方式必须加上 @ResponseBody 注解，不然会报错
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public String Update(Customer customer, Model model){
		
		//更新数据
		this.customerService.update(customer);
		//返回处理结果
		model.addAttribute("msg", "修改成功");
		
		//处理后跳转页面
		return "success";
	}
	
	//查询一个客户
	//使用 restful 风格访问
	//返回的 id 值，获取 url 中的 id 值
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String findById(@PathVariable("id")Long id, Map<String, Object> model) {
		
		//根据返回的 id 查询数据，将查询的数据封装到 Map 集合
		Customer customer = this.customerService.findById(id);
		model.put("cust", customer);
		
		//跳转页面
		return "edit";
	}
	
	//查询所有客户
	@RequestMapping(method=RequestMethod.GET)
	public String List(Model model){
		//获取数据
		java.util.List<Customer> stuList = customerService.findAll();
		//将数据封装到 Model 中
		model.addAttribute("custList", stuList);
		//获取数据后页面跳转
		return "list";
	}
	 
	//添加用户
	//这里使用 restful 风格，并将表单的数据封装到 Customer 实体类中
	//这里数据返回页面，可以用  Model、ModelMap、Map，将数据返回到页面
	@RequestMapping(method=RequestMethod.POST)
	public String save(Customer customer, Map<String, Object> model){
		customerService.save(customer);
		//保存提示信息
		model.put("msg", "添加成功");
		//请求转发跳转到 success.jsp 页面
		return "success";
	}
	 
}






