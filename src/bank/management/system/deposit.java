
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
public class deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton depositb,exit;
    String pinNumber;
    deposit(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount to be deposited");
        text.setBounds(170,300,400,20);
        text.setFont(new Font("raleway",Font.BOLD,22));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        amount=new JTextField();
        amount.setBounds(170,350,330,30);
        amount.setFont(new Font("raleway",Font.BOLD,22));
        image.add(amount);
        
        depositb=new JButton("Deposit");
        depositb.setBounds(390,450,100,30);
        depositb.addActionListener(this);
        image.add(depositb);
        
        exit=new JButton("Exit");
        exit.setBounds(390,500,100,30);
        exit.addActionListener(this);
        image.add(exit);
        
    }

    
    public static void main(String[] args) {
        new deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==depositb){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount");
            }else{
                
            try{
                conn connect=new conn();
                String query="insert into deposita values('"+pinNumber+"','"+date+"','Deposit','"+number+"')";
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+number+"Deposited Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch(HeadlessException | SQLException ae){
                System.out.println(ae);
            }
            }  
        }else if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
}
