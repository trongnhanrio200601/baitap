package tuan1;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;

public class Rad_Chk_19440141_NguyenTrongNhan extends JFrame implements ActionListener, ItemListener{

	private JCheckBox chkitalic;
	private JRadioButton radLeft;
	private JRadioButton radRight;
	private JLabel lblLable;
	public Rad_Chk_19440141_NguyenTrongNhan() {
		// TODO Auto-generated constructor stub
		setTitle("Check Box");
		setSize(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// set up JTextField and set its font
		
		
		add(lblLable = new JLabel("Hello World"));
		lblLable.setHorizontalAlignment(SwingConstants.LEFT);
		add(lblLable);
		// create checkbox objects
		
		JPanel p2 = new JPanel();
		p2.add( chkitalic = new JCheckBox("Italic"));
		p2.add(radLeft = new JRadioButton("Left", true));
		p2.add(radRight = new JRadioButton("Right"));
		ButtonGroup gr = new ButtonGroup();
		gr.add(radLeft); gr.add(radRight);
		
		add(p2,BorderLayout.NORTH);
		
		chkitalic.addItemListener(this);
		radLeft.addActionListener(this);
		radRight.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new Rad_Chk_19440141_NguyenTrongNhan().setVisible(true);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Font f = lblLable.getFont();
		if(e.getItem() == chkitalic) {
			lblLable.setFont(new Font(f.getName(), f.getStyle()^Font.BOLD, f.getSize()));
		}else
			lblLable.setFont(new Font("Serif", Font.PLAIN, 16));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(radLeft)) {
			lblLable.setHorizontalAlignment(SwingConstants.LEFT);
		}else if(o.equals(radRight)) {
			lblLable.setHorizontalAlignment(SwingConstants.RIGHT);
	}
	}
}
