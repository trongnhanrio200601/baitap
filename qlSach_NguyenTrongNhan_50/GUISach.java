package qlSach_NguyenTrongNhan_50;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import qlNhanVien_NguyenTrongNhan_50.DsNhanVien;
import qlNhanVien_NguyenTrongNhan_50.LuuTru;

public class GUISach extends JFrame  implements ActionListener ,MouseListener{
	JLabel lblMaSach;
	private JTextField txtMaSach;
	private JLabel lblTuaSach;
	private JTextField txtTuaSach;
	private JLabel lblTacGia;
	private JTextField txtTacGia;
	private JLabel lblNamXB;
	private JTextField txtNamXB;
	private JLabel lblNhaXB;
	private JTextField txtNhaXB;
	private JLabel lblSoTrang;
	private JTextField txtSoTrang;
	private JLabel lblDonGia;
	private JTextField txtDonGia;
	private JLabel lblISBN;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private JLabel lblTim;
	private JCheckBox chkTim;
	private JComboBox<String> comboTim;
	private JButton btnLuu;
	private DefaultTableModel model;
	private JTable table;
	private dsSach listSach;
	private int row;
	private String maSoSach;
	public GUISach() {
		// TODO Auto-generated constructor stub
		setTitle("^-^");
		setSize(900, 450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Box boxCenter = Box.createVerticalBox();
		boxCenter.setBorder(BorderFactory.createTitledBorder("Records Editor"));
		Box pnNorth = Box.createVerticalBox();
		pnNorth.add(Box.createHorizontalStrut(20));
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		
		boxCenter.add(b1);
		boxCenter.add(b2);
		boxCenter.add(b3);
		boxCenter.add(b4);
		boxCenter.add(b5);
		b1.add(lblMaSach = new JLabel("MaSach :  "));
		b1.add(txtMaSach = new JTextField(20));
		b1.add(Box.createRigidArea(new Dimension(300, 0)));
		b2.add(lblTuaSach = new JLabel("Tua sach :"));
		b2.add(txtTuaSach = new JTextField(20));
		b2.add(lblTacGia = new JLabel("Tac Gia :"));
		b2.add(txtTacGia = new JTextField());
		b3.add(lblNamXB = new JLabel("Nam Xuat ban :"));
		b3.add(txtNamXB = new JTextField(20));
		b3.add(lblNhaXB = new JLabel("Nha Xuat ban :"));
		b3.add(txtNhaXB = new JTextField());
		b4.add(lblSoTrang = new JLabel("So Trang :"));
		b4.add(txtSoTrang = new JTextField(20));
		b4.add(lblDonGia = new JLabel("Don Gia :"));
		b4.add(txtDonGia = new JTextField());
		b5.add(lblISBN = new JLabel("International Standard Book Number (ISBN) :"));
		b5.add(txtISBN = new JTextField(20));
		pnNorth.add(boxCenter);
		JPanel pnButton = new JPanel();
		pnNorth.add(pnButton);
		pnButton.add(btnThem = new JButton("Them"));
		pnButton.add(btnXoaRong = new JButton("Xoa rong"));
		pnButton.add(btnSua = new JButton("Sua"));
		pnButton.add(btnXoa = new JButton("Xoa"));
		pnButton.add(btnLuu = new JButton("Luu"));
		pnButton.add(lblTim = new JLabel("                            Tim theo ma sach"));
		pnButton.add(comboTim = new JComboBox<String>());
		add(pnNorth, BorderLayout.NORTH);
		
		
		
		String []colHeader= {"Ma Sach", "Tua Sach", "Tac Gia", "Nam XB", "Nha XB", "So Trang" , "Don Gia","ISBN"};
		model = new DefaultTableModel(colHeader,0);
		table = new JTable(model);
		add(new JScrollPane(table));
		listSach = new dsSach();
		Luu l = new Luu();
		try {
			listSach = (dsSach) l.DocFile("src/qlSach_NguyenTrongNhan_50/Sach.txt");
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Khong tim thay file");
			
		}
		
		docDuLieu();
		
		
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					themSach();	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Chua nhap du thong tin");
				}
							
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaSach();
			}
		});
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaSach.setText("");
				txtTuaSach.setText("");
				txtTacGia.setText("");
				txtNamXB.setText("");
				txtNhaXB.setText("");
				txtSoTrang.setText("");
				txtDonGia.setText("");
				txtISBN.setText("");
			}
		});
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Luu l = new Luu();
				try {
					l.LuuFile(listSach, "src/qlSach_NguyenTrongNhan_50/Sach.txt");
					JOptionPane.showMessageDialog(null, "Luu thanh cong");
				}catch (Exception ee) {
					// TODO: handle exception
					ee.printStackTrace();
					JOptionPane.showMessageDialog(null, "Khong Luu duoc");
				}
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Sach s = new Sach(txtMaSach.getText(),txtTuaSach.getText(),txtTacGia.getText(),
						Integer.parseInt(txtNamXB.getText()),txtNhaXB.getText(),
						Integer.parseInt(txtSoTrang.getText()),Double.parseDouble(txtDonGia.getText()),
						txtISBN.getText());
				listSach.suaSach(row, s);
				for(int i = 0 ; i < listSach.getSize(); i++)
					model.removeRow(0);
				
				docDuLieu();
				
			}
		});
		
		table.addMouseListener(this);
		comboTim.addActionListener(this);
	}
	
	private void docDuLieu() {
		for(int i = 0 ; i < listSach.getSize() ; i++) {
			Sach s = listSach.getElement(i);
			model.addRow(new Object[] {s.getMaSach(),s.getTuaSach(),s.getTacGia(),s.getNamXuatBan(),
					s.getNhaXuatBan(),s.getSoTrang(),s.getDonGia(),s.getiSBN()});
			comboTim.addItem(s.getMaSach());
		}
		
	}
	
	public static void main(String[] args) {
		new GUISach().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		int i = listSach.timSach((String)comboTim.getSelectedItem());
		table.setRowSelectionInterval(i,i);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		row = table.getSelectedRow();
		maSoSach = model.getValueAt(row, 0).toString();
		txtMaSach.setText(model.getValueAt(row, 0).toString());
		txtTuaSach.setText(model.getValueAt(row, 1).toString());
		txtTacGia.setText(model.getValueAt(row, 2).toString());
		txtNamXB.setText(model.getValueAt(row, 3).toString());
		txtNhaXB.setText(model.getValueAt(row, 4).toString());
		txtSoTrang.setText(model.getValueAt(row, 5).toString());
		txtDonGia.setText(model.getValueAt(row, 6).toString());
		txtISBN.setText(model.getValueAt(row, 7).toString());
		
	}
	private void themSach() {
		Sach s = new Sach(txtMaSach.getText(),txtTuaSach.getText(),txtTacGia.getText(),
				Integer.parseInt(txtNamXB.getText()),txtNhaXB.getText(),
				Integer.parseInt(txtSoTrang.getText()),Double.parseDouble(txtDonGia.getText()),
				txtISBN.getText());
		if(listSach.themSach(s)) {
			model.addRow(new Object[] {s.getMaSach(),s.getTuaSach(),s.getTacGia(),s.getNamXuatBan(),
					s.getNhaXuatBan(),s.getSoTrang(),s.getDonGia(),s.getiSBN()});
			comboTim.addItem(s.getMaSach());
		}else JOptionPane.showMessageDialog(null, "Trung Ma So");
		
	}
	private void xoaSach() {
		if(listSach.xoaSach(maSoSach)) {
			model.removeRow(row);
			comboTim.removeItemAt(row);;
		}else JOptionPane.showMessageDialog(null, "Chua Chon gia tri xoa");
	}
}
