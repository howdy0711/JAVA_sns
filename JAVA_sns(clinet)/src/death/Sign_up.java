package death;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Sign_up extends JFrame  implements ActionListener,
MouseListener{
   
   Sign sign = new Sign();
   Font font1 = new Font("한컴 윤체 B",Font.BOLD,20);

   JTextField id_text = new JTextField("");
   JPasswordField pass_text = new JPasswordField("");
   JPasswordField repass_text = new JPasswordField("");
   JTextField name = new JTextField("");
   JButton man = new JButton("");
   JButton woman = new JButton("");
   JTextField year_text = new JTextField("");
   JTextField month_text = new JTextField();
   JTextField day_text = new JTextField("");
   JTextField email = new JTextField("");
   JTextField phone_number = new JTextField("");
   JButton sign_button = new JButton("");
   
   
   public Sign_up(){
      setSize(600,750);
      setResizable(false);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setLocationRelativeTo(null);
      sign.setLayout(null);
      
      //아이디
      id_text.setOpaque(false);
      id_text.setBackground(Color.BLUE);
      id_text.setBounds(130, 214, 340, 34);
      id_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      id_text.addMouseListener(this);
      
      //비밀번호
      pass_text.setOpaque(false);
      pass_text.setBackground(Color.CYAN);
      pass_text.setBounds(130, 251, 340, 34);
      pass_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      pass_text.addMouseListener(this);
      //비밀번호 확인
      repass_text.setOpaque(false);
      repass_text.setBackground(Color.YELLOW);
      repass_text.setBounds(130, 287, 340, 34);
      repass_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      repass_text.addMouseListener(this);
      //이름
      name.setOpaque(false);
      name.setBackground(Color.red);
      name.setBounds(130, 341, 340, 34);
      name.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      name.addMouseListener(this);
      //남자버튼
      man.setOpaque(false);
      man.setBackground(Color.darkGray);
      man.setBounds(130, 377, 170, 34);
      man.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      man.addActionListener(this);

      //여자버튼
      woman.setOpaque(false);
      woman.setBackground(Color.LIGHT_GRAY);
      woman.setBounds(302, 377, 170, 34);
      woman.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      woman.addActionListener(this);
      
      //연도입력
      year_text.setOpaque(false);
      year_text.setBackground(Color.LIGHT_GRAY);
      year_text.setBounds(193, 414, 90, 34);
      year_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      year_text.addMouseListener(this);
      //월 입력
      month_text.setBackground(Color.WHITE);
      month_text.setBounds(287, 414, 95, 34);
      month_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      month_text.addMouseListener(this);
      //날짜 입력
      day_text.setOpaque(false);
      day_text.setBackground(Color.LIGHT_GRAY);
      day_text.setBounds(386, 414, 84, 34);
      day_text.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      day_text.addMouseListener(this);
      //메일
      email.setOpaque(false);
      email.setBackground(Color.RED);
      email.setBounds(130, 451, 340, 34);
      email.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      email.addMouseListener(this);
      //휴대전화번호
      phone_number.setOpaque(false);
      phone_number.setBackground(Color.BLACK);
      phone_number.setBounds(130, 507, 340, 34);
      phone_number.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      phone_number.addMouseListener(this);
      //회원가입 버튼
      sign_button.setOpaque(false);
      sign_button.setBackground(Color.BLACK);
      sign_button.setBounds(130, 586, 340, 71);
      sign_button.setBorder(javax.swing.BorderFactory.createEmptyBorder());   
      sign_button.addActionListener(this);
      
      sign.add(pass_text);
      sign.add(id_text);
      sign.add(repass_text);
      sign.add(name);
      sign.add(man);
      sign.add(woman);
      sign.add(year_text);
      sign.add(month_text);
      sign.add(day_text);
      sign.add(email);
      sign.add(phone_number);
      sign.add(sign_button);
      add(sign);
      setVisible(true);
   }

   String id, email_, phone, sex, name_, b_day;
   String year, month, day;
   
   public void mouseClicked(MouseEvent e) {
      
      if(e.getSource() == id_text){
         id_text.setOpaque(true);
         id_text.setBackground(new Color(255,255,255));
      }
      if(e.getSource() == pass_text){
         pass_text.setOpaque(true);
         pass_text.setBackground(new Color(255,255,255));
      }
      if(e.getSource() == repass_text){
         repass_text.setOpaque(true);
         repass_text.setBackground(new Color(255,255,255));
      }
      if(e.getSource() == name){
         name.setOpaque(true);
         name.setBackground(new Color(255,255,255));
      }
      if(e.getSource() == year_text){
         year_text.setOpaque(true);
         year_text.setBackground(new Color(255,255,255));
      }
      if(e.getSource() == month_text){
         month_text.setOpaque(true);
         month_text.setBackground(new Color(255,255,255));
         }
      if(e.getSource() == day_text){
         day_text.setOpaque(true);
         day_text.setBackground(new Color(255,255,255));
         }
      if(e.getSource() == phone_number){
         phone_number.setOpaque(true);
         phone_number.setBackground(new Color(255,255,255));
      }
      if(e.getSource() == email){
         email.setOpaque(true);
         email.setBackground(new Color(255,255,255));
      }
   }
   public void mouseEntered(MouseEvent e) {
   }
   public void mouseExited(MouseEvent e) {   
   }
   public void mousePressed(MouseEvent e) {   
   }
   public void mouseReleased(MouseEvent e) {   
   }
   public void actionPerformed(ActionEvent e) {
      if(e.getSource() == sign_button){
         char[] pass = pass_text.getPassword();
         String pw = new String(pass);
         char[] pass1 = repass_text.getPassword();
         String pw1 = new String(pass1);
         
         if((id = id_text.getText()).equals("")) new Message("ID 를 입력해주세요 !");
         else if((name_ = name.getText()).equals("")) new Message("이름을 입력해주세요 !");
         else if((email_ = email.getText()).equals("")) new Message("이메일을 입력해주세요 !");
         else if((phone = phone_number.getText()).equals("")) new Message("휴대폰 번호를 입력해주세요 !");
         else if((year = year_text.getText()).equals("")) new Message("연도를 입력해주세요 !");
         else if((month = month_text.getText()).equals("")) new Message("월 을 입력해주세요 !");
         else if((day = day_text.getText()).equals("")) new Message("일 을 입력해주세요 !");
         else if(!pw.equals(pw1)) new Message("재입력 비밀번호가 맞지않습니다.");
         
         else
         {
	         b_day = year+"-"+month+"-"+day;
	         DataBase db = new DataBase(id,pw,email_,phone,sex,name_,b_day);
	         new Message("가입 되었습니다");   
         }
      }
      if(e.getSource() == man){
         woman.setOpaque(false);
         woman.setBackground(Color.darkGray);
         man.setOpaque(true);
         man.setBackground(new Color(110,195,199));
         sex = "남";
         
      }
      if(e.getSource() == woman){
         man.setOpaque(false);
         man.setBackground(Color.darkGray);
         woman.setOpaque(true);
         woman.setBackground(new Color(110,195,199));
         sex = "여";
      }
   }
   
   class Message extends JFrame{
      
      Color color = new Color(120,205,209);
      Color color1 = new Color(255,255,255);
      JPanel panel = new JPanel();
      JLabel label = new JLabel();
      
      public Message(String name){
      
      setSize(200,120);
      setLocationRelativeTo(null);
      
      label.setText(name);
      label.setFont(font1);
      label.setForeground(color);
      panel.setLayout(null);
      label.setBounds(30,20,200,50);
      panel.add(label);
      panel.setBackground(Color.white);
      add(panel);
      
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setResizable(false);
      setVisible(true);
      }
      
   }

}

class Sign extends JPanel{
   ImageIcon img = new ImageIcon("회원가입12.png");
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img.getImage(), 0, 0, null);
   }
   
}