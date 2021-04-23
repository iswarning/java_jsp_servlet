package dao;

import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import context.DBContext;
import entity.Product;
import entity.User;
import orther.RandomString;

public class UserRepo {

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	public User login(String email, String password) {
		
		String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		
		try {
			
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				return new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(8));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<User> getAllUser(){
		
		List<User> listU = new ArrayList<>();
		String query = "SELECT * FROM users LIMIT 20";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				listU.add(new User(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getInt(10)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listU;
	}
	
	public User register(String email, String password) {
		
		String query = "INSERT INTO users(name, email, password, role) VALUES( ?, ?, ?, 2)";
		String stringRan = new RandomString().rand(5);
		
		try {
			
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, stringRan);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
