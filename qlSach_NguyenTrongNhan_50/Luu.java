package qlSach_NguyenTrongNhan_50;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Luu {
	public boolean LuuFile (Object obj , String filePath) throws Exception{
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(new FileOutputStream(filePath));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	public Object DocFile(String filePath) throws Exception{
		ObjectInputStream ois = new
				ObjectInputStream( new FileInputStream(filePath));
		Object o = ois.readObject();
		ois.close();
		return o;
	}
}
