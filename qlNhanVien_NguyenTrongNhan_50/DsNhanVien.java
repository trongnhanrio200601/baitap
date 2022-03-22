package qlNhanVien_NguyenTrongNhan_50;

import java.io.Serializable;
import java.util.ArrayList;

public class DsNhanVien implements Serializable {
	/**
	 * 
	 */
	
	
	ArrayList<NhanVien> dsNhanVien;
	
	public DsNhanVien() {
		dsNhanVien = new ArrayList<NhanVien>();
	}
	
	public boolean themNhanVien(NhanVien x)
	{
			if(dsNhanVien.contains(x)) {
				return false;
			}
			else 
				{
					dsNhanVien.add(x);
					return true;
				}
	}
	
	
	public NhanVien timNhanVien(String ms) {
		NhanVien nv = new NhanVien(ms);
		if(dsNhanVien.contains(nv)) 
			return dsNhanVien.get(dsNhanVien.indexOf(nv));
		else return null;
		
	}
	
	public ArrayList<NhanVien> getDsNV(){
		return dsNhanVien;
	}
	public void setDsNV(ArrayList<NhanVien> dsNhanViens) {
		this.dsNhanVien= dsNhanViens;
	}
	public NhanVien getElement ( int index) {
		if(index < 0 || index >= dsNhanVien.size()) {
			return null;
		}return dsNhanVien.get(index);
	}
	public int getSize() {
		return dsNhanVien.size();
	}
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNhanVien.contains(nv)) {
			dsNhanVien.remove(nv);
			return true;
		}
		else return false;
	}
}

