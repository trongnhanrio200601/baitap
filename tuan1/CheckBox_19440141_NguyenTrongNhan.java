package tuan1;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
	
public class CheckBox_19440141_NguyenTrongNhan extends JFrame implements ItemListener{
	private JTextField txtfield;
	private JCheckBox chkbold;
	private JCheckBox chkitalic;
	public CheckBox_19440141_NguyenTrongNhan() {
		setTitle("Check Box");
		setSize(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new GridLayout(2, 1));
		// set up JTextField and set its font
		JPanel p1 = new JPanel();
		
		p1.add(txtfield = new JTextField("Watch the font style change", 20));
		txtfield.setFont(new Font("Serif", Font.PLAIN, 16));
		add(p1);
		// create checkbox objects
		
		JPanel p2 = new JPanel();
		p2.add( chkbold = new JCheckBox("Bold"));
		p2.add( chkitalic = new JCheckBox("Italic"));
		add(p2);
		
		chkbold.addItemListener(this);
		chkitalic.addItemListener(this);
		
	}
	
	
	public static void main(String[] args) {
		new CheckBox_19440141_NguyenTrongNhan().setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Font f = txtfield.getFont();
		if(e.getItem() == chkbold) {
			txtfield.setFont(new Font(f.getName(), f.getStyle()^Font.BOLD, f.getSize()));
		}
		if(e.getItem() == chkitalic) {
			txtfield.setFont(new Font(f.getName(), f.getStyle()^Font.ITALIC, f.getSize()));
		}
		
	}
}
