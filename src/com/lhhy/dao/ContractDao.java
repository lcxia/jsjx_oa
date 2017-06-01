package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Contract;
import com.lhhy.bean.Page;
import com.lhhy.util.DBConn;

public class ContractDao {
	
private DBConn conn;
	
//查询所有合同
	public List<Contract> queryAllContract(Page page){
		//建立一个容器，用于存放查询结果
		List<Contract> list = new ArrayList<Contract>();
		//准备查询到的sql语句
		String sql="select * from tb_contract limit ?,?";
		//实例化conn
		conn = new DBConn();
		//执行sql语句，并接受结果
		ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
		try {
			while(rs.next()){
				//提取每一列的数据
				Contract c = new Contract(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				list.add(c);
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
	//查询总的合同数目
	public int contractCount(){
		int count = 0;
		String sql = "select count(*) from tb_contract";
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
	   public List<Contract> queryContract(String id){
		 //step1:建立一个容器，用于存放查询结果
		 		List<Contract> list=new ArrayList<Contract>();
		 		//step2:建立一个查询的sql语句
		 		String sql="select * from tb_contract where contract_id=?";
		 		//step3:对conn进行实例化
		 		conn=new DBConn();
		 		//step4:执行sql语句，并接受结果
		 		ResultSet rs=conn.query(sql,id);
		 		try {
		 			while(rs.next()){
		 				//提取每一列的数据
		 			 	list.add(new Contract(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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
	
	//添加前查询数据库中是否存在同名的合同
	public List<Contract> queryContractIsSame(String name){
		//建立一个容器，用于存放查询结果
		List<Contract> list = new ArrayList<Contract>();
		//准备查询语句
		String sql = "select * from tb_contract where contract_code=?";
		//实例化conn
		conn = new DBConn();
		//执行sql语句，并接受结果
		ResultSet rs = conn.query(sql, name);
		try {
			while(rs.next()){
				//提取每一列的数据
				Contract c = new Contract(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
				list.add(c);
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
	//添加合同
	public int addContract(Contract c){
		int temp=-1;
		String sql = "insert into tb_contract(contract_code,contract_date,contract_industry,contract_device,contract_order,contract_comment) values(?,?,?,?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, c.getContractCode(),c.getContractDate(),c.getContractIndustry(),c.getContractDevice(),c.getContractOrder(),c.getContractComment());
		conn.closeAll();
		return temp;
	}
	//修改合同
	public int editContract(Contract c){
		int temp = -1;
		String sql = "update tb_contract set contract_code=?,contract_date=?,contract_industry=?,contract_device=?,contract_order=?,contract_comment=? where contract_id=?";
		conn = new DBConn();
		temp = conn.update(sql,c.getContractCode(),c.getContractDate(),c.getContractIndustry(),c.getContractDevice(),c.getContractOrder(),c.getContractComment(),c.getContractId());
		conn.closeAll();
		return temp;
	}
	
	//删除合同
		public int deleteContract(String id){
			int temp = -1;
			String sql = "delete from tb_contract where contract_id="+id;
			conn =new DBConn();
			temp = conn.update(sql);
			conn.closeAll();
			return temp;
		}

}
