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
import com.lhhy.bean.Quote;
import com.lhhy.dao.QuoteDao;

public class QuoteBiz {
	private QuoteDao dao;
	private ObjectMapper mapper;
	
	public QuoteBiz(){
		dao = new QuoteDao();
		mapper = new ObjectMapper();
	}
	
	//查询所有报价，抛出json字符串
	public String queryAllQuote(Page page){
		//存放转换后的数据的字符串
		String data = "";
		//通过dao层获得数据集合
		List<Quote> list = dao.queryAllQuote(page);
		//通过dao层获得总记录数
		int count = dao.quoteCount();
		//将数据和记录数放在同一个集合中，记录数的下标必须是total，数据的下标rows
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", count);
		map.put("rows", list);
		//将数据集合转换为json字符串
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
	
	//根据id查报价
	public String queryQuote(String id){
		String data = "";
		List<Quote> list = dao.queryQuote(id);
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
	
	//添加报价
	public String addQuote(Quote q){
		Message msg = new Message();
		//调用dao层的查询方法，判断记录是否存在
		List<Quote> list = dao.queryQuoteIsSame(q.getQuoteOrder());
		//记录已经存在
		if(list.size()>0){
			msg.setSuccess(false);
			msg.setErrorMsg("报价单号已经存在，不能添加");
		}
		//记录不存在，调用dao层的添加方法，将数据写入数据库
		else{
			int temp = dao.addQuote(q);
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
	
	//修改报价
	public String editQuote(Quote q){
		Message msg = new Message();
		int temp = dao.editQuote(q);
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
	public String deleteQuote(String id){
		Message msg = new Message();
		int temp = dao.deleteQuote(id);
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
