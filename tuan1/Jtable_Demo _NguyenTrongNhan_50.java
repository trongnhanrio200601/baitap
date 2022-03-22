package tuan1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.print.attribute.standard.JobMediaSheetsCompleted;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Jtable_Demo extends JFrame{
	JLabel lblHo, lblTen;
	JTextField txtHo , txtTen;
	JButton btnThem , btnXoa, btnSua , btnThoat;
	private DefaultTableModel tableModelPerson;
	private JTable tablePerson;
	public Jtable_Demo() {
		// TODO Auto-generated constructor stub
		setTitle("Edit Table");
		setSize(550,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel p = new JPanel();
		p.add(lblHo = new JLabel("Ho"));
		p.add(txtHo = new JTextField(45));
		p.add(lblTen = new JLabel("Ten"));
		p.add(txtTen = new JTextField(45));
		p.add(btnThem = new JButton("Them"));
		p.add(btnSua = new JButton("Sua"));
		p.add(btnXoa = new JButton("Xoa"));
		p.add(btnThoat = new JButton("Thoat"));
		
		String []header = {"Ho", "Ten"};
		tableModelPerson = new DefaultTableModel(header,0);
		tablePerson = new JTable(tableModelPerson);
		p.add(new JScrollPane(tablePerson));
		tablePerson.setSize(500, 200);
		add(p);
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (txtHo.getText().equals("") ||txtTen.getText().equals("") )
					JOptionPane.showMessageDialog(null, "Phai Nhap Du Lieu");
				else {
					Object[] obj = new Object[2];
					obj[0] = txtHo.getText();
					obj[1] = txtTen.getText();
					tableModelPerson.addRow(obj);
				}
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if ( tablePerson.getSelectedRow()== -1 )
					JOptionPane.showMessageDialog(null, "Chon dong can xoa");
				else {
//					if(JOptionPane.showConfirmDialog(this, "Ban co muon xoa dong nay khong ?",
//							"Canh Bao", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION);
					//if (JOptionPane.showConfirmDialog(this,"Ban co muon xoa dong nay khong?","Canh bao",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION
					int select =  JOptionPane.showConfirmDialog(null, "Ban co muon Xoa hay khong");
					if (select == JOptionPane.OK_OPTION)
						tableModelPerson.removeRow(tablePerson.getSelectedRow());
				}
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
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if ( tablePerson.getSelectedRow()== -1 )
					JOptionPane.showMessageDialog(null, "Chon dong can sua");
				else {
					int row = tablePerson.getSelectedRow();
					tableModelPerson.setValueAt(txtHo.getText(), row, 0);
					tableModelPerson.setValueAt(txtTen.getText(), row, 1);
				}
			}
		});
		
		
	}
	
	public static void main(String[] args) {
		new Jtable_Demo().setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e)
	{

		int row = tablePerson.getSelectedRow();
		txtHo.setText(tablePerson.getValueAt(row, 0).toString());
		txtTen.setText(tablePerson.getValueAt(row, 1).toString());
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	
}
