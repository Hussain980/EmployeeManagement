package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.DBConnect;
import com.pojo.Emp;

public class EmpDao 
{
Connection con = DBConnect.getConnect();
	
	public boolean addEmp(Emp e)
	{
		String sql = "insert into user09(name,password,email,country) values(?,?,?,?)";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return false;
		
	}
	
	public boolean updateEmp(Emp e)
	{
		String sql = "update user09 set name=?,password=?,email=?,country=? where id=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());
			int i= ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
		return false;
		
	}
	
	
	public boolean deleteEmp(int id)
	{
		String sql ="delete from user09 where id=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		}
		catch(Exception e3)
		{
			e3.printStackTrace();
		}
		return false;
		
	}
	
	public Emp getEmpById(int id)
	{
		Emp e = new Emp();
		String sql = "select * from user09 where id=?";
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			
		
		}
		catch(Exception e4)
		{
			e4.printStackTrace();
		}
		
		return e;
		
		
	}
	
	public List<Emp> getEmpList()
	{
		String sql = "select * from user09";
		ArrayList<Emp> el = new ArrayList<Emp>();
		try
		{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				el.add(e);
			}
			return el;
		}
		catch(Exception e5)
		{
			e5.printStackTrace();
		}
		return null;
		
	}

}
