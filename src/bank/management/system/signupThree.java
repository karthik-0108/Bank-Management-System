
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class signupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    signupThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        
        JLabel label=new JLabel("PAGE 3 ACCOUNT DETAILS:");
        label.setFont(new Font("raleway",Font.BOLD,22));
        label.setBounds(280,40,400,40);
        add(label);
        
        JLabel type=new JLabel("Account Type:");
        type.setFont(new Font("raleway",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Savings Account");
        r1.setFont(new Font("raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,200,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,200,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,200,20);
        add(r3);
        
        r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4);
        
        ButtonGroup account=new ButtonGroup();
        account.add(r1);
        account.add(r2);
        account.add(r3);
        account.add(r4);
        
        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("raleway",Font.BOLD,22));
        card.setBounds(100,260,200,30);
        add(card);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-6532");
        number.setFont(new Font("raleway",Font.BOLD,16));
        number.setBounds(300,260,300,30);
        add(number);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("raleway",Font.BOLD,22));
        pin.setBounds(100,300,200,30);
        add(pin);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("raleway",Font.BOLD,16));
        pnumber.setBounds(300,300,200,30);
        add(pnumber);
        
        JLabel services=new JLabel("SERVICES:");
        services.setFont(new Font("raleway",Font.BOLD,22));
        services.setBounds(100,340,200,30);
        add(services);
        
        
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setBounds(100,380,200,30);
        c1.setFont(new Font("raleway",Font.BOLD,16));
        add(c1);
        
        c2=new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setBounds(100,410,200,30);
        c2.setFont(new Font("raleway",Font.BOLD,16));
        add(c2);
        
        c3=new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setBounds(100,440,200,30);
        c3.setFont(new Font("raleway",Font.BOLD,16));
        add(c3);
        
        c4=new JCheckBox("EMAIL/SMS ALERTS");
        c4.setBackground(Color.WHITE);
        c4.setBounds(320,380,200,30);
        c4.setFont(new Font("raleway",Font.BOLD,16));
        add(c4);
        
        c5=new JCheckBox("CHECK BOOK");
        c5.setBackground(Color.WHITE);
        c5.setBounds(320,410,200,30);
        c5.setFont(new Font("raleway",Font.BOLD,16));
        add(c5);
        
        c6=new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setBounds(320,440,200,30);
        c6.setFont(new Font("raleway",Font.BOLD,16));
        add(c6);
        
        c7=new JCheckBox("I hereby declare that the above given information is correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setBounds(100,470,700,30);
        c7.setFont(new Font("raleway",Font.BOLD,16));
        add(c7);
        
        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("raleway",Font.BOLD,16));
        submit.setBounds(200,520,150,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("raleway",Font.BOLD,16));
        cancel.setBounds(400,520,150,30);
        cancel.addActionListener(this);
        add(cancel);
        
        
        
       
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
       new signupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == submit){
            String account=null;
            if(r1.isSelected()){
                account="SAVING ACCOUNT";
            }else if(r2.isSelected()){
                account="Fixed Deposit Account";
            }else if(r3.isSelected()){
                account="Current Account";
            }else if(r4.isSelected()){
                account="Recurring Deposit Account";
            }
        Random random=new Random();
        String cardnumber="" + Math.abs((random.nextLong()%9000L))+504090380000L;
        String pinnumber="" + Math.abs((random.nextLong()%900L))+1L; 
        
        String facility="";
        if(c1.isSelected()){
            facility=facility+"ATM CARD";
        }else if(c2.isSelected()){
            facility=facility + "INTERNET BANKING";
        }else if(c3.isSelected()){
            facility=facility + "MOBILE BANKING";
        }else if(c4.isSelected()){
            facility=facility + "EMAIL/SMS ALERTS";
        }else if(c5.isSelected()){
            facility=facility + "CHECK BOOK";
        }else if(c6.isSelected()){
            facility=facility + "E-STATEMENT";
        }
        
        try{
            if(account.equals("")){
                JOptionPane.showMessageDialog(null,"account is required");
            }else{
                conn connect=new conn();
                String query1="insert into signupThr values('" + formno + "','" + account + "','" + cardnumber+ "','" +pinnumber+ "','" + facility + "')";
                String query2="insert into signupThr values('" + formno + "','" + cardnumber+ "','" +pinnumber+ "')";
                connect.s.executeUpdate(query1);
                connect.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "SignupThree Successful");
                JOptionPane.showMessageDialog(null, "card number:"+ cardnumber);
                JOptionPane.showMessageDialog(null, "pin number:"+ pinnumber);
            }
            
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login1().setVisible(true);
        }
    }
    
}
