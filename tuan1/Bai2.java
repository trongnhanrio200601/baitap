package tuan1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai2 extends JFrame implements ActionListener {
	public Bai2() {
		// TODO Auto-generated constructor stub
		setTitle("Giai PT bat 2");
		setSize(600,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		Box box1 = Box.createHorizontalBox();
		JTextField txtN = new JTextField();
		box1.add(txtN);
		JButton btnGenerate = new JButton("Generate");
		box1.add(btnGenerate);
		add(box1, BorderLayout.NORTH);
		JTextArea txtList = new JTextArea();
		JScrollPane pn = new JScrollPane(txtList);
		pn.add(txtList);
		add(txtList);
		
		
		btnGenerate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!isInt(txtN)) {
					focus(txtN);
				}else {
					int n = Integer.parseInt(txtN.getText());
					String str= "";
					for (int i = 0  ; i < n ; i++) {
						if(kiemTraSoNT(i)) {
							str+= i +"\n";
							txtList.setText(str);
						}
					}
				}
				
			}
		});
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		new Bai2().setVisible(true);
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
		public boolean kiemTraSoNT(int n) {
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
