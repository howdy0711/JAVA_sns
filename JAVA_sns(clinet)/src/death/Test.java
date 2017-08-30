package death;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Test extends JFrame implements ActionListener, ItemListener {

	CardLayout card = new CardLayout();
	JPanel p1 = new JPanel();
	JLabel l1 = new JLabel("CCNA TEST");

	Font font1 = new Font("한컴 윤체 B", Font.BOLD, 25);
	Font font2 = new Font("한컴 윤체 B", Font.BOLD, 20);
	Font font3 = new Font("한컴 윤체 B", Font.PLAIN, 16);

	JButton b1 = new JButton(new ImageIcon("back.jpg"));
	JButton b2 = new JButton(new ImageIcon("forward.jpg"));

	JPanel boss = new JPanel();

	JPanel[] jp = new JPanel[13];
	JLabel l11;
	JRadioButton rb1, rb2, rb3, rb4;
	ButtonGroup group = new ButtonGroup();

	public void call_Question(int i) {
		jp[i] = new JPanel();
		jp[i].setLayout(null);
		Font font2 = new Font("한컴 윤체 B", Font.BOLD, 20);
		Font font3 = new Font("한컴 윤체 B", Font.PLAIN, 16);

		group.add(rb1);
		group.add(rb2);
		group.add(rb3);
		group.add(rb4);

		try {
			BufferedReader in = new BufferedReader(new FileReader(
					"C:\\Users\\gom\\Documents\\문제\\" + i + ".txt"));
			ArrayList<String> ar = new ArrayList<>();
			String line;
			while ((line = in.readLine()) != null) {
				ar.add(line);
			}

			jp[i].setLayout(null);

			l11 = new JLabel(ar.get(0));
			rb1 = new JRadioButton(ar.get(1));
			rb2 = new JRadioButton(ar.get(2));
			rb3 = new JRadioButton(ar.get(3));
			rb4 = new JRadioButton(ar.get(4));

			rb1.addItemListener(new SelectItemListener());
			rb2.addItemListener(new SelectItemListener());
			rb3.addItemListener(new SelectItemListener());
			rb4.addItemListener(new SelectItemListener());

			// 문제
			l11.setBounds(0, 0, 750, 100);
			l11.setFont(font2);
			jp[i].add(l11);

			// 라디오버튼
			rb1.setBounds(0, 100, 750, 20);
			rb1.setFont(font3);
			jp[i].add(rb1);

			rb2.setBounds(0, 140, 750, 20);
			rb2.setFont(font3);
			jp[i].add(rb2);

			rb3.setBounds(0, 180, 750, 20);
			rb3.setFont(font3);
			jp[i].add(rb3);

			rb4.setBounds(0, 220, 750, 20);
			rb4.setFont(font3);
			jp[i].add(rb4);
			boss.add(jp[i]);

			if (in != null)
				in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public Test() {
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		// 파랑줄
		p1.setBackground(new Color(120, 205, 231));
		p1.setBounds(0, 50, 800, 15);
		// 시험이름
		l1.setBounds(200, 0, 400, 50);
		l1.setFont(font1);

		boss.setLayout(card);
		for (int i = 0; i < 13; i++)
			call_Question(i);

		boss.setBounds(30, 120, 700, 300);
		add(boss);

		// 앞으로가기버튼
		b1.setBounds(600, 430, 80, 80);
		b1.addActionListener(this);

		add(b1);

		// 뒤로가기버튼
		b2.setBounds(400, 430, 80, 80);
		b2.addActionListener(this);
		add(b2);

		// 질문 패널
		add(l1);
		add(p1);

		setVisible(true);
	}

	int count = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1 ) { // 앞으로가기버튼
			card.next(boss);
			count++;
		}
		if (e.getSource() == b2) { // 뒤로가기버튼
			card.previous(boss);
			count--;
		}
		if (count == 13) {
			ArrayList<String> arr= new ArrayList<>();
			int cnt = 0;
			int i= 0;
			double avg =0 ;
			String line;
			try {
				BufferedReader input = new BufferedReader(new FileReader("C:\\Users\\gom\\Documents\\문제\\정답.txt"));
				while ((line = input.readLine()) != null) {
					arr.add(line);
				}
				for(int j=0;j<arr.size();j++){
					if( arr.get(j).equals(goal.get(j)) ){
						cnt++;
					}
					
				}
	
				avg = (cnt/13.0) * 100.0;
				
				new Message(""+(int)avg);
				this.setVisible(false);
				
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	ArrayList<String> goal = new ArrayList<String>();

	class SelectItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			AbstractButton sel = (AbstractButton) e.getItemSelectable();
			if (e.getStateChange() == ItemEvent.SELECTED ) {
				goal.add(sel.getText());
			}
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}
	
	class Message extends JFrame{
		
		
		Color color = new Color(120,205,209);
		Color color1 = new Color(255,255,255);
		JPanel panel = new JPanel();
		JLabel label = new JLabel();
		JLabel label2 = new JLabel();
		
		public Message(String name){
		
		setSize(300,200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel.setLayout(null);
		label.setBounds(95, 80, 150, 30);
		label.setText("성적 : "+name+"점");
		label.setFont(font2);
		label2.setFont(font2);
		label2.setBounds(80,30,150,30);
		label2.setText("수고하셨습니다.");
		
		panel.add(label2);
		panel.add(label);
		panel.setBackground(Color.white);
		add(panel);
		setResizable(false);
		setVisible(true);
		}
		
	}

}
