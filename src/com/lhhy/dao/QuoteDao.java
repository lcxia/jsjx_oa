package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.Quote;
import com.lhhy.util.DBConn;

public class QuoteDao {
	
	private DBConn conn;
	
	//查询所有报价
	public List<Quote> queryAllQuote(Page page){
		//建立一个容器，用于存放查询结果
		List<Quote> list = new ArrayList<Quote>();
		//准备查询到的sql语句
		String sql="select * from tb_quote limit ?,?";
		//实例化conn
		conn = new DBConn();
		//执行sql语句，并接受结果
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				//提取每一列的数据
				Quote q = new Quote(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getDouble(9));
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
		
	//查询总的报价数目
		public int quoteCount(){
			int count = 0;
			String sql = "select count(*) from tb_quote";
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
		
		//根据账号进行精确查询
		   public List<Quote> queryQuote(String id){
			 //step1:建立一个容器，用于存放查询结果
			 		List<Quote> list=new ArrayList<Quote>();
			 		//step2:建立一个查询的sql语句
			 		String sql="select * from tb_quote where quote_id=?";
			 		//step3:对conn进行实例化
			 		conn=new DBConn();
			 		//step4:执行sql语句，并接受结果
			 		ResultSet rs=conn.query(sql,id);
			 		try {
			 			while(rs.next()){
			 				//提取每一列的数据
			 			 	list.add(new Quote(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDouble(8), rs.getDouble(9)));
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
	
	//添加前查询数据库中是否存在同名的报价
	public List<Quote> queryQuoteIsSame(String name){
		//建立一个容器，用于存放查询结果
		List<Quote> list = new ArrayList<Quote>();
		//准备查询语句
		String sql = "select * from tb_quote where quote_order=?";
		//实例化conn
		conn = new DBConn();
		//执行sql语句，并接受结果
		ResultSet rs = conn.query(sql, name);
		try {
			while(rs.next()){
				//提取每一列的数据
				Quote q = new Quote(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDouble(8),rs.getDouble(9));
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
	//添加报价
	public int addQuote(Quote q){
		int temp=-1;
		String sql = "insert into tb_quote(quote_date,quote_order,quote_industry,quote_device,quote_take,quote_content,quote_noTaxPrice,quote_taxPrice) values(?,?,?,?,?,?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, q.getQuoteDate(),q.getQuoteOrder(),q.getQuoteIndustry(),q.getQuoteDevice(),q.getQuoteTake(),q.getQuoteContent(),q.getQuoteNoTaxPrice(),q.getQuoteTaxPrice());
		conn.closeAll();
		return temp;
	}
	//修改报价
	public int editQuote(Quote q){
		int temp = -1;
		String sql = "update tb_quote set quote_date=?,quote_order=?,quote_industry=?,quote_device=?,quote_take=?,quote_content=?,quote_noTaxPrice=?,quote_taxPrice=? where quote_id=?";
		conn = new DBConn();
		temp = conn.update(sql,q.getQuoteDate(),q.getQuoteOrder(),q.getQuoteIndustry(),q.getQuoteDevice(),q.getQuoteTake(),q.getQuoteContent(),q.getQuoteNoTaxPrice(),q.getQuoteTaxPrice(),q.getQuoteId());
		conn.closeAll();
		return temp;
	}
	
	//删除报价
	public int deleteQuote(String id){
		int temp = -1;
		String sql = "delete from tb_quote where quote_id="+id;
		conn =new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}
