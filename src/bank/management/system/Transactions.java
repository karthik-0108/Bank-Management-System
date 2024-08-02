
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,cash,mini,pin,balance,exit;
    String pinNumber;
    Transactions(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please Select Your Transaction");
        text.setBounds(215,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(170,340,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(350,340,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        cash=new JButton("Fast Cash");
        cash.setBounds(170,370,150,30);
        cash.addActionListener(this);
        image.add(cash);
        
        mini=new JButton("Mini Statement");
        mini.setBounds(350,370,150,30);
        mini.addActionListener(this);
        image.add(mini);
        
        pin=new JButton("Pin Change");
        pin.setBounds(170,400,150,30);
        pin.addActionListener(this);
        image.add(pin);
        
        balance=new JButton("Balance Enquiry");
        balance.setBounds(350,400,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        
        exit=new JButton("EXIT");
        exit.setBounds(350,440,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);
        setLayout(null);
    }

    
    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
            setVisible(false);
            new deposit(pinNumber).setVisible(true);
        }else if(e.getSource()==withdrawl){
            setVisible(false);
            new withdraw(pinNumber).setVisible(true);
        }else if(e.getSource()==cash){
            setVisible(false);
            new fastCash(pinNumber).setVisible(true);
        }else if(e.getSource()==pin){
            setVisible(false);
            new pinChange(pinNumber).setVisible(true);
        }else if(e.getSource()==balance){
            setVisible(false);
            new balance(pinNumber).setVisible(true);
        }else if(e.getSource()==mini){
            setVisible(false);
            new miniStatement(pinNumber).setVisible(true);
        }        
    }
    
}
