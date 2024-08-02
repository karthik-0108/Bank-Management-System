
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login1 extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField card;
    JPasswordField pinNo;
    
    Login1(){
        setLayout(null);
        setTitle("ATM");
        setSize(700,500);
        setVisible(true);
        setLocation(375,30);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.jpeg")); 
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        getContentPane().setBackground(Color.white);
        
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("osward",Font.BOLD,38));
        add(text);
        
        JLabel CardNo=new JLabel("CARD NO:");
        CardNo.setBounds(120,150,150,40);
        CardNo.setFont(new Font("RALEWAY",Font.BOLD,28));
        add(CardNo);
        
        card = new JTextField();
        card.setBounds(300,150,230,40);
        add(card);
        
        JLabel pin=new JLabel("PIN:");
        pin.setBounds(120,220,250,40);
        pin.setFont(new Font("RALEWAY",Font.BOLD,28));
        add(pin);
        
        pinNo = new JPasswordField();
        pinNo.setBounds(300,220,230,40);
        add(pinNo);
        
        login=new JButton("SIGN-IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN-UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== clear){
            card.setText("ENTER THE CARD NUMBER");
            pinNo.setText("");
            
        }else if(ae.getSource()==login){
            conn connect=new conn();
            String cardNumber=card.getText();
            String pinNumber=pinNo.getText();
            String query="select * from login where cardnumber='"+cardNumber+"' and pinnumber='"+pinNumber+"'";
            try{
            ResultSet rs=connect.s.executeQuery(query);
            if (rs.next()){
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"INCORRECT CREDENTIALS");
            }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new signupOne().setVisible(true);
        }
        
    }
   

    public static void main(String[] args) {
        new Login1();
    }

    

    
    
}

    
