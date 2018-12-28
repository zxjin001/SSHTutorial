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

	//��Ϊ save.jsp ҳ���� WEB-INF �ļ����£��ⲿ����������޷�ֱ�ӷ���
	//������ת�� WEB-INF/jsp/save.jsp ҳ��
	@RequestMapping("/saveUI")
	public String saveUI(){
		return "save";
	}  
	 
	//ע�� CustomerService ����
	@Resource
	private CustomerService customerService;
	
	//ɾ���ͻ�
	//����ҳ�洫������ id ���ϣ����Ʊ���һ��
	//restful ���DELETE ����ʽ����Ϊ��DELETE
	//PUT��DELETE ��ʽ������� @ResponseBody ע�⣬��Ȼ�ᱨ��
	@ResponseBody
	@RequestMapping(method=RequestMethod.DELETE)
	public String delete(Long[] ids, Model model) {
		this.customerService.delete(ids);
		model.addAttribute("msg", "ɾ���ɹ�");
		return "success";
	}
	
	
	//�޸Ŀͻ�
	//��ǰ�˷��ص����ݷ�װ�� JavaBean ����
	//restful ���PUT ����ʽ����Ϊ��UPDATE
	//PUT��DELETE ��ʽ������� @ResponseBody ע�⣬��Ȼ�ᱨ��
	@ResponseBody
	@RequestMapping(method=RequestMethod.PUT)
	public String Update(Customer customer, Model model){
		
		//��������
		this.customerService.update(customer);
		//���ش�����
		model.addAttribute("msg", "�޸ĳɹ�");
		
		//�������תҳ��
		return "success";
	}
	
	//��ѯһ���ͻ�
	//ʹ�� restful ������
	//���ص� id ֵ����ȡ url �е� id ֵ
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String findById(@PathVariable("id")Long id, Map<String, Object> model) {
		
		//���ݷ��ص� id ��ѯ���ݣ�����ѯ�����ݷ�װ�� Map ����
		Customer customer = this.customerService.findById(id);
		model.put("cust", customer);
		
		//��תҳ��
		return "edit";
	}
	
	//��ѯ���пͻ�
	@RequestMapping(method=RequestMethod.GET)
	public String List(Model model){
		//��ȡ����
		java.util.List<Customer> stuList = customerService.findAll();
		//�����ݷ�װ�� Model ��
		model.addAttribute("custList", stuList);
		//��ȡ���ݺ�ҳ����ת
		return "list";
	}
	 
	//����û�
	//����ʹ�� restful ��񣬲����������ݷ�װ�� Customer ʵ������
	//�������ݷ���ҳ�棬������  Model��ModelMap��Map�������ݷ��ص�ҳ��
	@RequestMapping(method=RequestMethod.POST)
	public String save(Customer customer, Map<String, Object> model){
		customerService.save(customer);
		//������ʾ��Ϣ
		model.put("msg", "��ӳɹ�");
		//����ת����ת�� success.jsp ҳ��
		return "success";
	}
	 
}






