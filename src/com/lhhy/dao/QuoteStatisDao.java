package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.QuoteStatis;
import com.lhhy.util.DBConn;

public class QuoteStatisDao {
	
	private DBConn conn;
	
	//查询所有报价统计
	public List<QuoteStatis> queryAllQuoteStatis(Page page){
		List<QuoteStatis> list = new ArrayList<QuoteStatis>();
		String sql="select * from tb_quote_statis limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				QuoteStatis q = new QuoteStatis(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
	//查询总的报价统计数目
		public int quoteStatisCount(){
			int count = 0;
			String sql = "select count(*) from tb_quote_statis";
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
		
	
	//添加前查询数据库中是否存在同时期的报价统计
	public List<QuoteStatis> queryQuoteStatisIsSame(String name){
		List<QuoteStatis> list = new ArrayList<QuoteStatis>();
		String sql = "select * from tb_quote_statis where client_name=?";   
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while(rs.next()){
				QuoteStatis q = new QuoteStatis(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
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
	//添加报价统计
	public int addQuoteStatis(QuoteStatis q){
		int temp=-1;
		String sql = "insert into tb_quote_statis(client_name,client_type,quote_statis_date) values(?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql,q.getClientName(),q.getClientType(),q.getQuoteStatisDate());
		conn.closeAll();
		return temp;
	}
	//修改报价统计
	public int editQuoteStatis(QuoteStatis q){
		int temp = -1;
		String sql = "update tb_quote_statis set client_name=?,client_type=?,quote_statis_date=?  where quote_statis_id=?";
		conn = new DBConn();
		temp = conn.update(sql,q.getClientName(),q.getClientType(),q.getQuoteStatisDate(),q.getQuoteStatisId());
		conn.closeAll();
		return temp;
	}
	
	//删除报价统计
	public int deleteQuoteStatis(String id){
		int temp = -1;
		String sql = "delete from tb_quote_statis where quote_statis_id="+id;
		conn =new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}

