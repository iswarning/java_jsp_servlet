package entity;

public class Product {

	private int id;
	private int MaLoai;
	private String TenSanPham;
	private String MoTa;
	private float Gia;
	private String HinhAnh;
	private String HinhCT1;
	private String HinhCT2;
	private String HangSanXuat;
	private int Instock;
	
	public Product(int id, int maLoai, String tenSanPham, String moTa, float gia, String hinhAnh, String hinhCT1,
			String hinhCT2, String hangSanXuat, int instock) {
		super();
		this.id = id;
		MaLoai = maLoai;
		TenSanPham = tenSanPham;
		MoTa = moTa;
		Gia = gia;
		HinhAnh = hinhAnh;
		HinhCT1 = hinhCT1;
		HinhCT2 = hinhCT2;
		HangSanXuat = hangSanXuat;
		Instock = instock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaLoai() {
		return MaLoai;
	}

	public void setMaLoai(int maLoai) {
		MaLoai = maLoai;
	}

	public String getTenSanPham() {
		return TenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		TenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
	}

	public float getGia() {
		return Gia;
	}

	public void setGia(float gia) {
		Gia = gia;
	}

	public String getHinhAnh() {
		return HinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		HinhAnh = hinhAnh;
	}

	public String getHinhCT1() {
		return HinhCT1;
	}

	public void setHinhCT1(String hinhCT1) {
		HinhCT1 = hinhCT1;
	}

	public String getHinhCT2() {
		return HinhCT2;
	}

	public void setHinhCT2(String hinhCT2) {
		HinhCT2 = hinhCT2;
	}

	public String getHangSanXuat() {
		return HangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		HangSanXuat = hangSanXuat;
	}

	public int getInstock() {
		return Instock;
	}

	public void setInstock(int instock) {
		Instock = instock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", MaLoai=" + MaLoai + ", TenSanPham=" + TenSanPham + ", MoTa=" + MoTa + ", Gia="
				+ Gia + ", HinhAnh=" + HinhAnh + ", HinhCT1=" + HinhCT1 + ", HinhCT2=" + HinhCT2 + ", HangSanXuat="
				+ HangSanXuat + ", Instock=" + Instock + "]";
	}

	public Product() {
		super();
	}
	
	
}
