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
import com.lhhy.bean.ServiceComplain;
import com.lhhy.dao.ServiceComplainDao;

public class ServiceComplainBiz {
	private ServiceComplainDao dao;
	//声明一个用于转换数据格式的类json
	private ObjectMapper mapper;
	//在构造方法中对dao进行实例化
	public ServiceComplainBiz(){
		dao = new ServiceComplainDao();
		mapper = new ObjectMapper();
}
	//分页查询所有服务/投诉，抛出json字符串
			public String queryAllServiceComplain(Page page){
				String data = "";//存放转换后的数据的字符串
				//通过dao层获得数据集合
				List<ServiceComplain> list = dao.queryAllServiceComplain(page);
				int count = dao.serviceComplainCount();
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("total", count);
				map.put("rows", list);
				//将数据集合转换成json字符串
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
				//抛出字符串
				return data;
			}
//根据id查服务/投诉
			public String queryServiceComplain(String id){
				String data = "";
				List<ServiceComplain> list = dao.queryServiceComplain(id);
				try {
					data = mapper.writeValueAsString(list);
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
//添加服务/投诉
			public String addServiceComplain(ServiceComplain q){
				//设置message的对象
				Message msg = new Message();
				//调用dao层中，查询的的方法，来检查账号是否已经存在
				List<ServiceComplain> list = dao.queryServiceComplainIsSame(q.getServiceComplainCode());
				if(list.size()>0){
					//账号已经存在
					msg.setSuccess(false);
					msg.setErrorMsg("服务/投诉号已经存在，不能添加");
				}
				else{
					//如果不存在，调用dao中保存方法，将数据写入数据库
					int temp = dao.addServiceComplain(q);
					if(temp>0){
						msg.setSuccess(true);
						msg.setErrorMsg(null);
					}
					else{
						msg.setSuccess(false);
						msg.setErrorMsg("添加失败");
					}
				}
				//返回结果
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
//修改服务/投诉
			public String editServiceComplain(ServiceComplain q){
				//设置message的对象
				Message msg = new Message();
				//调用dao中修改方法，将数据写入数据库
				int temp = dao.editServiceComplain(q);
				if(temp>0){
					msg.setSuccess(true);
					msg.setErrorMsg(null);
				}
				else{
					msg.setSuccess(false);
					msg.setErrorMsg("修改失败");
				}
				//返回结果
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
		    
//删除服务/投诉
			public String deleteServiceComplain(String id){
				//消息对象
				Message msg = new Message();
				//调用dao，获得结果
				int temp = dao.deleteServiceComplain(id);
				if(temp>0){
					msg.setSuccess(true);
					msg.setErrorMsg("已删除");
				}
				else{
					msg.setSuccess(false);
					msg.setErrorMsg("删除失败");
				}
				//返回结果
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
}
