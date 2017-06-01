package com.lhhy.biz;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lhhy.bean.Cost;
import com.lhhy.bean.Message;
import com.lhhy.bean.Page;
import com.lhhy.dao.CostDao;

public class CostBiz {
	private CostDao dao;
	private ObjectMapper mapper;
	
	public CostBiz(){
		dao = new CostDao();
		mapper = new ObjectMapper();
	}
	//查询所有成本，抛出json字符串
			public String queryAllCost(Page page){
				String data = "";
				List<Cost> list = dao.queryAllCost(page);
				int count = dao.costCount();
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
	
	//添加成本
	public String addCost(Cost c){
		Message msg = new Message();
		List<Cost> list = dao.queryCostIsSame(c.getCostDate());
		if(list.size()>0){
			msg.setSuccess(false);
			msg.setErrorMsg("成本日期已经存在，不能添加");
		}
		else{
			int temp = dao.addCost(c);
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
	
	//修改成本
	public String editCost(Cost c){
		Message msg = new Message();
		int temp = dao.editCost(c);
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
   

	//删除成本
		public String deleteCost(String id){
			Message msg = new Message();
			int temp = dao.deleteCost(id);
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
