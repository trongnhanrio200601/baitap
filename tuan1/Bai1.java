package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai1 extends JFrame implements ActionListener {
	public Bai1() {
		setTitle("Giai PT bat 2");
		setSize(600,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel p1 = new JPanel();
		JLabel lblNorth = new JLabel("GIAI PHUONG TRINH BAT 2");
		p1.setBackground(Color.CYAN);
		lblNorth.setFont(new Font("Arial", Font.BOLD , 20));
		p1.add(lblNorth);
		
		add(p1, BorderLayout.NORTH);
		
		Box b , b1 , b2 , b3, b4 ;
		b = Box.createVerticalBox();
		b1 = Box.createHorizontalBox();
		b2 = Box.createHorizontalBox();
		b3 = Box.createHorizontalBox(); 
		b4 = Box.createHorizontalBox();
		
		JLabel lblA = new JLabel("Nhap A :");
		b1.add(lblA);
		JTextField txtA = new JTextField();
		b1.add(txtA);
		JLabel lblB = new JLabel("Nhap B :");
		b2.add(lblB);
		JTextField txtB = new JTextField();
		b2.add(txtB);
		JLabel lblC = new JLabel("Nhap C :");
		b3.add(lblC);
		JTextField txtC = new JTextField();
		b3.add(txtC);
		JLabel lblKetQua = new JLabel("Ket Qua :");
		b4.add(lblKetQua);
		JTextField txtKetQua = new JTextField();
		txtKetQua.setEditable(false);
		b4.add(txtKetQua);
		
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		
		add(b);
		
		
		Box box1 ;
		box1 = Box.createHorizontalBox();
		box1.setBorder(BorderFactory.createTitledBorder("Chon Tac Vu"));
		JButton btnGiai = new JButton("Giai");
		JButton btnXoaRong = new JButton("Xoa rong");
		JButton btnThoat = new JButton("Thoat");
		box1.add(Box.createRigidArea(new Dimension(150,0)));
		box1.add(btnGiai);
		box1.add(btnXoaRong);
		box1.add(btnThoat);
		
		add(box1, BorderLayout.SOUTH);
		
		btnGiai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (!isInt(txtA))
				{
					focus(txtA);
				}else if (!isInt(txtB)) {
					focus(txtB);
				}else if ( !isInt(txtC)) {
					focus(txtC);
				} else {
					int a , b , c ;
					a = Integer.parseInt(txtA.getText());
					b = Integer.parseInt(txtB.getText());
					c = Integer.parseInt(txtC.getText());
				
				if (a == 0) {
		            if (b == 0) {
		            	txtKetQua.setText("Phuong trinh vo nghiem!");
		            } else {
		            	txtKetQua.setText("Phuong trinh co 1 nghiem: " + "x = " + (-c / b));
		            }
		            return;
		        }
	
		        float delta = b*b - 4*a*c;
		        float x1;
		        float x2;
		  
		        if (delta > 0) {
		            x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
		            x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
		            txtKetQua.setText("Phuong trinh co 2 nghiem: " + "x1 = " + x1 + " v� x2 = " + x2);
		        } else if (delta == 0) {
		            x1 = (-b / (2 * a));
		            txtKetQua.setText("Phuong trinh co nghiem kep: " + "x1 = x2 = " + x1);
		        } else {
		        	txtKetQua.setText("Phuong trinh vo nghiem!");
		        }
			}
			}
		});
		
		btnXoaRong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtA.setText("");
				txtB.setText("");
				txtC.setText("");
				txtKetQua.setText("");
				txtA.requestFocus();
			}
		});
		
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int select =  JOptionPane.showConfirmDialog(null, "Ban co muon thoat hay khong");
				if (select == JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bai1().setVisible(true);
	}

		private boolean isInt(JTextField text) {

		boolean result = true;
		try{
		Integer.parseInt(text.getText());
		}catch(NumberFormatException ex){
		result = false;
		}
		return result;
		}

		private void focus(JTextField text) {
		JOptionPane.showMessageDialog(null, "Lỗi nhập liệu.");
		text.selectAll();
		text.requestFocus();
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	
	
	
}

