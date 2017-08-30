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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat extends JFrame implements ActionListener,KeyListener
,MouseListener,MouseMotionListener{
   

   MyPanel2 m2 = new MyPanel2(); //�̸�Ƽ�� Ŭ���� ����
   boolean b1 = true; //������ 
   
   Font font1 = new Font("���� ���",Font.PLAIN,15);
   Color color = new Color(209,239,241);

   JTextField text = new JTextField();
   JTextArea area = new JTextArea();
   JScrollPane js;

   
   JButton push_b = new JButton(new ImageIcon("chat_b.png"));
   JButton picture_b = new JButton(new ImageIcon("camera_b.png"));
   JButton file_b = new JButton(new ImageIcon("file_b.png"));
   JButton emoticon_b = new JButton(new ImageIcon("emoticon_b.png"));
   MyPanel myp = new MyPanel();
   String id;
   
   public Chat(String id){
      this.id = id;
   //   setUndecorated(true);
      setSize(400,520);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setTitle(id+" �԰��� ��ȭ");
      myp.setLayout(null);
      
   //�ؽ�Ʈ area
      area.setEditable(false);
      
      js = new JScrollPane(area);
      js.setBounds(10, 39, 372, 338);
      js.setFont(font1);
      js.setOpaque(false);
      
      area.addMouseListener(this);
      area.setBackground(color);
      myp.add(js);
      
      
   //�ؽ�Ʈ�ʵ�
      text.setBounds(25, 402, 281, 71);
      text.addMouseListener(this);
      myp.add(text);
      text.addActionListener(this);
      text.setFont(font1);

   //���۹�ư   
      push_b.setBounds(306,402,71,70);
      myp.add(push_b);
      push_b.addActionListener(this);
      
   //������ư
      picture_b.setBounds(25,378,26,24);
      myp.add(picture_b);
   //���Ϲ�ư
      file_b.setBounds(51,378,26,24);
      myp.add(file_b);
   //�̸�Ƽ�� ��ư
      emoticon_b.setBounds(75,378,26,24);
      emoticon_b.addActionListener(this);
      emoticon_b.addMouseListener(this);
      myp.add(emoticon_b);
      

      add(myp);
      setVisible(false);
      setResizable(false);
   }
   
   public String getID()
   {
      return this.id;
   }


   @Override
   public void actionPerformed(ActionEvent e) {
      String s;
      if(e.getSource() == text || e.getSource()== push_b){
         s = text.getText();
         this.area.append(Madang.id+" : "+s+"\n");
         new ChatService(id,s); 
         s = "";
         text.selectAll();
      }
      if(e.getSource() == emoticon_b || e.getSource() == emoticon_b && 
            b1==false){
            myp.add(m2);
            area.setOpaque(false);
            repaint();
      }
   

   }
   
   public void ONOFF(Boolean power) //Ű�� �����
   {
      if(power)
      setVisible(true);
      else
      setVisible(false);
   }
   
   
   class MyPanel extends JPanel{
      ImageIcon img = new ImageIcon("chat.jpg");
      protected void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(img.getImage(), 0, 0, null);
      }
      
   }
      
   class MyPanel2 extends JPanel{
      ImageIcon img = new ImageIcon("all_emoticon.jpg");

      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(img.getImage(), 0, 0, null);
      }
      
      public MyPanel2(){
         setLayout(null);
         this.setBounds(25, 262, 200, 115);
         this.setVisible(true);

      }
   }

   public void keyPressed(KeyEvent e1){}
   public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent arg0) {}
   
   public void mouseClicked(MouseEvent e) {      
      if(e.getX() >=200 && e.getX() <=209 && e.getY() >=228 && e.getY()<=237 ){
         area.setOpaque(true);
         b1= false;
         repaint();
      }
   }
   public void mouseEntered(MouseEvent arg0) {}
   public void mouseExited(MouseEvent arg0) {}
   public void mousePressed(MouseEvent arg0) {}
   public void mouseReleased(MouseEvent arg0) {}
   public void mouseDragged(MouseEvent arg0) {}
   public void mouseMoved(MouseEvent arg0) {}




}