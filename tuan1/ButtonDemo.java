package tuan1;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class ButtonDemo extends JFrame
{
    protected JButton b1, b2, b3, b4, b5;

    public ButtonDemo()
    {
        super("Button demo");
        this.setLayout(null);
        this.setSize(550,200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo image icon
        ImageIcon leftButtonIcon = new ImageIcon(getClass().getResource("images/right.gif"));
        ImageIcon middleButtonIcon = new ImageIcon(getClass().getResource("images/middle.gif"));
        ImageIcon rightButtonIcon = new ImageIcon(getClass().getResource("images/left.gif"));

        b1 = new JButton("Disable middle button", leftButtonIcon);
        b1.setVerticalTextPosition(AbstractButton.CENTER); //  căn text theo chiều dọc: giữa
        b1.setHorizontalTextPosition(AbstractButton.LEADING); // Căn text theo chiều ngang: đứng đầu
        b1.setToolTipText("Click to disable the middle button."); // Tạo tooltip
        b1.setMnemonic(KeyEvent.VK_D); // đặt phím tắt : Alt + D
        b1.setBounds(10,40,180,30);
        b1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(true);               
            }
        });

        b2 = new JButton("Middle button", middleButtonIcon);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M);
        b2.setBounds(200,20,110,50);

        b3 = new JButton("Enable middle button", rightButtonIcon);
        b3.setToolTipText("Click to enable middle button.");
        //De mac dich text se nam o giua.
        b3.setMnemonic(KeyEvent.VK_E);
        b3.setBounds(320,40,180,30);
        b3.setEnabled(false);
        b3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                b2.setEnabled(true);
                b1.setEnabled(true);
                b3.setEnabled(false);
            }
        });
       
       
        b4 = new JButton("setVisible()");
        b4.setToolTipText("an hien Middle button");
        b4.setBounds(20,80,100,30);
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                b2.setVisible(!b2.isVisible());
            }
        });
       
       
        b5 = new JButton("Move");
        b5.setToolTipText("di chuyen middle button");
        b5.setBounds(390,80,100,30);
        b5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(b2.getLocation().y == 20)
                    b2.setLocation(200,80);
                else
                    b2.setLocation(200,20);
            }
        });       

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);       
    }

   
    public static void main(String[] args)
    {
        new ButtonDemo();
    }
}
