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
import com.lhhy.bean.Conference;
import com.lhhy.dao.ConferenceDao;

public class ConferenceBiz {
	private ConferenceDao dao;
	private ObjectMapper mapper;
	
	public ConferenceBiz(){
		dao = new ConferenceDao();
		mapper = new ObjectMapper();
	}
	
	//查询所有客户，抛出json字符串
	public String queryAllConference(Page page){
		String data = "";
		List<Conference> list = dao.queryAllConference(page);
		int count = dao.conferenceCount();
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
	public String addConference(Conference q){
		Message msg = new Message();
		List<Conference> list = dao.queryConferenceIsSame(q.getConferenceCode());
		if(list.size()>0){
			msg.setSuccess(false);
			msg.setErrorMsg("会议报告已经存在，不能添加");
		}
		else{
			int temp = dao.addConference(q);
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
	
	//修改会议报告
	    public String editConference(Conference q){
		Message msg = new Message();
		int temp = dao.editConference(q);
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
	
	//删除会议报告
	public String deleteConference(String id){
		Message msg = new Message();
		int temp = dao.deleteConference(id);
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

