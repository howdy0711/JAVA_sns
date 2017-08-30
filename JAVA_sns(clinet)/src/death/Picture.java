package death;

import java.awt.BasicStroke;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
 
class Picture extends JFrame implements ActionListener{
	
	Back back = new Back();
	JButton left_b = new JButton(new ImageIcon("left.png"));
	JButton right_b = new JButton(new ImageIcon("right.png"));
	JPanel jp = new JPanel();
	JPanel picture_panel[] = new JPanel[10];


	JMenuBar bar = new JMenuBar();
	JMenu menu = new JMenu("파 일(F)");
	JMenuItem menuitem1 = new JMenuItem(" 저장 하기  ",KeyEvent.VK_S);
	JMenuItem menuitem2 = new JMenuItem(" 사진 등록  ",KeyEvent.VK_E);
	
	CardLayout card = new CardLayout();
	Font fontH = new Font("한컴 윤체 B",Font.PLAIN,17);
	Font fontH1 = new Font("한컴 윤체 B",Font.PLAIN,14);
	Box_boader[] boader;
	ImageIcon[] img;
	int c = 5;
	Sajin sa[];
	Sajin sa1[];
	S_Sajin s_sa[];
	private int sajin_x = 120;
    public Picture() {
		setSize(1000,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		back.setLayout(null);
		
		for(int i =0; i<5; i++){
			picture_panel[i]= new JPanel(); //패널생성
		}
		sa = new Sajin[picture_panel.length];
		sa1 = new Sajin[picture_panel.length];
		s_sa = new S_Sajin[5]; ///사진을 불러옴 
		boader = new Box_boader[picture_panel.length];
		img = new ImageIcon[picture_panel.length];
		System.out.println("dddddd"+img.toString());

		///////////////////////////////////////////////////////////////메뉴바설정
		menu.add(menuitem1);
		menu.add(menuitem2);
		menu.setFont(fontH);
		menu.setForeground(Color.white);
		menu.setMnemonic(KeyEvent.VK_A);//니모닉부여
		menu.getAccessibleContext().setAccessibleDescription("메뉴아이템을 가지는 메뉴");
		
		menuitem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
		menuitem1.getAccessibleContext().setAccessibleDescription("아무일도 없음");
		
		menuitem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));
		menuitem2.getAccessibleContext().setAccessibleDescription("아무일도 없음");
		
		menuitem1.setFont(fontH1);
		menuitem2.setFont(fontH1);
		
		bar.setBackground(new Color(120,120,120));
		bar.setBorder(null);
		bar.setOpaque(false);
		bar.add(menu);
		bar.setBounds(0, 0, 1000, 30);
		////////////////////////////////////////////////////////////////메뉴바설정
		
		////////////////////////////////////////이미지 카드레이아웃
		jp.setBounds(195, 80, 600, 400);
		jp.setLayout(card);
		
		for(int i=0;i<10;i++){
			sa[i] = new Sajin(new ImageIcon("picture\\"+i+".jpg").getImage());
			}
		for(int i=0;i<10;i++){
			sa1[i] = new Sajin(new ImageIcon("picture\\"+i+".jpg").getImage());
			}
		
		for(int i= 0; i< 5; i ++)
		{
			picture_panel[i].setLayout(card);
			picture_panel[i].add(sa[i]);
			back.add(picture_panel[i]);
			picture_panel[i].setBounds(sajin_x, 520, 120, 100);
			sajin_x += 160;
		}
		int j=5;
		for(int i= 0; i< 5; i ++)
		{
			picture_panel[i].add(sa[j]);
			j++;
		}
		sajin_x =120;

		
		for(int i=0;i<picture_panel.length;i++){
			boader[i] = new Box_boader();
			boader[i].setBounds(sajin_x-10, 513, 140, 114);
			back.add(boader[i]);
			jp.add(sa1[i]);
			System.out.println(sajin_x);
			sajin_x += 160;
		}
		back.add(jp);
		for(int i=1;i<10;i++)
			boader[i].hide();

	
		left_b.setBounds(20,270,25,80);
		right_b.setBounds(940,270,25,80);
		left_b.addActionListener(this);
		right_b.addActionListener(this);

		back.add(bar);
		back.add(left_b);
		back.add(right_b);	
		add(back);
        setVisible(true);
    }
    
    int cnt = 0;
	public void actionPerformed(ActionEvent e) {
		System.out.println(cnt);
    	if(e.getSource() == left_b){
    		card.previous(jp);
    		cnt--;
    	}
    	if(e.getSource() == right_b){
    		card.next(jp);
    		cnt++;
    	}
    	
    	if(cnt % 5 == 0){    		
    		card.next(picture_panel[0]);
    		card.next(picture_panel[1]);
    		card.next(picture_panel[2]);
    		card.next(picture_panel[3]);
    		card.next(picture_panel[4]);
    		repaint();
    	}
    	
    	if(cnt % 5 == 0){
    		boader[0].show();
    		boader[0].setOpaque(false);
    		boader[2].hide();
    		boader[3].hide();
    		boader[4].hide();
    		boader[1].hide();
    	}
    	if(cnt % 5 == 1){
    		boader[0].hide();
    		boader[2].hide();
    		boader[3].hide();
    		boader[4].hide();
    		boader[1].show();
    		boader[1].setOpaque(false);
    	}
    	if(cnt % 5 == 2){
     		boader[0].hide();
    		boader[2].show();
    		boader[2].setOpaque(false);
    		boader[3].hide();
    		boader[4].hide();
    		boader[1].hide();
    	}
    	if(cnt % 5 == 3){
     		boader[0].hide();
    		boader[2].hide();
    		boader[3].show();
    		boader[3].setOpaque(false);
    		boader[4].hide();
    		boader[1].hide();
    	}
    	if(cnt % 5 == 4){
     		boader[0].hide();
    		boader[2].hide();
    		boader[3].hide();
    		boader[4].show();
    		boader[4].setOpaque(false);
    		boader[1].hide();
    	}
	}
    
    
    class Back extends JPanel {

    	public Back() {
    	}
    	ImageIcon backgroundImg = new ImageIcon("background.jpg");
    	@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		g.drawImage(backgroundImg.getImage(), 0, 0, null);
    		setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
    	}

    }
    
    
    class Sajin extends JPanel {
    	Image image;
    	public Sajin(Image image) {
    		this.image = image;
    		
    	}
    
    	@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		g.drawImage(this.image,0,0,this.getWidth(),this.getHeight(),this);
    		setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
    	}

    }
    
    class S_Sajin extends JPanel {
    	Image image;
    	public S_Sajin(Image image) {
    		this.image = image;
    		
    	}
    
    	@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		g.drawImage(this.image,0,0,this.getWidth(),this.getHeight(),this);
    		setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
    	}

    }

    class Box_boader extends JPanel {
    
    	@Override
    	public void paintComponent(Graphics g) {
    		super.paintComponent(g);
    		Graphics2D g2d = (Graphics2D)g;
    		g2d.setStroke(new BasicStroke(10));
    		g2d.setColor(Color.white);
    		g2d.drawRect(0, 0, 140, 114);
    		setOpaque(false);
    	}

    }
	
}
 
