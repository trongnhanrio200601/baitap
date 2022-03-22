package qlNhanVien_NguyenTrongNhan_50;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String maNV;
	private String hoNV;
	private String tenNV;
	private boolean gioiTinh;
	private int tuoiNV;
	private double tienLuong;
	
	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}
	
	
	public NhanVien(String maNV, String hoNV, String tenNV, boolean gioiTinh, int tuoiNV, double tienLuong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.gioiTinh = gioiTinh;
		this.tuoiNV = tuoiNV;
		this.tienLuong = tienLuong;
	}
	
	
	
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getTuoiNV() {
		return tuoiNV;
	}
	public void setTuoiNV(int tuoiNV) {
		this.tuoiNV = tuoiNV;
	}
	public double getTienLuong() {
		return tienLuong;
	}
	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", tuoiNV="
				+ tuoiNV + ", tienLuong=" + tienLuong + "]";
	}
	
	
}
