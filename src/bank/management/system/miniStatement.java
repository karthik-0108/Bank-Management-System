
package bank.management.system;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
public class miniStatement extends JFrame{
    miniStatement(String pinNumber){
        setLayout(null);
        setVisible(true);
        setSize(400,600);
        setLocation(20,20);
        setTitle("Mini-Statement");
        getContentPane().setBackground(Color.WHITE);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,100,400,200);
        add(mini);
        
        JLabel name=new JLabel("ABC BANK OF INDIA");
        name.setBounds(130,30,150,30);
        add(name);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try{
            conn connect=new conn();
            ResultSet rs=connect.s.executeQuery("select * from login where pinnumber='"+pinNumber+"'");
            while(rs.next()){
                card.setText("card number:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
          conn connect =new conn();
          ResultSet rs=connect.s.executeQuery("select* from deposita where pin='"+pinNumber+"'");
          int bal=0;
          while(rs.next()){
              mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br></br></html>");
              if(rs.getString("type").equals("deposit")){
                bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                } 
              balance.setText("Your current Balance is Rs."+bal);
          }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    
    public static void main(String[] args) {
        new miniStatement("");
    }
    
}
