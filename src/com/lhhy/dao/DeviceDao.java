package com.lhhy.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lhhy.bean.Device;
import com.lhhy.bean.Page;
import com.lhhy.util.DBConn;

public class DeviceDao {
	private DBConn conn;

	// 查询所有设备
	public List<Device> queryAllDevice(Page page) {
		//建立一个容器，用于存放查询结果
		List<Device> list = new ArrayList<Device>();
		//准备查询到的sql语句
		String sql = "select * from tb_device limit ?,?";
		//实例化conn
		conn = new DBConn();
		//执行sql语句，并接受结果
		ResultSet rs = conn.query(sql, page.getStartIndex(), page.getRows());
		try {
			while (rs.next()) {
				//提取每一列的数据
				Device d = new Device(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9),rs.getDouble(10));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		//抛出结果
		return list;
	}

	// 查询总的设备数目
	public int deviceCount() {
		int count = 0;
		String sql = "select count(*) from tb_device";
		conn = new DBConn();
		ResultSet rs = conn.query(sql);
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		return count;
	}
	
	//根据账号进行精确查询
	   public List<Device> queryDevice(String id){
		 //step1:建立一个容器，用于存放查询结果
		 		List<Device> list=new ArrayList<Device>();
		 		//step2:建立一个查询的sql语句
		 		String sql="select * from tb_device where device_id=?";
		 		//step3:对conn进行实例化
		 		conn=new DBConn();
		 		//step4:执行sql语句，并接受结果
		 		ResultSet rs=conn.query(sql,id);
		 		try {
		 			while(rs.next()){
		 				//提取每一列的数据
		 			 	list.add(new Device(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9),rs.getDouble(10)));
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

	// 添加前查询数据库中是否存在同型号的设备
	public List<Device> queryDeviceIsSame(String name) {
		//建立一个容器，用于存放查询结果
		List<Device> list = new ArrayList<Device>();
		//准备查询语句
		String sql = "select * from tb_device where device_code=?";
		//实例化conn
		conn = new DBConn();
		//执行sql语句，并接受结果
		ResultSet rs = conn.query(sql, name);
		try {
			while (rs.next()) {
				//提取每一列的数据
				Device d = new Device(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getDouble(7),rs.getDouble(8),rs.getDouble(9),rs.getDouble(10));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.closeAll();
		}
		//抛出结果
		return list;
	}

	// 添加设备
	public int addDevice(Device d) {
		int temp = -1;
		String sql = "insert into tb_device(device_code,device_main,device_pump,device_capcity) values(?,?,?,?)";
		conn = new DBConn();
		temp = conn.update(sql, d.getDeviceCode(),d.getDeviceMain(),d.getDevicePump(),d.getDeviceCapacity());
		conn.closeAll();
		return temp;
	}

	// 修改设备
	public int editDevice(Device d) {
		int temp = -1;
		String sql = "update tb_device set device_code=?,device_main=?,device_pump=?,device_capcity=? where device_id=?";
		conn = new DBConn();
		temp = conn.update(sql, d.getDeviceCode(),d.getDeviceMain(),d.getDevicePump() ,d.getDeviceCapacity(),d.getDeviceId());
		conn.closeAll();
		return temp;
	}
	
	//删除设备
	public int deleteDevice(String id){
		int temp = -1;
		String sql = "delete from tb_device where device_id="+id;
		conn =new DBConn();
		temp = conn.update(sql);
		conn.closeAll();
		return temp;
	}

}
