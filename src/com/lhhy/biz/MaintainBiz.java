package com.lhhy.biz;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.lhhy.bean.Maintain;
import com.lhhy.bean.Message;
import com.lhhy.bean.Page;
import com.lhhy.dao.MaintainDao;

public class MaintainBiz {
	private MaintainDao dao;
	//声明一个用于转换数据格式的类json
	private ObjectMapper mapper;
	//在构造方法中对dao进行实例化
	public MaintainBiz(){
		dao = new MaintainDao();
		mapper = new ObjectMapper();
}
//分页查询所有维修（售后），抛出json字符串
			public String queryAllMaintain(Page page){
				String data = "";//存放转换后的数据的字符串
				//通过dao层获得数据集合
				List<Maintain> list = dao.queryAllMaintain(page);
				int count = dao.maintainCount();
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
//根据id查维修
			public String queryMaintain(String id){
				String data = "";
				List<Maintain> list = dao.queryMaintain(id);
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
//添加维修（售后）
			public String addMaintain(Maintain q){
				//设置message的对象
				Message msg = new Message();
				//调用dao层中，查询的的方法，来检查账号是否已经存在
				List<Maintain> list = dao.queryMaintainIsSame(q.getMaintainEvection());
				if(list.size()>0){
					//账号已经存在
					msg.setSuccess(false);
					msg.setErrorMsg("维修出差号已经存在，不能添加");
				}
				else{
					//如果不存在，调用dao中保存方法，将数据写入数据库
					int temp = dao.addMaintain(q);
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
//修改维修（售后）
			public String editMaintain(Maintain q){
				//设置message的对象
				Message msg = new Message();
				//调用dao中修改方法，将数据写入数据库
				int temp = dao.editMaintain(q);
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
		  
//删除维修（售后）
			public String deleteMaintain(String id){
				//消息对象
				Message msg = new Message();
				//调用dao，获得结果
				int temp = dao.deleteMaintain(id);
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