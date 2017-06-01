package com.lhhy.biz;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lhhy.bean.Evection;
import com.lhhy.bean.Message;
import com.lhhy.bean.Page;
import com.lhhy.dao.EvectionDao;

public class EvectionBiz {
	private EvectionDao dao;
	private ObjectMapper mapper;
	
	public EvectionBiz(){
		dao = new EvectionDao();
		mapper = new ObjectMapper();
	}
	
	//查询所有出差日程，抛出json字符串
	public String queryAllEvection(Page page){
		String data = "";
		List<Evection> list = dao.queryAllEvection(page);
		int count = dao.evectionCount();
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
	//添加出差日程
	public String addEvection(Evection e){
		Message msg = new Message();
		List<Evection> list = dao.queryEvectionIsSame(e);
		if(list.size()>0){
			msg.setSuccess(false);
			msg.setErrorMsg("出差人员已经存在，不能添加");
		}
		else{
			int temp = dao.addEvection(e);
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
		} catch (JsonGenerationException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		} catch (JsonMappingException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		} catch (IOException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		}
		return rs;
	}
	
	//修改出差日程
	public String editEvection(Evection e){
		Message msg = new Message();
		int temp = dao.editEvection(e);
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
		} catch (JsonGenerationException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		} catch (JsonMappingException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		} catch (IOException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		}
		return rs;
	}

//删除出差日程
		public String deleteEvection(String id){
			Message msg = new Message();
			int temp = dao.deleteEvection(id);
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