package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.ServiceComplain;
import com.lhhy.util.DBConn;

public class ServiceComplainDao {
	
		private DBConn conn;
//查询所有服务/投诉
				public List<ServiceComplain> queryAllServiceComplain(Page page){
					//建立一个容器，用于存放查询结果
					List<ServiceComplain> list = new ArrayList<ServiceComplain>();
					//建立一个容器，用于存放查询结果
					String sql="select * from tb_serviceComplain limit ?,?";
					//对conn进行实例化
					conn = new DBConn();
					//执行sql语句，并接受结果
					ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
					try {
						while(rs.next()){
							//提取每一列的数据
							ServiceComplain q = new ServiceComplain(rs.getInt(1),rs.getString(2));
							list.add(q);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						conn.closeAll();
					}
					//抛出结果
					return list;
				}
//添加前查询数据库中是否存在同名的服务/投诉
			public List<ServiceComplain> queryServiceComplainIsSame(String name){
				//建立一个容器，用于存放查询结果
				List<ServiceComplain> list = new ArrayList<ServiceComplain>();
				//建立一个查询的sql语句
				String sql = "select * from tb_serviceComplain where serviceCom_code=?";
				//对conn进行实例化
				conn = new DBConn();
				//执行sql语句，并接受结果
				ResultSet rs = conn.query(sql,name);
				try {
					while(rs.next()){
						//提取每一列的数据
						ServiceComplain q = new ServiceComplain(rs.getInt(1),rs.getString(2));
						list.add(q);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					conn.closeAll();
				}
				//抛出结果
				return list;
			}	
//根据账号进行精确查询
			   public List<ServiceComplain> queryServiceComplain(String id){
				 //step1:建立一个容器，用于存放查询结果
				 		List<ServiceComplain> list=new ArrayList<ServiceComplain>();
				 		//step2:建立一个查询的sql语句
				 		String sql="select * from tb_serviceComplain where serviceCom_id=?";
				 		//step3:对conn进行实例化
				 		conn=new DBConn();
				 		//step4:执行sql语句，并接受结果
				 		ResultSet rs=conn.query(sql,id);
				 		try {
				 			while(rs.next()){
				 				//提取每一列的数据
				 			 	list.add(new ServiceComplain(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
				 			}
				 		} catch (SQLException e) {
				 			// TODO Auto-generated catch block
				 			e.printStackTrace();
				 		}finally{
				 			conn.closeAll();
				 	    }
				 		
				 		//step5：抛出结果
				 		return list;
			   }
//查询总的服务/投诉数目
			public int serviceComplainCount(){
				//准备容器
				int count = 0;
				//准备sql
				String sql = "select count(*) from tb_serviceComplain";
				//实例化conn，并执行sql语句，提取结果
				conn = new DBConn();
				//实例化
				ResultSet rs = conn.query(sql);
				//执行sql语句
				try {
					while(rs.next()){
						//提取结果
						count = rs.getInt(1);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					conn.closeAll();//关闭资源
				}
				//抛出结果
				return count;
			}
//根据服务/投诉号进行精确查询
			public List<ServiceComplain> search(String code){
				 //step1:建立一个容器，用于存放查询结果
				 		List<ServiceComplain> list=new ArrayList<ServiceComplain>();
				 		//step2:建立一个查询的sql语句
				 		String sql="select * from serviceComplain where code=?";
				 		//step3:对conn进行实例化
				 		conn=new DBConn();
				 		//step4:执行sql语句，并接受结果
				 		ResultSet rs=conn.query(sql,code);
				 		try {
				 			while(rs.next()){
				 				//提取每一列的数据
				 				/* ServiceComplain service=new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getIn(8));
				 			   list.add(service);*/
				 				list.add(new ServiceComplain(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getInt(8)));
				 			}
				 		} catch (SQLException e) {
				 			// TODO Auto-generated catch block
				 			e.printStackTrace();
				 		}finally{
				 			conn.closeAll();
				 	    }
				 		
				 		//step5：抛出结果
				 		return list;
			   }
//添加服务/投诉
					public int addServiceComplain(ServiceComplain q){
						//准备一个存储结果的容器
						int temp=-1;
						//准备sql语句
						String sql = "insert into tb_serviceComplain(serviceCom_code) values(?)";
						//实例化conn对象
						conn = new DBConn();
						//执行sql语句并接受结果
						temp = conn.update(sql, q.getServiceComplainCode());
						//关闭连接
						conn.closeAll();
						//抛出结果
						return temp;
					}
//修改服务/投诉
					public int editServiceComplain(ServiceComplain q){
						//准备一个存储结果的容器
						int temp = -1;
						//准备sql语句
						String sql = "update tb_serviceComplain set serviceCom_code=? where serviceCom_id=?";
						//实例化conn对象
						conn = new DBConn();
						//执行sql语句并接受结果
						temp = conn.update(sql,q.getServiceComplainCode(),q.getServiceComplainId());
						//关闭连接
						conn.closeAll();
						//抛出结果
						return temp;
					}
//删除营业人员
					public int deleteServiceComplain(String id){
						//准备一个存储结果的容器
						int temp = -1;
						//准备sql语句
						String sql = "delete from tb_serviceComplain where serviceCom_id="+id;
						//实例化conn对象
						conn =new DBConn();
						//执行sql语句并接受结果
						temp = conn.update(sql);
						//关闭连接
						conn.closeAll();
						//抛出结果
						return temp;
					}
	}


