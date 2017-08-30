package death;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

class Madang extends JFrame implements ActionListener,
MouseListener,MouseMotionListener {
   MyPanel my;
   Profile profile;
   DataInputStream dis;
   DataOutputStream dos;
   static String id;
   int flag = 0;
   //버튼들
   JButton profile_b = new JButton(new ImageIcon("profile_b.png"));
   JButton study_b = new JButton(new ImageIcon("study_b.png"));
   JButton picture_b = new JButton(new ImageIcon("picture_b.png"));
   JButton birthday_b = new JButton(new ImageIcon("b_2.png"));   
   JButton go_b = new JButton(new ImageIcon("go_b.png"));
   JButton camera_b = new JButton(new ImageIcon("camera_b.png"));
   JButton file_b = new JButton(new ImageIcon("file_b.png"));
   JButton friend_b = new JButton(new ImageIcon("friend_b.png"));
   
   JPanel notice_p = new JPanel();
   JLabel notice_l1;
   JLabel notice_l2;
   JLabel notice_l3;
   
   int notice1X = 0;
   int notice2X = 400; 
   int notice3X = 800;
   
   JButton left_b = new JButton(new ImageIcon("뒤로가기.png"));
   JButton right_b = new JButton(new ImageIcon("앞으로가기.png"));
   
   ArrayList<Friend_back> fb_arraylist = new ArrayList<Madang.Friend_back>();
   Friend_back fb1 = new Friend_back(new ImageIcon("예쁜여자1.jpg").getImage(), "haha1234");
   Friend_back fb = new Friend_back(new ImageIcon("예쁜여자1.jpg").getImage(), "haha1234");
   Image img = new ImageIcon("파퀴아오.jpg").getImage();
   Image img1[];
   Small_album small_al = new Small_album(img, img, img, img, img, img, img, img);
   JPanel f_list_panel = new JPanel();
   
  
   
   static String idlist[];
   JPanel timelineCard_panel;
   CardLayout card = new CardLayout();
   //친구버튼
   JPanel f1 = new JPanel();
   
   //폰트
   Font font1 = new Font("맑은 고딕",Font.BOLD,13);
   Font font2 = new Font("맑은 고딕",Font.BOLD,16);
   Font font3 = new Font("맑은 고딕",Font.BOLD,12);

   //텍스트필드
   JTextArea timeline_text = new JTextArea();
   JScrollPane jb = new JScrollPane(timeline_text);
   static Chat[] chat;
   static Map<String,Chat> chatlist = new HashMap<String,Chat>();
   JLabel card_total = new JLabel();

   
   //친구목록 뒤 패널
   JPanel friend_list_back = new JPanel();
   
   //친구 접속 비접속 체크
   static Friend_check[] f_check;
   Thread t;
   private int f_y = 153;
   
   Image timeline_img = null;
   String path_img;
  
   static String notice;
   
   
	public void file_call(){
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("C:\\Users\\gom\\Documents\\data\\notice.txt"));
				notice = in.readLine();
				System.out.println(notice);
			
	        in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private JFileChooser select = new JFileChooser();
   public Madang(DataInputStream dis,DataOutputStream dos,String id,String idlist[]){
	   
	  try {
			
		    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    SwingUtilities.updateComponentTreeUI(select);
		} catch (Exception ex) {
		    // LookAndFeel 설정 실패
		    ex.printStackTrace();
		}
	   
	   
	   
	   setTitle("우리마당");
	 
	  this.idlist = idlist;
	  chat = new Chat[idlist.length];
      this.id = id;
      this.dis=dis;
      this.dos=dos;
      
      f_check = new Friend_check[chat.length];
      for(int i = 0; i<chat.length; i++)
      {
    	  System.out.println(idlist[i]);
    	  chat[i] = new Chat(idlist[i]);
    	  chatlist.put(idlist[i], chat[i]);
      }
      
  
      file_call(); //공지사항 파일로 불러서 바꿈
      notice_l1 = new JLabel(notice);
      notice_l2 = new JLabel(notice);
      notice_l3 = new JLabel(notice);	       
 

      
      try {
		new LoadChat(id);
	} catch (IOException e) {
		System.out.println("메세지 온게 없어유");
	}
      Image img1[] = new Image[8];
     
      img1[0] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\0.jpg").getImage();
      img1[1] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\1.jpg").getImage();
      img1[2] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\2.jpg").getImage();
      img1[3] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\3.jpg").getImage();
      img1[4] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\4.jpg").getImage();
      img1[5] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\5.jpg").getImage();
      img1[6] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\6.jpg").getImage();
      img1[7] = new ImageIcon("C:\\Users\\gom\\Documents\\picture\\7.jpg").getImage();
      
      	
      small_al = new Small_album(img1[0], img1[1], img1[2], img1[3], img1[4], img1[5], img1[6], img1[7]);

      
      
      //this.id=id;

      ///array_list 기본 크기세팅
      //for(int i=0; i<30; i++)
      //   fb_arraylist.add(fb1);
       
      setSize(1280,750);
      my = new MyPanel();
      profile = new Profile();
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);
      my.setLayout(null);
      my.addMouseListener(this);
      
      timelineCard_panel = new JPanel();
      timelineCard_panel.setBounds(370, 215, 502, 400);
      timelineCard_panel.setLayout(card);
      timelineCard_panel.setBackground(Color.white);
      card_total.setBounds(592, 650, 100, 20);
      card_total.setFont(font2);
      add(card_total);
      my.add(timelineCard_panel);
      
      for(int i=0; i<chat.length; i++){
    	  f_check[i] = new Friend_check();
	      f_check[i].setBounds(1080, f_y, 10, 10);
	      f_check[i].setBackground(Color.green);
	      my.add(f_check[i]);
	      f_y += 40;
      }
      	t = new Thread(f_check[0]);
      	t.start();
      
      

      
      profile.setBounds(134, 100, 200, 158);
      my.add(profile);
      new MyThread().start();

      notice_p.setBounds(415, 13, 400, 25);
      notice_p.setLayout(null);
      notice_p.setOpaque(false);
      
      notice_l1.setFont(font2);
      notice_l1.setBounds(notice1X, 13, 400, 25);
      notice_l1.setForeground(Color.WHITE);

      notice_l2.setFont(font2);
      notice_l2.setBounds(notice2X, 13, 400, 25);
      notice_l2.setForeground(Color.WHITE);
      
      notice_l3.setFont(font2);
      notice_l3.setBounds(notice3X, 13, 400, 25);
      notice_l3.setForeground(Color.WHITE);
      
      notice_p.add(notice_l1);
      notice_p.add(notice_l2);
      notice_p.add(notice_l3);
      
      my.add(notice_p);
      
      
      //프로필 버튼.
      profile_b.setBounds(134, 260, 200, 39);
      profile_b.addActionListener(this);
      my.add(profile_b);
      
      //공부하기 버튼.
      study_b.setBounds(134, 315, 200, 44);
      study_b.addActionListener(this);
      my.add(study_b);
      
      //앨범 버튼.
      picture_b.setBounds(134, 375, 200, 39);
      picture_b.addActionListener(this);
      my.add(picture_b);
      
      small_al.setBounds(134,425,200,120);
      my.add(small_al);
      
      //다가오는일정버튼.
      birthday_b.setBounds(134, 545, 200, 39);
      birthday_b.addActionListener(this);
      my.add(birthday_b);
      
      //친구버튼.
      friend_b.setBounds(909, 100, 200, 39);
      my.add(friend_b);
      
     /* fb.setBounds(909, 140, 200, 39);
      fb.setBackground(Color.RED);
      fb.setOpaque(false);
      fb.addMouseListener(this);

      my.addMouseListener(this);
      my.add(fb);*/
      
      //게시버튼
      go_b.setBounds(825, 174, 40, 21);
      go_b.addActionListener(this);

      my.add(go_b);
      
      
      //텍스트필드 
      jb.setOpaque(true);
      jb.setBounds(371,100,500,69);
      jb.setBackground(Color.white);
      jb.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      jb.setFont(font1);
      timeline_text.addMouseListener(this);
//      timeline_text.addActionListener(this);
      my.add(jb);

      //카메라버튼
      camera_b.setBounds(372,169,36,30);
      camera_b.addActionListener(this);
      my.add(camera_b);
      camera_b.setBackground(Color.WHITE);
      
      //파일버튼
      file_b.setBounds(407,169,36,30);
      file_b.setBackground(Color.WHITE);
      file_b.addActionListener(this);
      
      //좌우 버튼
      left_b.setBounds(470,620,73,73);
      left_b.addActionListener(this);
      
      right_b.setBounds(670,620,73,73);
      right_b.addActionListener(this);
      
      for(int i = 0; i<idlist.length; i++)
      {
    	  getFriend(idlist[i]);
      }
      
      try {
		TLService.dos.writeInt(3);
		TLService.dos.flush();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
		
      
      my.add(left_b);      
      my.add(right_b);
      
      my.add(file_b);
      
      add(my);
      
      
      setVisible(true);
   }/////////////////////////////생성자

   ////////////////////////////////////////친구목록 on/off 체크
   public class Friend_check extends JPanel implements Runnable{
	   boolean flag = true;
	   public Friend_check() {
	}
	   @Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);


	}
	   public void on_off(int flag){
		   if(flag == 1)
			   this.setVisible(true);
		   else
			   this.setVisible(false);
	   }
	@Override
	public void run() 
	{
	 	
		while(flag)
		{
			
			try {
				DataBase.ConCheck();
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	   
}
   
   
   
   
   
   
   
   
   /////////////////////////////////////타임라인화면
   public class TimeLine1 extends JPanel{
	      
	      JLabel la1 = new JLabel();
	      JLabel la2 = new JLabel();
	   
	      Friend_face s_img;      
	      Friend_face b_img; 
	      JTextArea jt = new JTextArea();
	      
	      
	      public TimeLine1 (String s1, String s2, String s3){ //RR text
		         setLayout(null);
		         setBackground(Color.white);
		       
		         Image img1 = new ImageIcon("C:\\test\\"+s1+"\\profile.png").getImage();
		         
		         
		         s_img = new Friend_face(img1);
		       

		         timeline_text.setFont(font3);
		         timeline_text.setText("하고싶은말을 입력하세요");
		         
		 		Font fontla1= new Font("맑은 고딕",Font.BOLD,14);
		 		Font fontla2= new Font("맑은 고딕",Font.BOLD,12);
		 		Font fonttext= new Font("맑은 고딕",Font.PLAIN,12);

		         
		         s_img.setBounds(20, 20, 50, 50);
		         la1.setBounds(80,15,300,20);
		         la2.setBounds(80,30,300,20);
		         jt.setBounds(20, 80, 460, 70);

		         la1.setFont(fontla1);
		         la2.setFont(fontla2);
		         jt.setFont(fonttext);
		         
		         jt.setEnabled(true);
		         jt.setOpaque(false);
		         la1.setText(s1+" 님이 새로운 게시물을 등록했습니다.");
		         la2.setText(s2);
		         jt.setText(s3);
		         
		    
	         
		         add(s_img);
		         add(la1);
		         add(la2);
		         add(jt);
		         
		         setVisible(true);
		      }
	      
	      
	      public TimeLine1 (String s1, String s2, String s3,String path){ //RR img
		         setLayout(null);
		         setBackground(Color.white);
		       
		         Image img1 = new ImageIcon("C:\\test\\"+s1+"\\profile.png").getImage();
		         Image img2 = new ImageIcon("C:\\test\\rtimeline\\"+path+".png").getImage();
		         
		         s_img = new Friend_face(img1);
		         b_img = new Friend_face(img2);

		         timeline_text.setFont(font3);
		         timeline_text.setText("하고싶은말을 입력하세요");
		         
		 		Font fontla1= new Font("맑은 고딕",Font.BOLD,14);
		 		Font fontla2= new Font("맑은 고딕",Font.BOLD,12);
		 		Font fonttext= new Font("맑은 고딕",Font.PLAIN,12);

		         
		         s_img.setBounds(20, 20, 50, 50);
		         la1.setBounds(80,15,300,20);
		         la2.setBounds(80,30,300,20);
		         jt.setBounds(20, 80, 460, 70);

		         la1.setFont(fontla1);
		         la2.setFont(fontla2);
		         jt.setFont(fonttext);
		         
		         jt.setEnabled(true);
		         jt.setOpaque(false);
		         la1.setText(s1+" 님이 새로운 게시물을 등록했습니다.");
		         la2.setText(s2);
		         jt.setText(s3);
		         
		         b_img.setBounds(20,160,460,240);
	         
		         add(s_img);
		         add(la1);
		         add(la2);
		         add(jt);
		         add(b_img);
		         setVisible(true);
		      }
	      
	      
	      public TimeLine1 (String s1, String s2, String s3,String path,int i){ //init img
		         setLayout(null);
		         setBackground(Color.white);
		       
		         Image img1 = new ImageIcon("C:\\test\\"+s1+"\\profile.png").getImage();
		         Image img2 = new ImageIcon("C:\\test\\timeline\\"+path+".png").getImage();
		         
		         s_img = new Friend_face(img1);
		         b_img = new Friend_face(img2);

		         timeline_text.setFont(font3);
		         timeline_text.setText("하고싶은말을 입력하세요");
		         
		 		Font fontla1= new Font("맑은 고딕",Font.BOLD,14);
		 		Font fontla2= new Font("맑은 고딕",Font.BOLD,12);
		 		Font fonttext= new Font("맑은 고딕",Font.PLAIN,12);

		         
		         s_img.setBounds(20, 20, 50, 50);
		         la1.setBounds(80,15,300,20);
		         la2.setBounds(80,30,300,20);
		         jt.setBounds(20, 80, 460, 70);

		         la1.setFont(fontla1);
		         la2.setFont(fontla2);
		         jt.setFont(fonttext);
		         
		         jt.setEnabled(true);
		         jt.setOpaque(false);
		         la1.setText(s1+" 님이 새로운 게시물을 등록했습니다.");
		         la2.setText(s2);
		         jt.setText(s3);
		         
		         b_img.setBounds(20,160,460,240);
	         
		         add(s_img);
		         add(la1);
		         add(la2);
		         add(jt);
		         add(b_img);
		         setVisible(true);
		      }
	    	 

	      public TimeLine1 (Image img1, Image img2, String s1, String s2, String s3,String path_img){ //img
	         setLayout(null);
	         setBackground(Color.white);
	        
	         s_img = new Friend_face(img1);
	         b_img = new Friend_face(img2);
	         
	         
	         
			
	    
			
			 
	         timeline_text.setFont(font3);
	         timeline_text.setText("하고싶은말을 입력하세요");
	         
	 		Font fontla1= new Font("맑은 고딕",Font.BOLD,14);
	 		Font fontla2= new Font("맑은 고딕",Font.BOLD,12);
	 		Font fonttext= new Font("맑은 고딕",Font.PLAIN,12);

	         
	         s_img.setBounds(20, 20, 50, 50);
	         la1.setBounds(80,15,300,20);
	         la2.setBounds(80,30,300,20);
	         jt.setBounds(20, 80, 460, 70);

	         la1.setFont(fontla1);
	         la2.setFont(fontla2);
	         jt.setFont(fonttext);
	         
	         jt.setEnabled(true);
	         jt.setOpaque(false);
	         la1.setText(s1+" 님이 새로운 게시물을 등록했습니다.");
	         la2.setText(s2);
	         jt.setText(s3);
	         
	         b_img.setBounds(20,160,460,240);
	         
	         new TLwrite(path_img,s1,s2,s3);
	         
	         add(s_img);
	         add(la1);
	         add(la2);
	         add(jt);
	         add(b_img);
	         setVisible(true);
	      }
	      
	      public TimeLine1 (Image img1,String s1, String s2, String s3){
	          setLayout(null);
	          setBackground(Color.white);
	          s_img = new Friend_face(img1);
	          //s3 = timeline_text.getText();
	        
	          
	          
	         
	          timeline_text.setFont(font3);
	          timeline_text.setText("하고싶은말을 입력하세요");
	 		
	  		Font fontla1= new Font("맑은 고딕",Font.BOLD,14);
	  		Font fontla2= new Font("맑은 고딕",Font.BOLD,12);
	  		Font fonttext= new Font("맑은 고딕",Font.PLAIN,12);

	          
	  		 s_img.setBounds(20, 20, 50, 50);
	          
	          la1.setBounds(80,15,300,20);
	          la2.setBounds(80,30,300,20);
	          jt.setBounds(20, 80, 460, 200);
	          jt.setLineWrap(true);

	          la1.setFont(fontla1);
	          la2.setFont(fontla2);
	          jt.setFont(fonttext);
	          
	          jt.setEnabled(true);
	          jt.setOpaque(false);
	          
	          la1.setText(s1+" 님이 새로운 게시물을 등록했습니다.");
	          la2.setText(s2);
	          jt.setText(s3);
	     
	          new TLwrite(s1,s2,s3);
	          add(s_img);
	          add(la1);
	          add(la2);
	          add(jt);
	         
	          setVisible(true);
	       }
	   }
   
   /////////////////////////////////////////소앨범
   public class Small_album extends JPanel{
      
      public Small_album(Image img1,Image img2, Image img3,
            Image img4, Image img5, Image img6, Image img7, Image img8)
      { 
         Friend_face[] ff = new Friend_face[8];
         
            ff[0] = new Friend_face(img1);
            ff[1] = new Friend_face(img2);
            ff[2] = new Friend_face(img3);
            ff[3] = new Friend_face(img4);
            ff[4] = new Friend_face(img5);
            ff[5] = new Friend_face(img6);
            ff[6] = new Friend_face(img7);
            ff[7] = new Friend_face(img8);

            ff[0].setBounds(5,10,40,40);
            ff[1].setBounds(55,10,40,40);
            ff[2].setBounds(105,10,40,40);
            ff[3].setBounds(155,10,40,40);
            
            
            ff[4].setBounds(5,60,40,40);
            ff[5].setBounds(55,60,40,40);
            ff[6].setBounds(105,60,40,40);
            ff[7].setBounds(155,60,40,40);
            
         for(int i =0; i<8; i++)
            add(ff[i]);
         setLayout(null);   
         setVisible(true);
      }
   }
   
   
   //////////////////친구목록
   class Friend_back extends JPanel{
      public Friend_back(Image img, String str){
         Friend_face ff = new Friend_face(img);
         Friend_id fi = new Friend_id(str);
      
         setLayout(null);
         ff.setBounds(0,0,40,40);
         fi.setBounds(60,0,80,40);
         fi.setOpaque(false);
         add(fi);
         add(ff);
         
      //   setOpaque(false);
         setVisible(true);
      }
      
   }
   
   class Friend_face extends JPanel {
      Image image;
      public Friend_face(Image image) {
         this.image = image;
      }
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(this.image,0,0,this.getWidth(),this.getHeight(),this);
         setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
      }

   }
   class Friend_id extends JPanel {
      String str;
      public Friend_id(String str) {
         this.str = str;
         this.setLayout(new BorderLayout());
         setVisible(true);
      }
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
		Font fontla1= new Font("맑은 고딕",Font.BOLD,12);
         g.setFont(fontla1);
         g.drawString(str, 0, 23);
      //   setOpaque(false);// 그림을 표시하게 설정,투명하게 조절
      }
   }
   
   
   
   class MyPanel extends JPanel{
      
      
      ImageIcon img = new ImageIcon("main.jpg");
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(img.getImage(), 0, 0, null);
      }
      
   }

   static class Profile extends JPanel{
      
      static ImageIcon img = new ImageIcon("c:\\test\\"+id+"\\profile.png");
      
   
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         
         g.drawImage(img.getImage(), 0, 0, null); //이미지 원래사이즈로 넣기
            
            Dimension d = getSize();
            g.drawImage(img.getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
      }
   }
   
   int y = 140;
   int cnt =0;
   
   public void mouseDragged(MouseEvent e) {}
   public void mouseMoved(MouseEvent e) {}
   public void mouseClicked(MouseEvent e) {
      
      
      System.out.println("X : "+e.getX());
      System.out.println("Y : "+e.getY());
      if(e.getSource() == timeline_text){
    	  timeline_text.setText("");
    	  repaint();
      }
      if(e.getX() >= 1059 && e.getX()<= 1104){
    	  try {
         	 DataBase.DisConnect(id);
         	 f_check[0].flag=false;
         	 TLService.socket.close();
             ChatService.chatsock.close();
     
             this.dispose();
             new Login(dis,dos);
          } catch (IOException e1) {
             
             e1.printStackTrace();
          }
      }
      if(e.getX() >=1003 && e.getX()<= 1020){
         //new Chat();
      }
      if(e.getX() >=977 && e.getX()<= 985){
         new Message("알림창 만들곳");
      }
      if(e.getSource() == timeline_text){
         timeline_text.setOpaque(true);
         timeline_text.setBackground(new Color(255,255,255));
         timeline_text.repaint();
   
      }
      else if(e.getSource() != timeline_text){
         timeline_text.setOpaque(false);
         timeline_text.repaint();
      }
      
      for(int i=0; i<idlist.length; i++)
      {
     	 if(e.getSource() == fb_arraylist.get(i)){
              chat[i].ONOFF(true);
              repaint();
           }
     	 
      }
   }

   public void mouseEntered(MouseEvent e) {
     if(e.getSource() == fb){
         fb.setOpaque(true);

         repaint();
      }
     for(int i=0; i<idlist.length; i++)
     {
    	 if(e.getSource() == fb_arraylist.get(i)){
             fb_arraylist.get(i).setOpaque(true);
             repaint();
          }
    	 
     }
      
   }
   public void mouseExited(MouseEvent e) {
     if(e.getSource() == fb){
         fb.setOpaque(false);
         System.out.println("11");
      
         repaint();
      }
     for(int i=0; i<idlist.length; i++)
     {
    	 if(e.getSource() == fb_arraylist.get(i)){
             fb_arraylist.get(i).setOpaque(false);
             repaint();
          }
    	 
     }
   
       
   }
   int card_cnt = 0;
   int nowCardNumber = 0;
	String now_timeString;

   public void mousePressed(MouseEvent arg0) {}
   public void actionPerformed(ActionEvent e) {
	

	
	

	      if(e.getSource() == right_b && card_cnt > nowCardNumber){
	         card.next(timelineCard_panel);
	         nowCardNumber++;
	             card_total.setText(nowCardNumber+"/"+card_cnt);
	             repaint();
	      }
	      if(e.getSource() == left_b && 1 < nowCardNumber){
	         card.previous(timelineCard_panel);
	         nowCardNumber--;
	             card_total.setText(nowCardNumber+"/"+card_cnt);
	             repaint();
	      }
	      
	   
	   if(e.getSource() == timeline_text || e.getSource() == go_b){
           if(!timeline_text.getText().equals(""))
           {
               if(timeline_img == null)
              {
                 
                 TimeLine1 timeline = new TimeLine1(Profile.img.getImage(), id, Time(), timeline_text.getText());
                 timeline.setBounds(0, 0, 502, 400);
                   timelineCard_panel.add(timeline);
                   if(card_cnt > 0)
                      card.last(timelineCard_panel);
                   card_cnt++;
                   nowCardNumber = card_cnt;
                   card_total.setText(card_cnt+"/"+card_cnt);
                   repaint();
              }
                 else 
                 {
                   TimeLine1 timeline = new TimeLine1(Profile.img.getImage(),timeline_img,id,Time(),timeline_text.getText(),path_img);
                  
                     timeline.setBounds(0, 0, 502, 400);
                      timelineCard_panel.add(timeline);
                      if(card_cnt > 0)
                         card.last(timelineCard_panel);
                      card_cnt++;
                      nowCardNumber = card_cnt;
                      card_total.setText(card_cnt+"/"+card_cnt);
                      repaint();
                      timeline_img = null;
                 }
           }
	        else 
	        {
	           new Message("텍스트를 입력해주세요");
	        }
	     }
      if(e.getSource() == f1){
         //new Chat();
      }
      if(e.getSource() == profile_b){
         new Fclient(dis,dos,profile);
      }
      if(e.getSource() == study_b){
         new CCNA();
      }
      if(e.getSource() == picture_b){
    	  
         new Picture();
      }
      if(e.getSource() == birthday_b){
         new TimeTable();
      }
      if(e.getSource() == friend_b){
         new Message("친구보기 만들창");
      }
 
      if(e.getSource() == camera_b){
    	  if(select.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
      	  {
      		
      		if(getExtension(select.getSelectedFile().getName()))
      		{
      				path_img = select.getSelectedFile().toString();
  					timeline_img = new ImageIcon(path_img).getImage();
      		}
      		
      		else new Message("지원하지 않는 확장자입니다.");
      		
      	  }
      }
      if(e.getSource() == file_b){
         
      }
      
   }
   
   public static String Time()
  	{
  		Calendar calendar = Calendar.getInstance();
         java.util.Date date = calendar.getTime();
         String time = (new SimpleDateFormat("YYYY년 MM월 dd일 HH시 mm분 ss초").format(date));
         return time;
  	}
   
   public static boolean getExtension(String fileStr){
		  String EXT = fileStr.substring(fileStr.lastIndexOf(".")+1,fileStr.length());
		  if(EXT.compareToIgnoreCase("png")==0 || EXT.compareToIgnoreCase("jpg")==0 || EXT.compareToIgnoreCase("jpeg")==0 || EXT.compareToIgnoreCase("bmp") == 0)
		  {
			  return true;
		  }
		  else
			  return false;
	}
   
   
   
   class Message extends JFrame{
      
      Color color = new Color(120,205,209);
      Color color1 = new Color(255,255,255);
      JPanel panel = new JPanel();
      JLabel label = new JLabel();
      
      public Message(String name){
      
      setSize(250,250);
      setLocationRelativeTo(null);
      
      label.setText(name);
      label.setFont(font1);
      label.setForeground(color);
      panel.add(label);
      panel.setBackground(Color.white);
      add(panel);
      
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      }
      
   }

   public void mouseReleased(MouseEvent arg0) {}

class MyThread extends Thread{
   
   public void run(){
      for(int i=0;; i++){
         try {
            Thread.sleep(10);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         notice_p.repaint();
      notice_l1.setBounds(notice1X,0, 400, 25);
      notice_l2.setBounds(notice2X,0, 400, 25);
      notice_l3.setBounds(notice3X,0, 400, 25);
      notice1X -=1;
      notice2X -=1;
      notice3X -=1;
   
      if(notice1X == -800){
         notice1X = 400;
      }
      if(notice2X == -800){
         notice2X = 400;
      }
      if(notice3X == -800){
         notice3X = 400;
      }
   
      }
   }
}
 


public void setTimeline(String s1,String s2,String s3,String path) 
{
	
	
	TimeLine1 timeline =new TimeLine1(s1, s2, s3,path);
	
	timeline.setBounds(0, 0, 502, 400);
    timelineCard_panel.add(timeline);
    if(card_cnt > 0)
  	card.last(timelineCard_panel);
    card_cnt++;
    nowCardNumber++;
    card_total.setText(nowCardNumber+"/"+card_cnt);
    repaint();
}

public void setTimeline1(String s1,String s2,String s3,String path) 
{
	
	
	TimeLine1 timeline =new TimeLine1(s1, s2, s3,path,1);
	
	timeline.setBounds(0, 0, 502, 400);
    timelineCard_panel.add(timeline);
    if(card_cnt > 0)
  	card.last(timelineCard_panel);
    card_cnt++;
    nowCardNumber++;
    card_total.setText(nowCardNumber+"/"+card_cnt);
    repaint();
}

public void setTimeline(String s1,String s2,String s3) 
{
	
	
	TimeLine1 timeline =new TimeLine1(s1, s2, s3);
	
	timeline.setBounds(0, 0, 502, 400);
    timelineCard_panel.add(timeline);
    if(card_cnt > 0)
  	card.last(timelineCard_panel);
    card_cnt++;
    nowCardNumber++;
    card_total.setText(nowCardNumber+"/"+card_cnt);
    repaint();
}




public void getFriend(String id)
{
	Color color = new Color(209,239,241);

    Friend_back f = new Friend_back(new ImageIcon("C:\\test\\"+id+"\\profile.png").getImage(), id);
    friend_list_back.setBounds(909, 140, 200,800 );
    friend_list_back.add(f);
    friend_list_back.setBackground(color);
    
    f.setBounds(909, y, 200, 39); 
    f.setBackground(Color.WHITE);
    f.setOpaque(false);
    f.addMouseListener(this);
    my.add(f);
    my.add(friend_list_back);
    add(my);
    fb_arraylist.add(cnt,f);
    cnt++;
    y += 40;
    repaint();
}

}


