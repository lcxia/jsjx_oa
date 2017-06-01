package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.Conference;
import com.lhhy.util.DBConn;

public class ConferenceDao {
	
	private DBConn conn;
	
	//查询所有会议报告
	public List<Conference> queryAllConference(Page page){
		List<Conference> list = new ArrayList<Conference>();
		String sql="select * from tb_conference limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				Conference q = new Conference(rs.getInt(1),rs.getString(2),rs.getString(3));
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
	//查询总的会议报告数目
		public int conferenceCount(){
			int count = 0;
			String sql = "select count(*) from tb_conference";
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
		
	
	//添加前查询数据库中是否存在同期号的会议报告
	public List<Conference> queryConferenceIsSame(String name){
		List<Conference> list = new ArrayList<Conference>();
		String sql = "select * from tb_conference where conference_id=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while(rs.next()){
				Conference q = new Conference(rs.getInt(1),rs.getString(2),rs.getString(3));
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
	//添加会议报告
	public int addConference(Conference q){
		int temp=-1;
		String sql = "insert into tb_conference(conference_code,conference_done_date) values(?,?)";
		conn = new DBConn();
		temp = conn.update(sql, q.getConferenceCode(),q.getConferenceDoneDate());
		conn.closeAll();
		return temp;
	}
	//修改会议报告
	public int editConference(Conference q){
		int temp = -1;
		String sql = "update tb_conference set conference_code=?,conference_done_date=?  where conference_id=?";
		conn = new DBConn();
		temp = conn.update(sql,q.getConferenceCode(),q.getConferenceDoneDate(),q.getConferenceId());
		conn.closeAll();
		return temp;
	}
	
	//删除会议报告
	public int deleteConference(String id){
		int temp = -1;
		String sql = "delete from tb_conference where conference_id="+id;
		conn =new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}


