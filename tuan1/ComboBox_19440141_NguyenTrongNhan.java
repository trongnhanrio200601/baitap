package tuan1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComboBox_19440141_NguyenTrongNhan extends JFrame implements ActionListener{
	
	private JLabel lbllabel;
	private JComboBox faceCombo;
	public ComboBox_19440141_NguyenTrongNhan() {
		// TODO Auto-generated constructor stub
		setTitle("JComboBox Demo");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		
		
		lbllabel = new JLabel("The quick brown fox jumps over the lazy dog.");
		lbllabel.setFont(new Font("Serif", Font.PLAIN, 12));
		add(lbllabel, BorderLayout.CENTER);
		// make a combo box 
		faceCombo = new JComboBox();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		add(faceCombo, BorderLayout.SOUTH);
		
		
		
		
		
		
		faceCombo.addActionListener(this);
		
	}
	
	public static void main(String[] args) {
		new ComboBox_19440141_NguyenTrongNhan().setVisible(true);
	}
	public void actionPerformed (ActionEvent e) {
		String fontName = (String)faceCombo.getSelectedItem();
		lbllabel.setFont (new Font(fontName, lbllabel.getFont().getStyle(), lbllabel.getFont().getSize()));
		}
}
