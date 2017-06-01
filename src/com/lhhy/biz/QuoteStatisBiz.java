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
import com.lhhy.bean.QuoteStatis;
import com.lhhy.dao.QuoteStatisDao;

public class QuoteStatisBiz {
	private QuoteStatisDao dao;
	private ObjectMapper mapper;
	
	public QuoteStatisBiz(){
		dao = new QuoteStatisDao();
		mapper = new ObjectMapper();
	}
	
	//查询所有报价统计，抛出json字符串
	public String queryAllQuoteStatis(Page page){
		String data = "";
		List<QuoteStatis> list = dao.queryAllQuoteStatis(page);
		int count = dao.quoteStatisCount();
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
	
	//添加报价统计
	public String addQuoteStatis(QuoteStatis q){
		Message msg = new Message();
		List<QuoteStatis> list = dao.queryQuoteStatisIsSame(q.getQuoteStatisDate());
		if(list.size()>0){
			msg.setSuccess(false);
			msg.setErrorMsg("报价统计已经存在，不能添加");
		}
		else{
			int temp = dao.addQuoteStatis(q);
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
	
	//修改报价统计
	public String editQuoteStatis(QuoteStatis q){
		Message msg = new Message();
		int temp = dao.editQuoteStatis(q);
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
	
	//删除报价统计
	public String deleteQuoteStatis(String id){
		Message msg = new Message();
		int temp = dao.deleteQuoteStatis(id);
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

