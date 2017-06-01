package com.lhhy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public final class DBConn {
	private String url;
	private String dbname;
	private String user;
	private String password;
	private String driver;
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement prep;	
	//��������
	public DBConn(){
		//��ʼ������
		init();
	  //��������
		try {
			Class.forName(driver);//��������   ����θ�driver��ֵ			
			//��������
			conn=DriverManager.getConnection(url+dbname+"?useUnicode=true&characterEncoding=utf-8", user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//����������Ϣ
	private void init(){
		this.driver=Config.DRIVER;
		this.url=Config.URL;
		this.dbname=Config.DBNAME;
		this.user=Config.USER;
		this.password=Config.PASSWORD;
	}
	
	
	//�ṩ��ɾ�ĵķ���
	public int update(final String sql){
		//ʵ����stat����
		int temp=-1;
		try {
			stat=conn.createStatement();
			//ִ��sql���
			temp=stat.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;		
	}
	public int update(final String sql,Object ... objects ){
		//ʵ����stat����
		int temp=-1;
		try {
			prep=conn.prepareStatement(sql);
			//���ʺŸ�ֵ
			for(int i=0;i<objects.length;i++){
				prep.setObject(i+1, objects[i]);
			}
			//ִ��sql���
			temp=prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;		
	}
	
	
	//�ṩ��ѯ�ķ���
	public ResultSet query(final String sql){
		//ʵ����stat����
	     ResultSet rs=null;
		try {
			stat=conn.createStatement();
			//ִ��sql���
			rs=stat.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
	public ResultSet query(final String sql,Object ... objects ){
		//ʵ����stat����
		ResultSet rs=null;
		try {
			prep=conn.prepareStatement(sql);
			//���ʺŸ�ֵ
			for(int i=0;i<objects.length;i++){
				prep.setObject(i+1, objects[i]);
			}
			//ִ��sql���
			rs=prep.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;		
	}
	
	//�ر���Դ
	public void closeAll(){
		try {
			if(stat!=null && !stat.isClosed()) stat.close();
			if(prep!=null && !prep.isClosed()) prep.close();
			if(conn!=null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
