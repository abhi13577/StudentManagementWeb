package com.studentapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.studentapp.conn.Connect;
import com.studentapp.dto.Student;

public class StudentDaoImp implements StudentDao {
    Connection con = null;
    public StudentDaoImp() {
    	this.con = Connect.getConn();
    }
	@Override
	public boolean insertStudent(Student s) {
		PreparedStatement ps = null;
		String query = "insert into student values (0,?,?,?,?,?,?,SYSDATE())";
		int res = 0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getSname());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(res>0)
			return true;
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		String query = "update student set sname=?,phone=?,email=?,branch=?,location=?,password=? where sid=?";
		PreparedStatement ps = null;
		int res = 0 ;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, s.getSname());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getSid());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteStudent(Student s) {
		String query = "delete from student where sid=? and sid!=1";
		PreparedStatement ps = null;
		int res = 0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, s.getSid());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res>0)
			return true;
		return false;
	}

	@Override
	public Student getStudent(String email, String password) {
		String query = "SELECT * FROM STUDENT WHERE EMAIL=? AND PASSWORD=?";
		PreparedStatement ps = null;
		Student s = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs =ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setPhone(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public Student getStudent(long phone,String password) {
		String query="SELECT * FROM STUDENT WHERE PHONE=? AND password=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s1 = null;
		try {
			ps = con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				s1=new Student();
				s1.setSid(rs.getInt("sid"));
				s1.setSname(rs.getString("sname"));
				s1.setPhone(rs.getLong("phone"));
				s1.setEmail(rs.getString("email"));
				s1.setBranch(rs.getString("branch"));
				s1.setLocation(rs.getString("location"));
				s1.setPassword(rs.getString("password"));
				s1.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s1;
	}

	@Override
	public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student> a = new ArrayList<>();
		String query = "SELECT * FROM STUDENT";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setPhone(rs.getLong("phone"));
				s.setEmail(rs.getString("email"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				a.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	@Override
	public Student getStudent(String email, long phone) {
		String query = "SELECT * FROM STUDENT WHERE EMAIL=? AND PHONE=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student s = null;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setLong(2, phone);
			rs = ps.executeQuery();
			while(rs.next()) {
				s = new Student();
				s.setSid(rs.getInt("sid"));
				s.setSname(rs.getString("sname"));
				s.setPhone(rs.getLong("phone"));
				s.setBranch(rs.getString("branch"));
				s.setEmail(rs.getString("email"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

}
