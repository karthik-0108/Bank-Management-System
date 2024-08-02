
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
public class pinChange extends JFrame implements ActionListener{
    JPasswordField pinField,repinField;
    JButton change,back;
    String pinNumber;
    pinChange(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("CHANGE YOUR PIN:");
        text.setFont(new Font("SYSTEM",Font.BOLD,18));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        image.add(text);
        
        JLabel pinText=new JLabel("New Pin:");
        pinText.setFont(new Font("SYSTEM",Font.BOLD,16));
        pinText.setForeground(Color.WHITE);
        pinText.setBounds(165,320,180,30);
        image.add(pinText);
        
        pinField=new JPasswordField();
        pinField.setFont(new Font("SYSTEM",Font.BOLD,16));
        pinField.setBounds(330,320,180,30);
        image.add(pinField);
        
        
        JLabel repin=new JLabel("Re-Enter Your Pin:");
        repin.setFont(new Font("SYSTEM",Font.BOLD,16));
        repin.setForeground(Color.WHITE);
        repin.setBounds(165,360,180,30);
        image.add(repin);
        
        repinField=new JPasswordField();
        repinField.setFont(new Font("SYSTEM",Font.BOLD,16));
        repinField.setBounds(330,360,180,30);
        image.add(repinField);
        
        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

   
    public static void main(String[] args) {
        new pinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change){
            try{
                String npin=pinField.getText();
                String rpin=repinField.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Pin Don't match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"please enter pin");
                    return;
                }if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-enter the pin");
                    return;
                }
                conn connect=new conn();
                String query1="update withdraw set pin='"+npin+"' where pin='"+pinNumber+"'";
                String query2="update login set pinnumber='"+npin+"'where pinnumber='"+pinNumber+"'";
                String query3="update deposita set pin='"+npin+"'where pin='"+pinNumber+"'";
                String query4="update signupthr set pinnumber='"+npin+"'where pinnumber='"+pinNumber+"'";
                connect.s.executeUpdate(query1);
                connect.s.executeUpdate(query2);
                connect.s.executeUpdate(query3);
                connect.s.executeUpdate(query4);
                JOptionPane.showMessageDialog(null,"pin changed successfully");
                setVisible(false);
                new Transactions(npin).setVisible(true);

            }catch(Exception ae){
                System.out.println(ae);
            }
        }else{
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
}
