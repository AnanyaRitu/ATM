/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectb;

/**
 *
 * @author Lenovo
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
  JLabel l1,l2,l3;  
  JTextField tf1;
  JPasswordField pw1;
  JButton b1,b2,b3;
  Login(){
      
      //move the text to the center
  setFont(new Font("System", Font.BOLD, 22));
  Font f=getFont();
  FontMetrics fm=getFontMetrics(f);
  int x= fm.stringWidth("AUTOMATED TELLER MACHINE");
  int y=fm.stringWidth(" ");
  int z=getWidth()-x;
  int w= z/y;
  String pad="";
  pad = String.format("%"+w+"s", pad);
  setTitle(pad+"AUTOMATED TELLER MACHINE");
  
  l1= new JLabel("WELCOME TO ATM");
  l1.setFont(new Font("Osward", Font.BOLD, 38));
  
  l2 =new JLabel("Card no:");
  l2.setFont(new Font("Raleway", Font.BOLD, 28));
  
  l3= new JLabel("PIN:");
  l3.setFont(new Font("Raleway", Font.BOLD, 28));
  
  tf1= new JTextField(15);
  pw1= new JPasswordField(15);
  
  b1= new JButton("SIGN IN");
  b1.setBackground(Color.blue);
  b1.setForeground(Color.WHITE);
  
  b2= new JButton("CLEAR");
  b2.setBackground(Color.blue);
  b2.setForeground(Color.white);
  
  b3= new JButton("SIGN UP");
  b3.setBackground(Color.blue);
  b3.setForeground(Color.white);
  
  setLayout(null);
  
  l1.setBounds(175,50,450,200);
  add(l1);
  
  l2.setBounds(125,150,375,200);
  add(l2);
  
  tf1.setFont(new Font("Arial", Font.BOLD, 14));
  tf1.setBounds(300,235,230,30);
  add(tf1);
  
  l3.setBounds(125,225,375,200);
  add(l3);
  
  pw1.setFont(new Font("Arial", Font.BOLD, 14));
  pw1.setBounds(300,310,230,30);
  add(pw1);
  
  b1.setFont(new Font("Arial", Font.BOLD, 14));
  b1.setBounds(300,400,100,30);
  add(b1);
  
  b2.setFont(new Font("Arial", Font.BOLD, 14));
  b2.setBounds(430,400,100,30);
  add(b2);
  
  b3.setFont(new Font("Arial", Font.BOLD, 14));
  b3.setBounds(300,450,230,30);
  add(b3);
  
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  
  getContentPane().setBackground(Color.white);
  
  setSize(750,750);
  setLocation(500,200);
  setVisible(true);

//
  }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    try{
    conn c1=new conn();
    String a=tf1.getText();
    String b=pw1.getText();
    String q="select * from login "
            + "where cardno = '"+a+"' and pin = '"+b+"'";
    ResultSet rs= c1.s.executeQuery(q);
    
    if(e.getSource()==b1){
    if(rs.next()){
    new Transactions().setVisible(true);
    setVisible(false);
    }
    else{
    JOptionPane.showMessageDialog(null,"Incorrect card "
            + "number or password");
    }
    } else if(e.getSource()==b2){
    tf1.setText("");
    pw1.setText("");
    }else if (e.getSource()==b3){
    new Signup().setVisible(true);
    setVisible(false);
    }
    }
    
    catch(Exception err){
        err.printStackTrace();
        System.out.println("error: "+e);
    }
    
    }
        public static void main(String[] args) {
        // TODO code application logic here
        new Login().setVisible(true);
    }
}
