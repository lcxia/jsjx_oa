package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Page;
import com.lhhy.bean.ContractStatis;
import com.lhhy.util.DBConn;

public class ContractStatisDao {
	
	private DBConn conn;
	
	//查询所有合同统计
	public List<ContractStatis> queryAllContractStatis(Page page){
		List<ContractStatis> list = new ArrayList<ContractStatis>();
		String sql="select * from tb_contract_statis limit ?,?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				ContractStatis q = new ContractStatis(rs.getInt(1),rs.getString(4));
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
	//查询总的合同统计数目
		public int contractStatisCount(){
			int count = 0;
			String sql = "select count(*) from tb_contract_statis";
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
		
	
	//添加前查询数据库中是否存在同时期的统计
	public List<ContractStatis> queryContractStatisIsSame(String name){
		List<ContractStatis> list = new ArrayList<ContractStatis>();
		String sql = "select * from tb_contract_statis where contract_statis_date=?";
		conn = new DBConn();
		ResultSet rs = conn.query(sql, name);
		try {
			while(rs.next()){
				ContractStatis q = new ContractStatis(rs.getInt(1),rs.getString(4));
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
	//添加合同统计
	public int addContractStatis(ContractStatis q){
		int temp=-1;
		String sql = "insert into tb_contract_statis(contract_statis_date) values(?)";
		conn = new DBConn();
		temp = conn.update(sql, q.getContractStatisDate());
		conn.closeAll();
		return temp;
	}
	//修改合同统计
	public int editContractStatis(ContractStatis q){
		int temp = -1;
		String sql = "update tb_contract_statis set contract_statis_date=?  where contract_statis_id=?";
		conn = new DBConn();
		temp = conn.update(sql,q.getContractStatisDate(),q.getContractStatisId());
		conn.closeAll();
		return temp;
	}
	
	//删除合同统计
	public int deleteContractStatis(String id){
		int temp = -1;
		String sql = "delete from tb_contract_statis where  contract_statis_id="+id;
		conn =new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}

