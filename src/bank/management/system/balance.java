
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
public class balance extends JFrame implements ActionListener{
    JButton back;
    String pin;
    balance(String pin){
        this.pin=pin;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        conn connect=new conn();
        int balance=0;
             try{
                 ResultSet rs = connect.s.executeQuery("select * from deposita where pin ='"+pin+"'");
                 while(rs.next()){
                    if(rs.getString("type").equals("deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    } 
                }
             }catch(Exception ae){
                 System.out.println(ae);
             }
             JLabel enquiry=new JLabel("Your Current Balance is Rs:"+balance);
             enquiry.setForeground(Color.WHITE);
             enquiry.setFont(new Font("system",Font.BOLD,16));
             enquiry.setBounds(165,300,290,30);
             image.add(enquiry);
        
        setLocation(300,0);
        setSize(900,900);
        setUndecorated(true);
        setVisible(true);
        
        
    }

   
    public static void main(String[] args) {
        new balance("");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin).setVisible(false);
    }
    
}
