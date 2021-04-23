package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Category;
import entity.Product;

public class CategoryRepo {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Category> getAllCate() {
		
		List<Category> listC = new ArrayList<>();
		String query = "SELECT * FROM loaisanpham LIMIT 4";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				listC.add(new Category(rs.getInt(1),
						rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listC;
	}
	
	public List<Product> getProByCate(int id){
		List<Product> listP = new ArrayList<>();
		
		String query = "SELECT * FROM sanpham WHERE MaLoai=? LIMIT 4";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				listP.add(new Product(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getString(4),
						rs.getFloat(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getInt(10)));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return listP;
	}
}
