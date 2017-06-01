package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Maintain;
import com.lhhy.bean.Page;
import com.lhhy.util.DBConn;

public class MaintainDao {
	private DBConn conn;
//查询所有维修（售后）
			public List<Maintain> queryAllMaintain(Page page){
				//建立一个容器，用于存放查询结果
				List<Maintain> list = new ArrayList<Maintain>();
				//建立一个查询的sql语句
				String sql="select * from tb_maintain limit ?,?";
				//对conn进行实例化
				conn = new DBConn();
				//执行sql语句，并接受结果
				ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
				try {
					while(rs.next()){
						//提取每一列的数据
						Maintain q = new Maintain(rs.getInt(1),rs.getString(3));
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
//查询总的维修（售后）数目
			public int maintainCount(){
				//准备容器
				int count = 0;
				//准备sql
				String sql = "select count(*) from tb_maintain";
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
//添加前查询数据库中是否存在同名的维修（售后）
			public List<Maintain> queryMaintainIsSame(String name){
				//建立一个容器，用于存放查询结果
				List<Maintain> list = new ArrayList<Maintain>();
				//建立一个查询的sql语句
				String sql = "select * from tb_maintain where maintain_evection=?";
				//对conn进行实例化
				conn = new DBConn();
				//执行sql语句，并接受结果
				ResultSet rs = conn.query(sql, name);
				try {
					while(rs.next()){
						//提取每一列的数据
						Maintain q = new Maintain(rs.getInt(1),rs.getString(3));
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
			   public List<Maintain> queryMaintain(String id){
				 //step1:建立一个容器，用于存放查询结果
				 		List<Maintain> list=new ArrayList<Maintain>();
				 		//step2:建立一个查询的sql语句
				 		String sql="select * from tb_maintain where maintain_id=?";
				 		//step3:对conn进行实例化
				 		conn=new DBConn();
				 		//step4:执行sql语句，并接受结果
				 		ResultSet rs=conn.query(sql,id);
				 		try {
				 			while(rs.next()){
				 				//提取每一列的数据
				 			 	list.add(new Maintain(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8)));
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
//添加维修（售后）
			public int addMaintain(Maintain q){
				//准备一个存储结果的容器
				int temp=-1;
				//准备sql语句
				String sql = "insert into tb_maintain(maintain_evection) values(?)";
				//实例化conn对象
				conn = new DBConn();
				//执行sql语句并接受结果
				temp = conn.update(sql, q.getMaintainEvection());
				//关闭连接
				conn.closeAll();
				//抛出结果
				return temp;
			}
//修改维修（售后）
			public int editMaintain(Maintain q){
				//准备一个存储结果的容器
				int temp = -1;
				//准备sql语句
				String sql = "update tb_maintain set maintain_evection=? where maintain_id=?";
				//实例化conn对象
				conn = new DBConn();
				//执行sql语句并接受结果
				temp = conn.update(sql,q.getMaintainEvection(),q.getMaintainId());
				//关闭连接
				conn.closeAll();
				//抛出结果
				return temp;
			}
//删除维修（售后）
			public int deleteMaintain(String id){
				//准备一个存储结果的容器
				int temp = -1;
				//准备sql语句
				String sql = "delete from tb_maintain where maintain_id="+id;
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
