package tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Bai3 extends JFrame {
	public Bai3() {
		// TODO Auto-generated constructor stub
		setTitle("Cong tru nhan chia");
		setSize(600,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel p1 = new JPanel();
		JLabel lblNorth = new JLabel("Cong Tru Nhan Chia");
		lblNorth.setFont(new Font("Arial", Font.BOLD , 30));
		lblNorth.setForeground(Color.BLUE);
		p1.add(lblNorth);
		add(p1);
		add(p1, BorderLayout.NORTH);
		
		Box boxCenter = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		boxCenter.setBorder(BorderFactory.createTitledBorder("Tinh Toan"));
		JLabel lblA = new JLabel("So A        :");
		JTextField txtA = new JTextField();
		b1.add(lblA); 
		b1.add(txtA);
		JLabel lblB = new JLabel("So B        :");
		JTextField txtB = new JTextField();
		b2.add(lblB);
		b2.add(txtB);
		Box boxPT = Box.createVerticalBox();
		Box PT1= Box.createHorizontalBox();
		Box PT2= Box.createHorizontalBox();
		boxPT.setBorder(BorderFactory.createTitledBorder("Phep toan"));
		final JRadioButton radCong = new JRadioButton("Cong");
		PT1.add(radCong);
		final JRadioButton radTru = new JRadioButton("Tru");
		PT1.add(radTru);
		final JRadioButton radNhan = new JRadioButton("Nhan");
		PT2.add(radNhan);
		final JRadioButton radChia = new JRadioButton("Chia");
		PT2.add(radChia);
		boxPT.add(PT1);
		boxPT.add(PT2);
		b3.add(boxPT);
		JLabel lblKQ = new JLabel("Ket Qua :");
		JTextField txtKQ = new JTextField();
		txtKQ.setEditable(false);
		b4.add(lblKQ);
		b4.add(txtKQ);
		boxCenter.add(b1);
		boxCenter.add(b2);
		boxCenter.add(b3);
		boxCenter.add(b4);
		JPanel pnlButton = new JPanel();
		pnlButton.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		Box button = Box.createVerticalBox();
		JButton btnGiai = new JButton("  Giai  ");
		button.add(btnGiai);
		JButton btnXoa = new JButton(" Xoa  ");
		button.add(btnXoa);
		JButton btnThoat = new JButton("Thoat");
		button.add(btnThoat);
		pnlButton.add(button);
		ButtonGroup btn = new ButtonGroup();
		btn.add(radCong);
		btn.add(radTru);
		btn.add(radNhan);
		btn.add(radChia);
		add(pnlButton,BorderLayout.WEST);
		add(boxCenter);
		
		
		
		
		
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int select =  JOptionPane.showConfirmDialog(null, "Ban co muon thoat hay khong");
				if (select == JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtA.setText("");
				txtB.setText("");
				txtKQ.setText("");
				txtA.requestFocus();
			}
		});
		
		btnGiai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int a , b ;
				double kq= 0;
				if(!isInt(txtA)) {
					focus(txtA);
				} else if (!isInt(txtB)){
					focus(txtB);
				}else {
					a = Integer.parseInt(txtA.getText());
					b = Integer.parseInt(txtB.getText());
					
					if(radCong.isSelected()) {
						kq= a + b;
					}else if (radTru.isSelected()) {
						kq = a-b;
					}else if (radNhan.isSelected()) {
						kq = a *b ;

					}else if (radChia.isSelected()) {
						kq= a*1.0 / b*1.0;
					}else {
						JOptionPane.showMessageDialog(null, "Chua chon phep toan");
					}
				}
				txtKQ.setText("" + kq);
			}
		});
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bai3().setVisible(true);
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


		
}
