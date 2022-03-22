package qlSach_NguyenTrongNhan_50;

import java.io.Serializable;
import java.util.ArrayList;



public class dsSach implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Sach> dsSach;
	public dsSach() {
		dsSach = new ArrayList<Sach>();
	}
	
	public boolean themSach(Sach s) {
		if(dsSach.contains(s)) {
			return false;
		}else {
			dsSach.add(s);
			return true;
		}
	}
	
	public boolean xoaSach(String ma) {
		Sach s = new Sach(ma);
		if(dsSach.contains(s)) {
			dsSach.remove(s);
			return true;
		}else {
			return false;
		}
	}
	
	
	public int timSach(String ma) {
		Sach s = new Sach(ma);
		if(dsSach.contains(s)) {
			return dsSach.indexOf(s);
		}
		else return -1;
	}
	
	public boolean suaSach(int i , Sach s) {
		dsSach.remove(i);
		dsSach.add(i, s);
		return true;
	}
	
	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	
	public Sach getElement (int index) {
		if(index < 0 || index >= dsSach.size()) {
			return null;
		}return dsSach.get(index);
	}
	
	
	
	public int getSize() {
		return dsSach.size();
	}
	
	
}
