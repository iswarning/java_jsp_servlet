package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import context.DBContext;
import entity.Category;
import entity.Product;

public class ProductRepository {

	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<Product> getAllProduct(int limit, int offset) {
		
		List<Product> listP = new ArrayList<>();
		String query = "SELECT * FROM sanpham LIMIT ? OFFSET ?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, limit);
			ps.setInt(2 ,offset);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listP;
	}
	
	public Product getOneP(int id){
		Product pro = new Product();
		
		String query = "SELECT * FROM sanpham WHERE id=? ";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pro.setId(rs.getInt(1));
				pro.setMaLoai(rs.getInt(2));
				pro.setTenSanPham(rs.getString(3));
				pro.setMoTa(rs.getString(4));
				pro.setGia(rs.getFloat(5));
				pro.setHinhAnh((rs.getString(6)));
				pro.setHinhCT1((rs.getString(7)));
				pro.setHinhCT2((rs.getString(8)));
				pro.setHangSanXuat(rs.getString(9));
				pro.setInstock(rs.getInt(10));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return pro;
	}
	
	
	public List<Product> searchProduct(String key){
		
		
		List<Product> listP = new ArrayList<>();
		String query = "SELECT * FROM sanpham WHERE TenSanPham LIKE ?";
		try {
			
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + key + "%");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listP;
	}
	
}
