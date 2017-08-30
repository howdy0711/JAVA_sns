package death;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CCNA extends JFrame implements ActionListener, MouseListener {

	JLabel l1 = new JLabel("기본 스위칭 개념과 구성");
	JLabel l2 = new JLabel("VLANs");
	JLabel l3 = new JLabel("라우팅 개념");
	JLabel l4 = new JLabel("Inter-VLAN 라우팅");
	JLabel l5 = new JLabel("정적 라우팅");
	JLabel l6 = new JLabel("동적 라우팅");
	JLabel l7 = new JLabel("Singl-Area OSPF");
	JLabel l8 = new JLabel("Acess Contol List");
	JLabel l9 = new JLabel("DHCP");
	JLabel l10 = new JLabel("NAT");
	JButton l11 = new JButton("시험보기");
	JLabel l12 = new JLabel("CCNA");

	Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
	Font font2 = new Font("맑은 고딕", Font.BOLD, 35);
	Color color = new Color(209, 239, 241);
	JPanel panel = new JPanel();
	JPanel CCNA_title = new JPanel();
    Color color2 = new Color(120,205,209);

	public CCNA() {
		setSize(500, 730);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		panel.setLayout(null);
		panel.setBackground(color);
		CCNA_title.setBackground(new Color(229, 255, 241));
		CCNA_title.setBounds(140, 10, 200, 70);
		CCNA_title.setLayout(null);
		l12.setBounds(45, 10, 150, 50);
		CCNA_title.add(l12);
		l12.setFont(font2);
		panel.add(CCNA_title);

		l1.setBounds(145, 100, 250, 30);
		l1.setFont(font1);
		panel.add(l1);

		l2.setBounds(145, 150, 250, 30);
		l2.setFont(font1);
		panel.add(l2);

		l3.setBounds(145, 200, 250, 30);
		l3.setFont(font1);
		panel.add(l3);

		l4.setBounds(145, 250, 250, 30);
		l4.setFont(font1);
		panel.add(l4);

		l5.setBounds(145, 300, 250, 30);
		l5.setFont(font1);
		panel.add(l5);

		l6.setBounds(145, 350, 250, 30);
		l6.setFont(font1);
		panel.add(l6);

		l7.setBounds(145, 400, 250, 30);
		l7.setFont(font1);
		panel.add(l7);

		l8.setBounds(145, 450, 250, 30);
		l8.setFont(font1);
		panel.add(l8);

		l9.setBounds(145, 500, 250, 30);
		l9.setFont(font1);
		panel.add(l9);

		l10.setBounds(145, 550, 250, 30);
		l10.setFont(font1);
		panel.add(l10);

		l11.setBounds(180, 650, 120, 30);
		l11.setFont(font1);
		l11.addActionListener(this);
		panel.add(l11);
		panel.addMouseListener(this);

		add(panel);

		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() >= 147 && e.getX() <= 332 && e.getY() >= 108
				&& e.getY() <= 120) {
			new CCNA_DATA("one");
		}
		if (e.getX() >= 147 && e.getX() <= 206 && e.getY() >= 157
				&& e.getY() <= 167) {
			new CCNA_DATA("two");
		}
		if (e.getX() >= 147 && e.getX() <= 232 && e.getY() >= 208
				&& e.getY() <= 221) {
			new CCNA_DATA("three");
		}
		if (e.getX() >= 147 && e.getX() <= 302 && e.getY() >= 258
				&& e.getY() <= 271) {
			new CCNA_DATA("four");
		}
		if (e.getX() >= 147 && e.getX() <= 234 && e.getY() >= 308
				&& e.getY() <= 320) {
			new CCNA_DATA("five");
		}
		if (e.getX() >= 147 && e.getX() <= 234 && e.getY() >= 355
				&& e.getY() <= 374) {
			new CCNA_DATA("six");
		}
		if (e.getX() >= 147 && e.getX() <= 302 && e.getY() >= 407
				&& e.getY() <= 421) {
			new CCNA_DATA("seven");
		}
		if (e.getX() >= 147 && e.getX() <= 306 && e.getY() >= 459
				&& e.getY() <= 488) {
			new CCNA_DATA("eight");
		}
		if (e.getX() >= 147 && e.getX() <= 198 && e.getY() >= 507
				&& e.getY() <= 519) {
			new CCNA_DATA("nine");
		}
		if (e.getX() >= 147 && e.getX() <= 182 && e.getY() >= 558
				&& e.getY() <= 569) {
			new CCNA_DATA("ten");
		}
	

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == l11) {
			new Test();
		}
	}
}


