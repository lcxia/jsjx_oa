package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Cost;
import com.lhhy.bean.Page;
import com.lhhy.util.DBConn;

public class CostDao {
	
	private DBConn conn;
	
	//查询所有成本
	public List<Cost> queryAllCost(Page page){
		List<Cost> list = new ArrayList<Cost>();
		String sql="select * from tb_cost limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				Cost c = new Cost(rs.getInt(1),rs.getString(2));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	//查询总的成本数目
			public int costCount(){
				int count = 0;
				String sql = "select count(*) from tb_cost";
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
	//添加前查询数据库中是否存在同名的成本
	public List<Cost> queryCostIsSame(String name){
		List<Cost> list = new ArrayList<Cost>();
		String sql = "select * from tb_cost where cost_date=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while(rs.next()){
				Cost c = new Cost(rs.getInt(1),rs.getString(2));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	//添加成本
	public int addCost(Cost c){
		int temp=-1;
		String sql = "insert into tb_cost(cost_date) values(?)";
		conn = new DBConn();
		temp = conn.update(sql,c.getCostDate());
		conn.closeAll();
		return temp;
	}
	//修改成本
	public int editCost(Cost c){
		int temp = -1;
		String sql = "update tb_cost set cost_date=? where cost_id=?";
		conn = new DBConn();
		temp = conn.update(sql,c.getCostDate(),c.getCostId());
		conn.closeAll();
		return temp;
	}
	
//删除成本
	public int deleteCost(String id){
		int temp = -1;
		String sql = "delete from tb_cost where cost_id="+id;
		conn =new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}


}
