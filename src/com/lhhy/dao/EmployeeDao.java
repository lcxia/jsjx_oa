package com.lhhy.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Employee;
import com.lhhy.bean.Page;
import com.lhhy.util.DBConn;
public class EmployeeDao {
	private DBConn conn;
	//查询所有营业人员
		public List<Employee> queryAllEmployee(Page page){
			List<Employee> list = new ArrayList<Employee>();
			String sql="select * from tb_employee limit ?,?";
			conn = new DBConn();
			ResultSet rs = conn.query(sql,page.getStartIndex(),page.getRows());
			try {
				while(rs.next()){
					Employee q = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
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
		//查询总的营业人员数目
		public int employeeCount(){
			int count = 0;
			String sql = "select count(*) from tb_employee";
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
		//添加前查询数据库中是否存在同名的营业人员
		public List<Employee> queryEmployeeIsSame(String name){
			List<Employee> list = new ArrayList<Employee>();
			String sql = "select * from tb_employee where employee_name=?";
			conn = new DBConn();
			ResultSet rs = conn.query(sql, name);
			try {
				while(rs.next()){
					Employee q = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
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
		//添加营业人员
		public int addEmployee(Employee q){
			int temp=-1;
			String sql = "insert into tb_employee(employee_name) values(?)";
			conn = new DBConn();
			temp = conn.update(sql, q.getEmployeeName());
			conn.closeAll();
			return temp;
		}
		//修改营业人员
		public int editEmployee(Employee q){
			int temp = -1;
			String sql = "update tb_employee set employee_name=? where employee_id=?";
			conn = new DBConn();
			temp = conn.update(sql,q.getEmployeeName(),q.getEmployeeId());
			conn.closeAll();
			return temp;
		}
		//删除营业人员
		public int deleteEmployee(String id){
			int temp = -1;
			String sql = "delete from tb_employee where employee_id="+id;
			conn =new DBConn();
			temp = conn.update(sql);
			conn.closeAll();
			return temp;
		}
		
		//根据用户名和密码查询用户
		public List<Employee> queryEmployee(String name,String pass){
			List<Employee> list = new ArrayList<Employee>();
			String sql = "select * from tb_employee where employee_name=? and employee_pass=?";
			conn = new DBConn();
			ResultSet rs = conn.query(sql,name,pass);
			try {
				while(rs.next()){
					list.add(new Employee(rs.getInt(1),rs.getString(2),rs.getString(3)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				conn.closeAll();
			}
			return list;
		}
}
