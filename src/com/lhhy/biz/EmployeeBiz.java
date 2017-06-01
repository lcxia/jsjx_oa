package com.lhhy.biz;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lhhy.bean.Message;
import com.lhhy.bean.Page;
import com.lhhy.bean.Employee;
import com.lhhy.dao.EmployeeDao;

public class EmployeeBiz {
	private EmployeeDao dao;
	private ObjectMapper mapper;
	
	public EmployeeBiz(){
		dao = new EmployeeDao();
		mapper = new ObjectMapper();
	}
	//查询所有营业人员，抛出json字符串
		public String queryAllEmployee(Page page){
			String data = "";
			List<Employee> list = dao.queryAllEmployee(page);
			int count = dao.employeeCount();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("total", count);
			map.put("rows", list);
			try {
				data = mapper.writeValueAsString(map);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return data;
		}
		//添加营业人员
		public String addEmployee(Employee q){
			Message msg = new Message();
			List<Employee> list = dao.queryEmployeeIsSame(q.getEmployeeName());
			if(list.size()>0){
				msg.setSuccess(false);
				msg.setErrorMsg("营业人员姓名已经存在，不能添加");
			}
			else{
				int temp = dao.addEmployee(q);
				if(temp>0){
					msg.setSuccess(true);
					msg.setErrorMsg(null);
				}
				else{
					msg.setSuccess(false);
					msg.setErrorMsg("添加失败");
				}
			}
			String rs = "";
			try {
				rs = mapper.writeValueAsString(msg);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		//修改营业人员
		public String editEmployee(Employee q){
			Message msg = new Message();
			int temp = dao.editEmployee(q);
			if(temp>0){
				msg.setSuccess(true);
				msg.setErrorMsg(null);
			}
			else{
				msg.setSuccess(false);
				msg.setErrorMsg("修改失败");
			}
			String rs = "";
			try {
				rs = mapper.writeValueAsString(msg);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
	    
	  //删除营业人员
		public String deleteEmployee(String id){
			Message msg = new Message();
			int temp = dao.deleteEmployee(id);
			if(temp>0){
				msg.setSuccess(true);
				msg.setErrorMsg("已删除");
			}
			else{
				msg.setSuccess(false);
				msg.setErrorMsg("删除失败");
			}
			String rs = "";
			try {
				rs = mapper.writeValueAsString(msg);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return rs;
		}
		
		//根据用户名和密码查询用户
		public Employee queryEmployee(String name,String pass){
			List<Employee> list = dao.queryEmployee(name, pass);
			if(list.size()>0){
				return list.get(0);
			}
			else{
				return null;
			}
		}
}
		
