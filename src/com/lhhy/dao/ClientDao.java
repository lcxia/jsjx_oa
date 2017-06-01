package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.Client;
import com.lhhy.util.DBConn;

public class ClientDao {
	
	private DBConn conn;
	
	//查询所有客户
	public List<Client> queryAllClient(Page page){
		List<Client> list = new ArrayList<Client>();
		String sql="select * from tb_client limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				Client q = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	//查询总的客户数目
		public int clientCount(){
			int count = 0;
			String sql = "select count(*) from tb_client";
			conn = new DBConn();
			ResultSet rs = conn.query(sql);
			try {
				while(rs.next()){
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.closeAll();
			}
			return count;
		}
		
	
	//添加前查询数据库中是否存在同名的报价
	public List<Client> queryClientIsSame(String name){
		List<Client> list = new ArrayList<Client>();
		String sql = "select * from tb_client where client_id=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while(rs.next()){
				Client q = new Client(rs.getInt(1),rs.getString(2),rs.getString(3));
				list.add(q);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	//添加客户
	public int addClient(Client q){
		int temp=-1;
		String sql = "insert into tb_client(client_name,client_type) values(?,?)";
		conn = new DBConn();
		temp = conn.update(sql, q.getClientName(),q.getClientType());
		conn.closeAll();
		return temp;
	}
	//修改客户
	public int editClient(Client q){
		int temp = -1;
		String sql = "update tb_client set client_name=?,client_type=?  where client_id=?";
		conn = new DBConn();
		temp = conn.update(sql,q.getClientName(),q.getClientType(),q.getClientId());
		conn.closeAll();
		return temp;
	}
	
	//删除客户
	public int deleteClient(String id){
		int temp = -1;
		String sql = "delete from tb_client where client_id="+id;
		conn =new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}

