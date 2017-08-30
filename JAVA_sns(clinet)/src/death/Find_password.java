package death;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.ws.handler.MessageContext.Scope;

public class Find_password extends JFrame implements ActionListener,MouseListener{
	
	JTextField id = new JTextField();
	JTextField e_mail = new JTextField();
	JButton check_b = new JButton(new ImageIcon("check_b.png"));
	Font font1 = new Font("한컴 윤체 B",Font.PLAIN,17);

	
	public Find_password(){
		MyPanel myp = new MyPanel();
	//	setUndecorated(true);
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myp.setLayout(null);
		myp.addMouseListener(this);
		
		//확인버튼
		check_b.setBounds(310, 353, 85, 51);
		myp.add(check_b);
		check_b.addMouseListener(this);
		check_b.addActionListener(this);
		//이름
		id.setBounds(180,183,413,44);
		id.addActionListener(this);
		id.addMouseListener(this);
		id.setFont(font1);
		myp.add(id);
		
		//학번
		e_mail.setBounds(180,258,413,44);
		e_mail.addActionListener(this);
		e_mail.addMouseListener(this);
		e_mail.setFont(font1);
		myp.add(e_mail);
		
		add(myp);
		setVisible(true);
		setResizable(false);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String name = id.getText();
		String number = e_mail.getText();

		if(e.getSource() == id){
			id.setBackground(new Color(255,255,255));
		}
		if(e.getSource() == e_mail){
			e_mail.setBackground(new Color(255,255,255));
		}
		
		if(e.getSource() == check_b){
			System.out.println(name);
			System.out.println(number);
		}
	}
	
	
	class MyPanel extends JPanel{
		ImageIcon img = new ImageIcon("password_find.jpg");
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img.getImage(), 0, 0, null);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == id){
			id.setBackground(new Color(110,195,199));
		}
		if(e.getSource() == e_mail){
			e_mail.setBackground(new Color(110,195,199));
		}
		else if(e.getSource() != id && e.getSource() != e_mail){
			id.setBackground(new Color(255,255,255));
			e_mail.setBackground(new Color(255,255,255));
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}





}
