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
import com.lhhy.bean.Client;
import com.lhhy.dao.ClientDao;

public class ClientBiz {
	private ClientDao dao;
	private ObjectMapper mapper;
	
	public ClientBiz(){
		dao = new ClientDao();
		mapper = new ObjectMapper();
	}
	
	//查询所有客户，抛出json字符串
	public String queryAllClient(Page page){
		String data = "";
		List<Client> list = dao.queryAllClient(page);
		int count = dao.clientCount();
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
	
	//添加客户
	public String addClient(Client q){
		Message msg = new Message();
		List<Client> list = dao.queryClientIsSame(q.getClientName());
		if(list.size()>0){
			msg.setSuccess(false);
			msg.setErrorMsg("客户已经存在，不能添加");
		}
		else{
			int temp = dao.addClient(q);
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
	
	//修改报价
	public String editClient(Client q){
		Message msg = new Message();
		int temp = dao.editClient(q);
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
	
	//删除报价
	public String deleteClient(String id){
		Message msg = new Message();
		int temp = dao.deleteClient(id);
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
}

