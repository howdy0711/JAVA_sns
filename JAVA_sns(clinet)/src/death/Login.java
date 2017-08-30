package death;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class Login extends JFrame implements ActionListener,
MouseListener,MouseMotionListener ,KeyListener{
   Socket socket = null;
   JTextField id_text = new JTextField();
   JPasswordField pass_text = new JPasswordField();
   JButton login_button = new JButton(new ImageIcon("login_button.png"));
   Font font1 = new Font("맑은 고딕",Font.BOLD,15);
   Font font2 = new Font("Serif",Font.BOLD,20);
   
   DataInputStream dis;
   DataOutputStream dos;
   public Login(DataInputStream dis , DataOutputStream dos){
      this.dis = dis;
      this.dos = dos;
      MyPanel myp = new MyPanel();
   //   setUndecorated(true);
      setSize(840,600);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      myp.setLayout(null);

      
      //id 텍스트필드
      id_text.setOpaque(false);
      id_text.setBounds(274, 206, 200, 34);
      id_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      id_text.setFont(font1);
      id_text.addMouseListener(this);
      myp.addMouseListener(this);
      id_text.addKeyListener(this);
      id_text.setFocusTraversalKeysEnabled(false);
	 

      //password 텍스트필드
   //   pass_text.setOpaque(false);
      pass_text.setBounds(274, 278, 200, 35);
      pass_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      pass_text.setFont(font2);
      pass_text.addMouseListener(this);
      pass_text.addActionListener(this);
	  pass_text.addKeyListener(this);
      pass_text.setFocusTraversalKeysEnabled(false);
      //로그인 button
      login_button.setBounds(507,206,120,110);
      login_button.addActionListener(this);
      
      myp.add(id_text);
      myp.add(pass_text);
      myp.add(login_button);
      add(myp);
      
      setResizable(false);
      setVisible(true);
   }
   
   
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==login_button|| e.getSource()==pass_text){
         String id = id_text.getText();
         char[] pass = pass_text.getPassword();
         String password = new String(pass);
         id_text.setOpaque(true);
         id_text.setBackground(new Color(110,195,199));
         pass_text.setOpaque(true);
         pass_text.setBackground(new Color(110,195,199));
         
         if (id.equals(""))
			{
				new Message("    ID를 입력!");
			}
			else if(password.equals(""))
			{
				new Message("패스워드 입력!");
			}
         else{
            DataBase db = new DataBase(id,password);
            
            if(!db.ConCheck(id)&&db.Check())
            {
                  try {
                     
                     Main.Flag("setid",id, dos);

                     Main.Flag(id,dos);
                     new Init(id, dis).run();
                     
                     Main.Flag("chat", dos);
                     new Init(id,dis).chat();
                     db.Connect(id);
                     
                     new Thread(new ChatService(id)).start();
                     new Thread(new TLService(id)).start();
                  
                     
                     this.setVisible(false);
                     DataBase fr =new DataBase(id,dos,dis);
                     Madang madang = new Madang(dis,dos,id,fr.getIDlist());
                     TLService.setMadang(madang);
                     this.dispose();
                  } catch (IOException e1) {
                     e1.printStackTrace();
                  }
                  
            }
            else if(db.ConCheck(id))
            {
               new Message("현재 이아이디는 접속중입니다.");
            }
            else new Message("로그인 실패");
            id_text.setBackground(new Color(255,255,255));
            pass_text.setBackground(new Color(255,255,255));

         }
      }
      
   }
   



   
class MyPanel extends JPanel{
   ImageIcon img = new ImageIcon("login.jpg");
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img.getImage(), 0, 0, null);
   }
   
}

public void mouseDragged(MouseEvent e) {
}
public void mouseMoved(MouseEvent e) {
}
public void mouseClicked(MouseEvent e) {
   System.out.println(e.getX()+" "+e.getY());
   if(e.getSource() == id_text){
      id_text.setOpaque(true);
      id_text.setBackground(new Color(110,195,199));
      
      
      pass_text.setBackground(new Color(255,255,255));
      
   }
   if(e.getSource() == pass_text){
      pass_text.setOpaque(true);
      pass_text.setBackground(new Color(110,195,199));
      
      id_text.setBackground(new Color(255,255,255));
   }
   if(e.getX() > 0 && e.getSource()!= id_text && e.getSource() != pass_text){
      id_text.setBackground(new Color(255,255,255));
      pass_text.setBackground(new Color(255,255,255));

   }
   if((e.getX() >= 502 && e.getX() <= 562) && (e.getY() >= 366 && e.getY() <= 383)){
      new Sign_up();
   }
   if(e.getY() >=369 && e.getY()<=381){
		if(e.getX() >= 273 && e.getX()<= 360){
			new Find_id();
		}
		if(e.getX() >= 370 && e.getX()<= 485){
			new Find_password();
		}

	}
}
public void mouseEntered(MouseEvent arg0) {
}
public void mouseExited(MouseEvent arg0) {
}
public void mousePressed(MouseEvent arg0) {
}
public void mouseReleased(MouseEvent arg0) {
}


@Override

public void keyPressed(KeyEvent e) {
	 if(e.getKeyCode()== KeyEvent.VK_TAB && e.getSource()==id_text){
	       pass_text.requestFocus();
	       pass_text.setOpaque(true);
	       pass_text.setBackground(new Color(110,195,199));
	       id_text.setOpaque(false);
			repaint();
	  }
	  
	  if(e.getKeyCode()==KeyEvent.VK_TAB && e.getSource()==pass_text){
	       id_text.requestFocus();
			id_text.setBackground(new Color(110,195,199));
			id_text.setOpaque(true);
			pass_text.setOpaque(false);
			repaint();


	  }
}


@Override
public void keyReleased(KeyEvent e) {
   // TODO Auto-generated method stub
   
}


@Override
public void keyTyped(KeyEvent e) {
   // TODO Auto-generated method stub
   
}
}



   