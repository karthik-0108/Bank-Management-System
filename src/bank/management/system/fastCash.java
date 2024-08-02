
package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class fastCash extends JFrame implements ActionListener{
    JButton fiveh,thousand,twot,fivet,tent,twentyt,exit;
    String pinNumber;
    fastCash(String pinNumber){
        this.pinNumber=pinNumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please Select Your Amount");
        text.setBounds(215,220,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("system",Font.BOLD,16));
        image.add(text);
        
        fiveh=new JButton("Rs 500");
        fiveh.setBounds(170,340,150,30);
        fiveh.addActionListener(this);
        image.add(fiveh);
        
        thousand=new JButton("Rs 1000");
        thousand.setBounds(350,340,150,30);
        thousand.addActionListener(this);
        image.add(thousand);
        
        twot=new JButton("Rs 2000");
        twot.setBounds(170,370,150,30);
        twot.addActionListener(this);
        image.add(twot);
        
        fivet=new JButton("Rs 5000");
        fivet.setBounds(350,370,150,30);
        fivet.addActionListener(this);
        image.add(fivet);
        
        tent=new JButton("Rs 10000");
        tent.setBounds(170,400,150,30);
        tent.addActionListener(this);
        image.add(tent);
        
        twentyt=new JButton("Rs 20000");
        twentyt.setBounds(350,400,150,30);
        twentyt.addActionListener(this);
        image.add(twentyt);
        
        
        exit=new JButton("BACK");
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
        new fastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else{
            String amount=((JButton)e.getSource()).getText().substring(3);
            conn connect=new conn();
            try{
                ResultSet rs = connect.s.executeQuery("select * from deposita where pin ='"+pinNumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    } 
                }
                if(e.getSource() !=exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                Date date=new Date();
                String query="insert into deposita values '"+pinNumber+"','"+date+"','withdrawl','"+amount+"'";
                connect.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Amount debited successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            }catch(Exception ae){
                System.out.println(ae);
            }
            
        }
        
    }
    
}
