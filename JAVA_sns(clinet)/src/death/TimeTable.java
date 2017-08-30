package death;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class TimeTable extends JFrame implements MouseListener, ActionListener {
	JLabel title = new JLabel();
	Font font1 = new Font("", Font.BOLD, 30);
	Font font2 = new Font("한컴 윤체 B", Font.BOLD, 15);
	Font fontH = new Font("한컴 윤체 B",Font.BOLD,15);
	Font fontH1 = new Font("한컴 윤체 B",Font.BOLD,20);

	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu("저 장(S)");
	int x= 0;
	int y= 0;
	Back back = new Back();
	String subject = "";
	

	String[][] time_table = 
   { {" "," "," "," "," "},
	{" "," "," "," "," "},
	{" "," "," "," "," "},
	{" "," "," "," "," "},
	{" "," "," "," "," "},
	{" "," "," "," "," "},
	{" "," "," "," "," "},
	{" "," "," "," "," "},
	{" "," "," "," "," "}};
	
	
	JLabel l0_0 = new JLabel(" ");
	JLabel l0_1 = new JLabel(" ");
	JLabel l0_2 = new JLabel(" ");
	JLabel l0_3 = new JLabel(" ");
	JLabel l0_4 = new JLabel(" ");
	
	JLabel l1_0 = new JLabel(" ");
	JLabel l1_1 = new JLabel(" ");
	JLabel l1_2 = new JLabel(" ");
	JLabel l1_3 = new JLabel(" ");
	JLabel l1_4 = new JLabel(" ");
	
	JLabel l2_0 = new JLabel(" ");
	JLabel l2_1 = new JLabel(" ");
	JLabel l2_2 = new JLabel(" ");
	JLabel l2_3 = new JLabel(" ");
	JLabel l2_4 = new JLabel(" ");
	
	JLabel l3_0 = new JLabel(" ");
	JLabel l3_1 = new JLabel(" ");
	JLabel l3_2 = new JLabel(" ");
	JLabel l3_3 = new JLabel(" ");
	JLabel l3_4 = new JLabel(" ");
	
	JLabel l4_0 = new JLabel(" ");
	JLabel l4_1 = new JLabel(" ");
	JLabel l4_2 = new JLabel(" ");
	JLabel l4_3 = new JLabel(" ");
	JLabel l4_4 = new JLabel(" ");
	
	JLabel l5_0 = new JLabel(" ");
	JLabel l5_1 = new JLabel(" ");
	JLabel l5_2 = new JLabel(" ");
	JLabel l5_3 = new JLabel(" ");
	JLabel l5_4 = new JLabel(" ");
	
	JLabel l6_0 = new JLabel(" ");
	JLabel l6_1 = new JLabel(" ");
	JLabel l6_2 = new JLabel(" ");
	JLabel l6_3 = new JLabel(" ");
	JLabel l6_4 = new JLabel(" ");
	
	JLabel l7_0 = new JLabel(" ");
	JLabel l7_1 = new JLabel(" ");
	JLabel l7_2 = new JLabel(" ");
	JLabel l7_3 = new JLabel(" ");
	JLabel l7_4 = new JLabel(" ");
	JMenuItem menuitem = new JMenuItem("저장 하기",KeyEvent.VK_T);

	public void file_call(){
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("data\\tabledata.txt"));
	        for(int i=0; i<8; i++)
	        	for(int j=0; j<5; j++)
	        		time_table[i][j] = in.readLine();
	        in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void file_save(){
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("data\\tabledata.txt"));
	        for(String i[] : time_table)
	            for(String j : i){
	            		out.write(j);
	            		out.newLine();
	            }
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public TimeTable() {
		setSize(650, 860);
		file_call();
		System.out.println();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		bar.setBounds(0, 0, 650, 30);
		bar.setBorder(null);
		bar.setOpaque(false);
		back.setLayout(null);
		back.addMouseListener(this);
		bar.setLayout(null);
		
		menu.setBounds(0, 0, 65, 30);
		menuitem.setFont(fontH);
		menuitem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		menuitem.getAccessibleContext().setAccessibleDescription("아무일도 없음");
		menuitem.addActionListener(this);
		menu.add(menuitem);
		menu.setFont(fontH);
		menu.setMnemonic(KeyEvent.VK_A);//니모닉부여
		menu.getAccessibleContext().setAccessibleDescription("메뉴아이템을 가지는 메뉴");
		bar.add(menu);
		back.add(bar);
		
		l0_0.setFont(font2);		
		l0_0.setText(time_table[0][0]);
		l0_0.setBounds(130, 210, 100, 20);
		l0_0.setForeground(Color.YELLOW);
		back.add(l0_0);
		
		l1_0.setFont(font2);
		l1_0.setText(time_table[1][0]);
		l1_0.setBounds(130, 280, 100, 20);
		l1_0.setForeground(Color.YELLOW);
		back.add(l1_0);
		
		
		l2_0.setBounds(130, 360, 100, 20);
		l2_0.setForeground(Color.YELLOW);
		l2_0.setFont(font2);
		l2_0.setText(time_table[2][0]);
		back.add(l2_0);
		
	
		l3_0.setBounds(130, 430, 100, 20);
		l3_0.setForeground(Color.YELLOW);
		l3_0.setFont(font2);
		l3_0.setText(time_table[3][0]);
		back.add(l3_0);
		
		l4_0.setBounds(130, 510, 100, 20);
		l4_0.setForeground(Color.YELLOW);
		l4_0.setFont(font2);
		l4_0.setText(time_table[4][0]);
		back.add(l4_0);
		
		l5_0.setBounds(130, 590, 100, 20);
		l5_0.setForeground(Color.YELLOW);
		l5_0.setFont(font2);
		l5_0.setText(time_table[5][0]);
		back.add(l5_0);
		
		l6_0.setBounds(130, 670, 100, 20);
		l6_0.setForeground(Color.YELLOW);
		l6_0.setFont(font2);
		l6_0.setText(time_table[6][0]);
		back.add(l6_0);
		
		l7_0.setBounds(130, 740, 100, 20);
		l7_0.setForeground(Color.YELLOW);
		l7_0.setFont(font2);
		l7_0.setText(time_table[7][0]);
		back.add(l7_0);
		
		
		
		l0_1.setBounds(220, 210, 100, 20);
		l0_1.setForeground(Color.YELLOW);
		l0_1.setFont(font2);
		l0_1.setText(time_table[0][1]);
		back.add(l0_1);
		
		l1_1.setBounds(220, 280, 100, 20);
		l1_1.setForeground(Color.YELLOW);
		l1_1.setFont(font2);
		l1_1.setText(time_table[1][1]);
		back.add(l1_1);
		
		
		l2_1.setFont(font2);
		l2_1.setBounds(220, 360, 100, 20);
		l2_1.setForeground(Color.YELLOW);
		l2_1.setText(time_table[2][1]);
		back.add(l2_1);
		
		l3_1.setFont(font2);
		l3_1.setBounds(220, 430, 100, 20);
		l3_1.setForeground(Color.YELLOW);
		l3_1.setText(time_table[3][1]);
		back.add(l3_1);
		
		l4_1.setFont(font2);
		l4_1.setBounds(220, 510, 100, 20);
		l4_1.setForeground(Color.YELLOW);
		l4_1.setText(time_table[4][1]);
		back.add(l4_1);
		
		
		l5_1.setFont(font2);
		l5_1.setBounds(220, 590, 100, 20);
		l5_1.setForeground(Color.YELLOW);
		l5_1.setText(time_table[5][1]);
		back.add(l5_1);
		
		l6_1.setFont(font2);
		l6_1.setBounds(220, 670, 100, 20);
		l6_1.setForeground(Color.YELLOW);
		l6_1.setText(time_table[6][1]);
		back.add(l6_1);

		l7_1.setFont(font2);
		l7_1.setBounds(220, 740, 100, 20);
		l7_1.setForeground(Color.YELLOW);
		l7_1.setText(time_table[7][1]);
		back.add(l7_1);
		
		l0_2.setFont(font2);
		l0_2.setBounds(320, 210, 100, 20);
		l0_2.setForeground(Color.YELLOW);
		l0_2.setText(time_table[0][2]);
		back.add(l0_2);
		
		
		l1_2.setFont(font2);
		l1_2.setBounds(320, 280, 100, 20);
		l1_2.setForeground(Color.YELLOW);
		l1_2.setText(time_table[1][2]);
		back.add(l1_2);
		
		
		l2_2.setFont(font2);
		l2_2.setBounds(320, 360, 100, 20);
		l2_2.setForeground(Color.YELLOW);
		l2_2.setText(time_table[2][2]);
		back.add(l2_2);
		
		l3_2.setFont(font2);
		l3_2.setBounds(320, 430, 100, 20);
		l3_2.setForeground(Color.YELLOW);
		l3_2.setText(time_table[3][2]);
		back.add(l3_2);
		
		l4_2.setFont(font2);
		l4_2.setBounds(320, 510, 100, 20);
		l4_2.setForeground(Color.YELLOW);
		l4_2.setText(time_table[4][2]);
		back.add(l4_2);
		
		l5_2.setFont(font2);
		l5_2.setBounds(320, 590, 100, 20);
		l5_2.setForeground(Color.YELLOW);
		l5_2.setText(time_table[5][2]);
		back.add(l5_2);
		
		l6_2.setFont(font2);
		l6_2.setBounds(320, 670, 100, 20);
		l6_2.setForeground(Color.YELLOW);
		l6_2.setText(time_table[6][2]);
		back.add(l6_2);
		
		l7_2.setFont(font2);
		l7_2.setBounds(320, 740, 100, 20);
		l7_2.setForeground(Color.YELLOW);
		l7_2.setText(time_table[7][2]);
		back.add(l7_2);
		
		l0_3.setFont(font2);
		l0_3.setBounds(420, 210, 100, 20);
		l0_3.setForeground(Color.YELLOW);
		l0_3.setText(time_table[0][3]);
		back.add(l0_3);
		
		
		l1_3.setBounds(420, 280, 100, 20);
		l1_3.setForeground(Color.YELLOW);
		l1_3.setFont(font2);
		l1_3.setText(time_table[1][3]);
		back.add(l1_3);
		
		l2_3.setBounds(420, 360, 100, 20);
		l2_3.setForeground(Color.YELLOW);
		l2_3.setFont(font2);
		l2_3.setText(time_table[2][3]);
		back.add(l2_3);
		
		l3_3.setBounds(420, 430, 100, 20);
		l3_3.setForeground(Color.YELLOW);
		l3_3.setFont(font2);
		l3_3.setText(time_table[3][3]);
		back.add(l3_3);
		
		l4_3.setBounds(420, 510, 100, 20);
		l4_3.setForeground(Color.YELLOW);
		l4_3.setFont(font2);
		l4_3.setText(time_table[4][3]);
		back.add(l4_3);
		
		l5_3.setBounds(420, 590, 100, 20);
		l5_3.setForeground(Color.YELLOW);
		l5_3.setFont(font2);
		l5_3.setText(time_table[5][3]);
		back.add(l5_3);
		
		l6_3.setBounds(420, 670, 100, 20);
		l6_3.setForeground(Color.YELLOW);
		l6_3.setFont(font2);
		l6_3.setText(time_table[6][3]);
		back.add(l6_3);
		
		l7_3.setBounds(420, 740, 100, 20);
		l7_3.setForeground(Color.YELLOW);
		l7_3.setFont(font2);
		l7_3.setText(time_table[7][3]);
		back.add(l7_3);
		
		
		l0_4.setBounds(520, 210, 100, 20);
		l0_4.setForeground(Color.YELLOW);
		l0_4.setFont(font2);
		l0_4.setText(time_table[0][4]);
		back.add(l0_4);
		
		l1_4.setBounds(520, 280, 100, 20);
		l1_4.setForeground(Color.YELLOW);
		l1_4.setFont(font2);
		l1_4.setText(time_table[1][4]);
		back.add(l1_4);
		
		l2_4.setBounds(520, 360, 100, 20);
		l2_4.setForeground(Color.YELLOW);
		l2_4.setFont(font2);
		l2_4.setText(time_table[2][4]);
		back.add(l2_4);
		
		l3_4.setBounds(520, 430, 100, 20);
		l3_4.setForeground(Color.YELLOW);
		l3_4.setFont(font2);
		l3_4.setText(time_table[3][4]);
		back.add(l3_4);
		
		l4_4.setBounds(520, 510, 100, 20);
		l4_4.setForeground(Color.YELLOW);
		l4_4.setFont(font2);
		l4_4.setText(time_table[4][4]);
		back.add(l4_4);
		
		l5_4.setBounds(520, 590, 100, 20);
		l5_4.setForeground(Color.YELLOW);
		l5_4.setFont(font2);
		l5_4.setText(time_table[5][4]);
		back.add(l5_4);
		
		l6_4.setBounds(520, 670, 100, 20);
		l6_4.setForeground(Color.YELLOW);
		l6_4.setFont(font2);
		l6_4.setText(time_table[6][4]);
		back.add(l6_4);
		
		l7_4.setBounds(520, 740, 100, 20);
		l7_4.setForeground(Color.YELLOW);
		l7_4.setText(time_table[7][4]);
		l7_4.setFont(font2);
		back.add(l7_4);

		add(back);	
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuitem){
			new Message("저장 되었습니다");
			file_save();
			setVisible(false);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (125 <= e.getX() && e.getX() <= 568 && 190 <= e.getY() && e.getY() <= 763){
			new Change_text();
			x = e.getX();
			y = e.getY();
		}
		
		

		System.out.println(e.getX());
		System.out.println(e.getY());
	}

	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	
	class Message extends JFrame{
		
		Color color = new Color(120,205,209);
		Color color1 = new Color(255,255,255);
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		
		public Message(String name){
		
		setSize(250,150);
		setLocationRelativeTo(null);
		panel.setLayout(null);
		label.setText(name);
		label.setFont(fontH1);
		label.setBounds(55, 40, 200, 30);
		panel.add(label);
		panel.setBackground(Color.white);
		add(panel);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		}
		
	}
	
	class Change_text extends JFrame implements ActionListener {
		JTextField jt = new JTextField(20);
		JLabel jl = new JLabel("과목을 입력하세요");
		Font font1 = new Font("Dotum", Font.BOLD, 13);
		Font font2 = new Font("한컴 윤체 B", Font.BOLD, 13);
		Font font3 = new Font("한컴 윤체 B", Font.BOLD, 9);

		JButton b1 = new JButton("확인");

		public Change_text() {
			setSize(200, 150);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setLocationRelativeTo(null);
			setLayout(null);

			jt.setBounds(25, 50, 150, 25);
			jt.setFont(font1);
			jt.addActionListener(this);
			add(jt);

			jl.setBounds(45, 10, 150, 20);
			jl.setFont(font1);
			add(jl);
			b1.setBounds(70, 85, 60, 30);
			b1.addActionListener(this);
			add(b1);

			setResizable(false);
			setVisible(true);
		}
		
		public void actionPerformed(ActionEvent e) {
		
				

				if(jt.getText().length() == 1)
					subject = "     "+jt.getText();
				if(jt.getText().length() == 2)
					subject = "    "+jt.getText();
				if(jt.getText().length() == 3)
				subject = "   "+jt.getText();
				if(jt.getText().length() == 4)
					subject = "  "+jt.getText();
				if(jt.getText().length() == 5)
					subject =" "+jt.getText();
				if(jt.getText().length() == 6)
					subject =jt.getText();
				if(jt.getText().length() >= 6)
					subject =jt.getText();
			
				
				if(x >=125 && x <= 224 && y >= 193 && y <= 240){
					if(subject.length() > 6)
						l0_0.setFont(font3);
					else
						l0_0.setFont(font2);
					l0_0.setText(subject);
					time_table[0][0] = subject;
				}
				if(x >=213 && x <= 300 && y >= 193 && y <= 240){
					if(subject.length() > 6)
						l0_1.setFont(font3);
					else
						l0_1.setFont(font2);
					l0_1.setText(subject);
					time_table[0][1] = subject;
					}
				if(x >=313 && x <= 397 && y >= 193 && y <= 240){
					if(subject.length() > 6)
						l0_2.setFont(font3);
					else
						l0_2.setFont(font2);
					l0_2.setText(subject);
					time_table[0][2] = subject;
					}
				if(x >=412 && x <= 500 && y >= 193 && y <= 240){
					if(subject.length() > 6)
						l0_3.setFont(font3);
					else
						l0_3.setFont(font2);
					l0_3.setText(subject);
					time_table[0][3] = subject;
				}
				if(x >=513 && x <= 600 && y >= 193 && y <= 240){
					if(subject.length() > 6)
						l0_4.setFont(font3);
					else
						l0_4.setFont(font2);
					l0_4.setText(subject);
					time_table[0][4] = subject;
					}
				
				////////////////////////////////////////////////////// 첫번째줄
				if(x >=122 && x <= 203 && y >= 255 && y <= 317){
					if(subject.length() > 6)
						l1_0.setFont(font3);
					else
						l1_0.setFont(font2);
					l1_0.setText(subject);
					time_table[1][0] = subject;
				}
				if(x >=215 && x <= 300 && y >= 255 && y <= 319){
					if(subject.length() > 6)
						l1_1.setFont(font3);
					else
						l1_1.setFont(font2);
					l1_1.setText(subject);
					time_table[1][1] = subject;
					}
				if(x >=313 && x <= 400 && y >= 255 && y <= 320){
					if(subject.length() > 6)
						l1_2.setFont(font3);
					else
						l1_2.setFont(font2);
					l1_2.setText(subject);
					time_table[1][2] = subject;
				}
				if(x >=413 && x <= 500 && y >= 255 && y <= 320){
					if(subject.length() > 6)
						l1_3.setFont(font3);
					else
						l1_3.setFont(font2);
					l1_3.setText(subject);
					time_table[1][3] = subject;
					}
				if(x >=515 && x <= 600 && y >= 255 && y <= 320){
					if(subject.length() > 6)
						l1_4.setFont(font3);
					else
						l1_4.setFont(font2);
					l1_4.setText(subject);
					time_table[1][4] = subject;
				}
				///////////////////////////////////////////////////////////////////두번째줄
				
				
				if(x >=123 && x <= 200 && y >= 331 && y <= 392){
					if(subject.length() > 6)
						l2_0.setFont(font3);
					else
						l2_0.setFont(font2);
					l2_0.setText(subject);
					time_table[2][0] = subject;
					}
				if(x >=215 && x <= 300 && y >= 333 && y <= 399){
					if(subject.length() > 6)
						l2_1.setFont(font3);
					else
						l2_1.setFont(font2);
					l2_1.setText(subject);
					time_table[2][1] = subject;
				}
				if(x >=313 && x <= 400 && y >= 333 && y <= 399){
					if(subject.length() > 6)
						l2_2.setFont(font3);
					else
						l2_2.setFont(font2);
					l2_2.setText(subject);
					time_table[2][2] = subject;
					}
				if(x >=415 && x <= 500 && y >= 333 && y <= 399){
					if(subject.length() > 6)
						l2_3.setFont(font3);
					else
						l2_3.setFont(font2);
					l2_3.setText(subject);
					time_table[2][3] = subject;
				}
				if(x >=513 && x <= 600 && y >= 333 && y <= 399){
					if(subject.length() > 6)
						l2_4.setFont(font3);
					else
						l2_4.setFont(font2);
					l2_4.setText(subject);
					time_table[2][4] = subject;
					}
				
				////////////////////////////////////////////////////////////////////세번째줄
				
				if(x >=125 && x <= 200 && y >= 411 && y <= 473){
					if(subject.length() > 6)
						l3_0.setFont(font3);
					else
						l3_0.setFont(font2);
					l3_0.setText(subject);
					time_table[3][0] = subject;
				}
				if(x >=213 && x <= 300 && y >= 411 && y <= 473){
					if(subject.length() > 6)
						l3_1.setFont(font3);
					else
						l3_1.setFont(font2);
					l3_1.setText(subject);
					time_table[3][1] = subject;
					}
				if(x >=315 && x <= 400 && y >= 411 && y <= 473){
					if(subject.length() > 6)
						l3_2.setFont(font3);
					else
						l3_2.setFont(font2);
					l3_2.setText(subject);
					time_table[3][2] = subject;

				}
				if(x >=413 && x <= 500 && y >= 411 && y <= 473){
					if(subject.length() > 6)
						l3_3.setFont(font3);
					else
						l3_3.setFont(font2);
					l3_3.setText(subject);
					time_table[3][3] = subject;

					}
				if(x >=515 && x <= 600 && y >= 411 && y <= 473){
					if(subject.length() > 6)
						l3_4.setFont(font3);
					else
						l3_4.setFont(font2);
					l3_4.setText(subject);
					time_table[3][4] = subject;

				}
				/////////////////////////////////////////////////////////////4번째줄
				if(x >=123 && x <= 200 && y >= 493 && y <= 554){
					if(subject.length() > 6)
						l4_0.setFont(font3);
					else
						l4_0.setFont(font2);
					l4_0.setText(subject);
					time_table[4][0] = subject;

					}
				if(x >=215 && x <= 300 && y >= 493 && y <= 554){
					if(subject.length() > 6)
						l4_1.setFont(font3);
					else
						l4_1.setFont(font2);
					l4_1.setText(subject);
					time_table[4][1] = subject;
				}
				if(x >=313 && x <= 400 && y >= 493 && y <= 554){
					if(subject.length() > 6)
						l4_2.setFont(font3);
					else
						l4_2.setFont(font2);
					l4_2.setText(subject);
					time_table[4][2] = subject;

					}
				if(x >=415 && x <= 500 && y >= 493 && y <= 554){
					if(subject.length() > 6)
						l4_3.setFont(font3);
					else
						l4_3.setFont(font2);
					l4_3.setText(subject);
					time_table[4][3] = subject;

				}
				if(x >=513 && x <= 600 && y >= 493 && y <= 554){
					if(subject.length() > 6)
						l4_4.setFont(font3);
					else
						l4_4.setFont(font2);
					l4_4.setText(subject);
					time_table[4][4] = subject;

					}
				///////////////////////////////////////////////////////////////////5번째줄
				if(x >=125 && x <= 200 && y >= 567 && y <= 628){
					if(subject.length() > 6)
						l5_0.setFont(font3);
					else
						l5_0.setFont(font2);
					l5_0.setText(subject);
					time_table[5][0] = subject;

				}
				
				if(x >=213 && x <= 300 && y >= 567 && y <= 628){
					if(subject.length() > 6)
						l5_1.setFont(font3);
					else
						l5_1.setFont(font2);
					l5_1.setText(subject);
					time_table[5][1] = subject;

					}
				if(x >=315 && x <= 400 && y >= 567 && y <= 628){
					if(subject.length() > 6)
						l5_2.setFont(font3);
					else
						l5_2.setFont(font2);
					l5_2.setText(subject);
					time_table[5][2] = subject;

				}
				if(x >=413 && x <= 500 && y >= 567 && y <= 628){
					if(subject.length() > 6)
						l5_3.setFont(font3);
					else
						l5_3.setFont(font2);
					l5_3.setText(subject);
					time_table[5][3] = subject;

					}
				if(x >=515 && x <= 600 && y >= 567 && y <= 628){
					if(subject.length() > 6)
						l5_4.setFont(font3);
					else
						l5_4.setFont(font2);
					l5_4.setText(subject);
					time_table[5][4] = subject;

				}
				////////////////////////////////////////////////////////////여섯번째줄
				
				
				if(x >=123 && x <= 200 && y >= 642 && y <= 705){
					if(subject.length() > 6)
						l6_0.setFont(font3);
					else
						l6_0.setFont(font2);
					l6_0.setText(subject);
					time_table[6][0] = subject;

					}
				if(x >=215 && x <= 300 && y >= 642 && y <= 705){
					if(subject.length() > 6)
						l6_1.setFont(font3);
					else
						l6_1.setFont(font2);
					l6_1.setText(subject);
					time_table[6][1] = subject;
				}
				if(x >=313 && x <= 400 && y >= 642 && y <= 705){
					if(subject.length() > 6)
						l6_2.setFont(font3);
					else
						l6_2.setFont(font2);
					l6_2.setText(subject);
					time_table[6][2] = subject;
				}
				if(x >=413 && x <= 500 && y >= 642 && y <= 705){
					if(subject.length() > 6)
						l6_3.setFont(font3);
					else
						l6_3.setFont(font2);
					l6_3.setText(subject);
					time_table[6][3] = subject;
					}
				if(x >=525 && x <= 600 && y >= 642 && y <= 705){
					if(subject.length() > 6)
						l6_4.setFont(font3);
					else
						l6_4.setFont(font2);
					l6_4.setText(subject);
					time_table[6][4] = subject;
				}
				///////////////////////////////////////////////7번째줄
				
				if(x >=125 && x <= 200 && y >= 718 && y <= 770){
					if(subject.length() > 6)
						l7_0.setFont(font3);
					else
						l7_0.setFont(font2);
					l7_0.setText(subject);
					time_table[7][0] = subject;
				}
				if(x >=213 && x <= 300 && y >= 718 && y <= 770){
					if(subject.length() > 6)
						l7_1.setFont(font3);
					else
						l7_1.setFont(font2);
					l7_1.setText(subject);
					time_table[7][1] = subject;
					}
				if(x >=315 && x <= 400 && y >= 718 && y <= 770){
					if(subject.length() > 6)
						l7_2.setFont(font3);
					else
						l7_2.setFont(font2);
					l7_2.setText(subject);
					time_table[7][2] = subject;
				}
				if(x >=413 && x <= 500 && y >= 718 && y <= 770){
					if(subject.length() > 6)
						l7_3.setFont(font3);
					else
						l7_3.setFont(font2);
					l7_3.setText(subject);
					time_table[7][3] = subject;
					}
				if(x >=515 && x <= 600 && y >= 718 && y <= 770){
					if(subject.length() > 6)
						l7_4.setFont(font3);
					else
						l7_4.setFont(font2);
					l7_4.setText(subject);
					time_table[7][4] = subject;
				}
				
					
				setVisible(false);
		}
	}

	

}

class Back extends JPanel {

	public Back() {
	}

	ImageIcon backgroundImg = new ImageIcon("timetable.png");

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(backgroundImg.getImage(), 0, 0, null);
		setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
		super.paintComponent(g);
	}

}