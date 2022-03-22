package qlNhanVien_NguyenTrongNhan_50;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class GuiNhanVien extends JFrame implements MouseListener{
	
	private JPanel pn;
	private JPanel pnNorth;
	private JPanel pnNNorth;
	private JLabel lblTua;

	private JPanel pnCNorth;
	private JPanel pnNorth1;
	private JPanel pnNorth2;
	private JPanel pnNorth3;
	private JPanel pnNorth4;
	
	private JTextField txtMa;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JCheckBox chkGT;
	
	private JTextField txtLuong;
	private JPanel pnSouth;
	private JPanel pnLSouth;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;
	private JPanel pnRSouth;
	private JTextField txtTim;
	private JButton btnTim , btnDungTim;
	private JPanel pnCenter;
	private DefaultTableModel model;
	private JTable table;
	private DsNhanVien listnv;
	private int row;
	private String maSoNV;
	private Font f;
	public GuiNhanVien() {
		setTitle("^-^");
		setSize(900, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//pn Tổng
		pn=new JPanel();
		pn.setLayout(new BorderLayout());
		
		
		//pn North
		pnNorth=new JPanel();
		pnNorth.setLayout(new BorderLayout());
		
		//pnNorth - North
		pnNNorth=new JPanel();
		pnNNorth.add(lblTua=new JLabel("THÔNG TIN NHÂN VIÊN"));
		lblTua.setFont(f=new Font("aral", Font.BOLD, 23));
		lblTua.setForeground(Color.BLUE);
		
		// pn North - Center
		pnCNorth =new JPanel();
		// Xê�?p từ trên xuô�?ng theo trục Y
		pnCNorth.setLayout(new BoxLayout(pnCNorth, BoxLayout.Y_AXIS));
		pnNorth1=new JPanel();
		pnNorth2=new JPanel();
		pnNorth3=new JPanel();
		pnNorth4=new JPanel();
	
		pnNorth1.setLayout(new BoxLayout(pnNorth1,BoxLayout.X_AXIS));
		pnNorth2.setLayout(new BoxLayout(pnNorth2,BoxLayout.X_AXIS));
		pnNorth3.setLayout(new BoxLayout(pnNorth3,BoxLayout.X_AXIS));
		pnNorth4.setLayout(new BoxLayout(pnNorth4, BoxLayout.X_AXIS));
		
		//Mã nhân viên
		pnNorth1.add(new JLabel("Mã nhân viên:"));
		pnNorth1.add(Box.createRigidArea(new Dimension(20, 0)));
		pnNorth1.add(txtMa=new JTextField());
		pnCNorth.add(pnNorth1);
		pnCNorth.add(Box.createRigidArea(new Dimension(10, 10)));
		
		//Họ tên nhân viên
		pnNorth2.add(new JLabel("Họ:"));
		pnNorth2.add(Box.createRigidArea(new Dimension(79, 0)));
		pnNorth2.add(txtHo=new JTextField());
		pnNorth2.add(new JLabel("Tên nhân viên:"));
		pnNorth2.add(txtTen=new JTextField());
		pnCNorth.add(pnNorth2);
		pnCNorth.add(Box.createRigidArea(new Dimension(10, 10)));
		
		//Tuổi - Pha�?i
		pnNorth3.add(new JLabel("Tuổi:"));
		pnNorth3.add(Box.createRigidArea(new Dimension(70, 0)));
		pnNorth3.add(txtTuoi=new JTextField());
		pnNorth3.add(new JLabel("Pha�?i:"));
		pnNorth3.add(Box.createRigidArea(new Dimension(50, 0)));
		pnNorth3.add(chkGT=new JCheckBox("Nữ"));
		pnCNorth.add(pnNorth3);
		pnCNorth.add(Box.createRigidArea(new Dimension(10, 10)));
		
		
		//Tiền lương
		pnNorth4.add(new JLabel("Tiền lương"));
		pnNorth4.add(Box.createRigidArea(new Dimension(35, 0)));
		pnNorth4.add(txtLuong=new JTextField());
		pnCNorth.add(pnNorth4);
		pnCNorth.add(Box.createRigidArea(new Dimension(10, 10)));
	
	
		//-----------------------------------------
		pnNorth.add(pnCNorth, BorderLayout.CENTER);
		pnNorth.add(pnNNorth, BorderLayout.NORTH);
		//---------------End north-------------------
		
		//---------------vùng south------------------
		pnSouth=new JPanel();
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));

		//Bên tra�?i
		pnRSouth=new JPanel();
		pnRSouth.setBorder(BorderFactory.createLoweredBevelBorder());
		pnRSouth.add(new JLabel("Nhập mã cần tìm:  "));
		pnRSouth.add(txtTim=new JTextField(16));
		pnRSouth.add(btnTim=new JButton("Tìm"));
		pnRSouth.add(btnDungTim=new JButton("Dừng Tìm"));
		btnDungTim.setEnabled(false);
		
		//Bên phải
		pnLSouth=new JPanel();
		pnLSouth.setBorder(BorderFactory.createLoweredBevelBorder());
		pnLSouth.add(btnThem=new JButton("Thêm"));
		pnLSouth.add(btnXoaTrang=new JButton("Xo�?a Tră�?ng"));
		pnLSouth.add(btnXoa=new JButton("Xo�?a"));
		pnLSouth.add(btnLuu=new JButton("Lưu"));
		
		pnSouth.add(pnRSouth);
		pnSouth.add(Box.createRigidArea(new Dimension(5,5)));
		pnSouth.add(pnLSouth);
		//----------------------End South-----------------------------
		
		
		//---------------------Center----------------------------------
//		pnCenter=new JPanel();
//		String[] header= {" Mã NV ", " Họ "," Tên ", " Pha�?i ", " Tuổi ", " Tiền Lương "};
//		model=new DefaultTableModel(header,0);
//		table = new JTable(model);
//		this.add(new JScrollPane(table));
//		pnCenter.add(table);
//		pn.add(pnCenter, BorderLayout.CENTER);

		pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		String []colHeader= {"Mã NV", "H�?", "Tên", "Phái", "Tuổi", "Ti�?n lương"};
		pnCenter.add(Box.createRigidArea(new Dimension(10, 10)));
		model = new DefaultTableModel(colHeader,0);
		model.addRow(colHeader);
		table = new JTable(model);
		this.add(new JScrollPane(table));
		pnCenter.add(table);
		pn.add(pnCenter, BorderLayout.CENTER);
		//them sk
		
		listnv = new DsNhanVien();
		LuuTru l = new LuuTru();
		try {
			listnv = (DsNhanVien) l.DocFile("src/qlNhanVien_NguyenTrongNhan_50/NhanVien.txt");
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Khong tim thay file");
			
		}
		
//		NhanVien nv1 = new NhanVien("1","Nguyen Van", "A", true , 20 , 200000);
//		NhanVien nv2 = new NhanVien("2","Nguyen Van", "B", true , 21 , 200000);
//		NhanVien nv3 = new NhanVien("3","Nguyen Van", "C", true , 22 , 200000);
//		NhanVien nv4 = new NhanVien("4","Nguyen Van", "D", true , 23 , 200000);
//		
//		
//		listnv.themNhanVien(nv1);
//		listnv.themNhanVien(nv2);
//		listnv.themNhanVien(nv3);
//		listnv.themNhanVien(nv4);
		
		DocDuLieu();
		//----------------------End center-----------------------------------
		
		
				pn.add(pnNorth, BorderLayout.NORTH);
				pn.add(pnSouth,BorderLayout.SOUTH);
				add(pn);
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Boolean gioiTinh = true;
				if (chkGT.isSelected())
					gioiTinh = false;
				
				
				
				if(txtHo == null) {
					JOptionPane.showMessageDialog(null, "Ho duoc de trong");
					txtHo.selectAll();
					txtHo.requestFocus();
				}else if(txtTen.getText() == null) {
					JOptionPane.showMessageDialog(null, "Ten duoc de trong");
					txtTen.selectAll();
					txtTen.requestFocus();
				}else if (Integer.parseInt(txtTuoi.getText())  < 18) {
					JOptionPane.showMessageDialog(null, "Khong duoc duoi 18 tuoi");
					txtTuoi.selectAll(); 
					txtTuoi.requestFocus();
				}else {
					 NhanVien nv = new NhanVien(txtMa.getText(),txtHo.getText(),txtTen.getText(),
						gioiTinh,Integer.parseInt(txtTuoi.getText()),Integer.parseInt(txtLuong.getText()));
					 themNhanVien(nv);}
				
				
			}
		});
		
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LuuTru l = new LuuTru();
				try {
					l.LuuFile(listnv, "src/qlNhanVien_NguyenTrongNhan_50/NhanVien.txt");
					JOptionPane.showMessageDialog(null, "Luu thanh cong");
				}catch (Exception ee) {
					// TODO: handle exception
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "K Luu duoc");
				}
			}
		});
		
		table.addMouseListener(this);
		
		btnXoaTrang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		btnTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				timTheoMaNV();
				
			}
		});
		
		btnDungTim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				model.removeRow(1);
					
				
				DocDuLieu();
				btnDungTim.setEnabled(false);
				btnTim.setEnabled(true);
				btnThem.setEnabled(true);
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (listnv.xoaNhanVien(maSoNV)) {
					model.removeRow(row);
					xoaTrang();
				}else JOptionPane.showMessageDialog(null, "Chua chon Nhan Vien");
			}
		});
	}
	public static void main(String[] args) {
		new GuiNhanVien().setVisible(true);
	}
	private void themrow1NhanVien(NhanVien nv) {
		String str = "Nữ";
		if(nv.isGioiTinh())
			str = "Nam";
		model.addRow(new Object[] {nv.getMaNV(),nv.getHoNV(),nv.getTenNV(),str, nv.getTuoiNV(),nv.getTienLuong()});
	}
	private void DocDuLieu() {
		for( int i = 0 ; i < listnv.getSize(); i ++) {
			NhanVien nv = listnv.getElement(i);
			themrow1NhanVien(nv);
		}
	}
	
	private void timTheoMaNV(){
		String str = txtTim.getText();
		if(str != null && str.trim().length() > 0) {
			
				NhanVien nv = listnv.timNhanVien(str);
				if (nv != null) {
					xoaTable();
					themrow1NhanVien(nv);
					btnDungTim.setEnabled(true);
					btnTim.setEnabled(false);
					btnThem.setEnabled(false);
				}else 
					JOptionPane.showMessageDialog(null, "Khong tim thay");
		} else 
			JOptionPane.showMessageDialog(null, "Nhap ma so can tim");
	}
	private void xoaTable() {
//		for (int i = 1 ; i <= listnv.getSize() ; i ++) {
//			model.removeRow(1);
		int i = 0;
		while (i < listnv.getSize()) {
			model.removeRow(1);
			i++;
		}	
			
		
		}

	
	
	private void xoaTrang() {
		txtMa.setText("");
		txtHo.setText("");
		txtTen.setText("");
		chkGT.setSelected(false);
		txtTuoi.setText("");
		txtLuong.setText("");
	}
	
	
	
	private void themNhanVien(NhanVien nv) {
		
		if(listnv.themNhanVien(nv))
		{
			themrow1NhanVien(nv);
		}
		else
			JOptionPane.showMessageDialog(null, "Trung Ma So");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		row = table.getSelectedRow();
		txtMa.setText(model.getValueAt(row, 0).toString());
		txtHo.setText(model.getValueAt(row, 1).toString());
		txtTen.setText(model.getValueAt(row, 2).toString());
		chkGT.setSelected(model.getValueAt(row, 3).toString() == "true" ? true : false);
		txtTuoi.setText(model.getValueAt(row, 4).toString());
		txtLuong.setText(model.getValueAt(row, 5).toString());
		maSoNV = model.getValueAt(row, 0).toString();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
