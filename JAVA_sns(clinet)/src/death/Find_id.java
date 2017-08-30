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

public class Find_id extends JFrame implements ActionListener,MouseListener{
	
	JTextField name_text = new JTextField();
	JTextField school_number = new JTextField();
	JButton check_b = new JButton(new ImageIcon("check_b.png"));
	Font font1 = new Font("한컴 윤체 B",Font.PLAIN,17);

	
	public Find_id(){
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
		name_text.setBounds(190,183,334,44);
		name_text.addActionListener(this);
		name_text.addMouseListener(this);
		name_text.setFont(font1);
		myp.add(name_text);
		
		//학번
		school_number.setBounds(190,258,334,44);
		school_number.addActionListener(this);
		school_number.addMouseListener(this);
		school_number.setFont(font1);
		myp.add(school_number);
		
		add(myp);
		setVisible(true);
		setResizable(false);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		String name = name_text.getText();
		String number = school_number.getText();

		if(e.getSource() == name_text){
			name_text.setBackground(new Color(255,255,255));
		}
		if(e.getSource() == school_number){
			school_number.setBackground(new Color(255,255,255));
		}
		
		if(e.getSource() == check_b){
			System.out.println(name);
			System.out.println(number);
		}
	}
	
	
	class MyPanel extends JPanel{
		ImageIcon img = new ImageIcon("id_find.jpg");
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img.getImage(), 0, 0, null);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == name_text){
			name_text.setBackground(new Color(110,195,199));
		}
		if(e.getSource() == school_number){
			school_number.setBackground(new Color(110,195,199));
		}
		else if(e.getSource() != name_text && e.getSource() != school_number){
			name_text.setBackground(new Color(255,255,255));
			school_number.setBackground(new Color(255,255,255));
		}
	}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}





}
