package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Jlist_CheckBox_demo extends JFrame{
	JPanel p1 , p2 , p3 , p4 ,lblThoat;
	JLabel lblNorth , lblnull  ;
	Box b1, b2;
	JTextField txtNhap;
	JCheckBox chkSoAm;
	DefaultListModel<Integer> listmodelNuber;
	JList<Integer> listNuber;
	JButton btnPSS , btnThoat, btnToDenChan , btnToDenLe , btnToDenSNT, btnBoToDen , btnDelToDen , btnSumList , btnNhap;
	public Jlist_CheckBox_demo() {
		// TODO Auto-generated constructor stub
		setTitle("Check Box");
		setSize(600,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		p1 = new JPanel();
		p1.add( lblNorth = new JLabel("Thao tac tren List - CheckBox"));
		lblNorth.setFont(new Font("Arial", Font.BOLD , 30));
		lblNorth.setForeground(Color.BLUE);
		add(p1, BorderLayout.NORTH);
		
		p2= new JPanel();
		p2.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		p2.setLayout(new GridLayout(7, 1));
		p2.add( btnToDenChan = new JButton("To Den so chan"));
		p2.add( btnToDenLe = new JButton("To Den so Le"));
		p2.add( btnToDenSNT = new JButton("To Den so nguyen to"));
		p2.add( btnBoToDen = new JButton("Bo to den"));
		p2.add( btnDelToDen = new JButton("Xoa Cac gia tri dang to den"));
		p2.add( btnSumList = new JButton("Tong cac gia tri trong list"));
		
		add(p2, BorderLayout.WEST);
		
		
		
		p3 = new JPanel();
		p3.setBorder(BorderFactory.createTitledBorder("Nhap Thong tin"));
		p3.add( b2 = Box.createHorizontalBox() );
		p3.add( b1 = Box.createVerticalBox() );
		
		
		b2.add(btnNhap = new JButton("Nhap"));
		b2.add(txtNhap = new JTextField(10));
		b2.add(chkSoAm = new JCheckBox("Chon so le"));
		
		listmodelNuber = new DefaultListModel<Integer>();
		listNuber = new JList<Integer>(listmodelNuber);
		listNuber.setVisibleRowCount(10);
		b1.add(new JScrollPane(listNuber));
		
		add(p3 , BorderLayout.CENTER);
		
		p4= new JPanel();
		p4.setLayout(new GridLayout(3, 1));
		p4.add(lblnull = new JLabel());
		p4.add(lblThoat = new JPanel());
		lblThoat.add(btnThoat = new JButton("Dong chuong trinh"));
		lblThoat.add(btnPSS = new JButton("Phat Sinh So"));
		add(p4, BorderLayout.SOUTH);
		
		
		btnNhap.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				nhapSoTuBanPhin();
			}
		});
		btnPSS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				phatSinhSo();
			}
		});
		btnToDenChan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listNuber.clearSelection();
				for ( int i = 0 ; i < listmodelNuber.size(); i++)
					if(listmodelNuber.getElementAt(i) % 2 == 0)
						listNuber.addSelectionInterval(i, i);
			}
		});
		
		btnToDenLe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listNuber.clearSelection();
				for ( int i = 0 ; i < listmodelNuber.size(); i++)
					if(listmodelNuber.getElementAt(i) % 2 == 1)
						listNuber.addSelectionInterval(i, i);
			}
		});
		btnToDenSNT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listNuber.clearSelection();
				for ( int i = 0 ; i < listmodelNuber.size(); i++)
					if(isPrimeNumber(listmodelNuber.getElementAt(i)))
						listNuber.addSelectionInterval(i, i);
			}
		});
		
		btnBoToDen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listNuber.clearSelection();
			}
		});
		
		btnDelToDen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for ( int j = 0 ; j <= listmodelNuber.getSize()   ; j++)
				{
					if(listNuber.isSelectedIndex(j)== true)
						listmodelNuber.removeElementAt(j);
				}
			}
		});
		btnSumList.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int tong= 0;
			for ( int j = 0 ; j < listmodelNuber.size(); j++) {
				tong =tong + (Integer) listmodelNuber.getElementAt(j);
				
			}
			JOptionPane.showMessageDialog(null, "Tong la: " + tong);
		}
	});
		
		
	}
	
	
	
	public static void main(String[] args) {
		new Jlist_CheckBox_demo().setVisible(true);
	}
	
	void nhapSoTuBanPhin() {
		int n; 
		try {
			n = Integer.parseInt(txtNhap.getText());
			if(!chkSoAm.isSelected() && n > 0)
				listmodelNuber.addElement(n);
			else if (chkSoAm.isSelected())
				listmodelNuber.addElement(n);
			else {
				JOptionPane.showMessageDialog(null, "Khong duoc nhap so am");
				return;
			}
			
			txtNhap.setText("");
			txtNhap.requestFocus();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Nhap So");
			txtNhap.setText("");
			txtNhap.requestFocus();
			return;
		}
	}
	
	void phatSinhSo() {
		for (int i = 0 ; i < 10 ; i++) {
			if(chkSoAm.isSelected())
				listmodelNuber.addElement(new Random().nextInt(100)-20);
			else
				listmodelNuber.addElement(new Random().nextInt(100));
		}
	}
	public static boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
