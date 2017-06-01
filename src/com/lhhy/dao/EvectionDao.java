package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Evection;
import com.lhhy.bean.Page;
import com.lhhy.util.DBConn;

public class EvectionDao {
	
	private DBConn conn;
	
	//查询所有出差日程
	public List<Evection> queryAllEvection(Page page){
		List<Evection> list = new ArrayList<Evection>();
		String sql="select * from tb_evection limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				Evection q = new Evection(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(q);
			}
		} catch (SQLException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	//查询总的出差日程
	public int evectionCount(){
		int count = 0;
		String sql = "select count(*) from tb_evection";
		conn = new DBConn();
		ResultSet rs = conn.query(sql);
		try {
			while(rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return count;
	}
	
	//添加前查询数据库中是否存在同名的出差日程
	public List<Evection> queryEvectionIsSame(Evection e){
		List<Evection> list = new ArrayList<Evection>();
		String sql = "select * from tb_evection where evection_name=? and evection_place=? and evection_out=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, e.getEvectionName(),e.getEvectionPlace(),e.getEvectionOut());
		try {
			while(rs.next()){
				Evection q= new Evection(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
				list.add(q);
			}
		} catch (SQLException q) {
			// TODO Auto-generated catch block
			q.printStackTrace();
		}finally{
			conn.closeAll();
		}
		return list;
	}
	//添加出差日程
	public int addEvection(Evection e){
		int temp=-1;
		String sql = "insert into tb_evection(evection_name,evection_place,evection_out,evection_back,evection_comment) values(?,?,?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql,e.getEvectionName(),e.getEvectionPlace(),e.getEvectionOut(),e.getEvectionBack(),e.getEvectionComment());
		conn.closeAll();
		return temp;
	}
	//修改出差日程
	public int editEvection(Evection e){
		int temp = -1;
		String sql = "update tb_evection set evection_name=?,evection_place=?,evection_out=?,evection_back=?,evection_comment=? where evection_id=?";
		conn = new DBConn();
		temp = conn.update(sql,e.getEvectionName(),e.getEvectionPlace(),e.getEvectionOut(),e.getEvectionBack(),e.getEvectionComment(),e.getEvectionId());
		conn.closeAll();
		return temp;
	}

   //删除出差日程
		public int deleteEvection(String id){
			int temp = -1;
			String sql = "delete from tb_evection where evection_id='"+id+"'";
			conn =new DBConn();
			temp = conn.update(sql);
			conn.closeAll();
			return temp;
		}
}
