
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class signupOne extends JFrame implements ActionListener{
    long rand;
    JTextField nameTextField,fnameTextField,emailTextField,addTextField,cityTextField,sTextField,pinTextField;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser date;
    JButton next;
    signupOne(){
        setLayout(null);
        
        Random ran=new Random();
        rand=Math.abs((ran.nextLong()%9000l)+1000l);
        
        
        JLabel formno=new JLabel("Application No: " + rand);
        formno.setFont(new Font("raleway",Font.BOLD,38));
        formno.setBounds(220,20,600,40);
        add(formno);
        
        JLabel personalDetail=new JLabel("Page1 personal details: ");
        personalDetail.setFont(new Font("raleway",Font.BOLD,22));
        personalDetail.setBounds(290,80,400,30);
        add(personalDetail);
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("raleway",Font.BOLD,22));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father Name: ");
        fname.setFont(new Font("raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("raleway",Font.BOLD,22));
        fnameTextField.setBounds(300,190,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        date=new JDateChooser();
        date.setBounds(300,240,200,30);
        date.setForeground(Color.black);
        add(date);
        
        JLabel gen=new JLabel("Gender:");
        gen.setFont(new Font("raleway",Font.BOLD,20));
        gen.setBounds(100,290,200,30);
        add(gen);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,290,80,30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("raleway",Font.BOLD,22));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);
        
        JLabel marStat=new JLabel("Marital Status:");
        marStat.setFont(new Font("raleway",Font.BOLD,20));
        marStat.setBounds(100,390,200,30);
        add(marStat);
        
        married=new JRadioButton("Married");
        married.setBounds(300,390,90,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("UnMarried");
        unmarried.setBounds(450,390,90,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other=new JRadioButton("Other");
        other.setBounds(630,390,90,30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup marryGroup=new ButtonGroup();
        marryGroup.add(married);
        marryGroup.add(unmarried);
        marryGroup.add(other);
        
        JLabel add=new JLabel("Address:");
        add.setFont(new Font("raleway",Font.BOLD,20));
        add.setBounds(100,440,200,30);
        add(add);
        
        addTextField=new JTextField();
        addTextField.setFont(new Font("raleway",Font.BOLD,22));
        addTextField.setBounds(300,440,400,30);
        add(addTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("raleway",Font.BOLD,22));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        sTextField=new JTextField();
        sTextField.setFont(new Font("raleway",Font.BOLD,22));
        sTextField.setBounds(300,540,400,30);
        add(sTextField);
        
        JLabel pin=new JLabel("Pin Code:");
        pin.setFont(new Font("raleway",Font.BOLD,20));
        pin.setBounds(100,590,200,30);
        add(pin);
        
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("raleway",Font.BOLD,22));
        pinTextField.setBounds(300,590,400,30);
        add(pinTextField);
        
        next=new JButton("Next");
        next.setForeground(Color.white);
        next.setBackground(Color.black);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(420,650,90,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno= "" + rand;
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="UnMarried";
        }else{
            marital="Other";
        }
        String address=addTextField.getText();
        String city=cityTextField.getText();
        String state=sTextField.getText();
        String pin=pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER VALID NAME");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER FATHER'S NAME");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER DATE OF BIRTH");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER EMAIL ADDRESS");
            }else if(marital.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER MARITAL STATUS");
            }else if(gender.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER GENDER");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER ADDRESS");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER CITY");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER STATE NAME");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"ENYER PIN CODE");
            }else{
                conn c=new conn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + email + "','" + marital + "','" + gender + "','" +address+ "','" + city + "','" + state + "','" + pin + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Signup Successful");
                
                
                setVisible(false);
                new signupTwo(formno).setVisible(true);

            }
        }catch(Exception e){
            System.out.println(e);
        
        }
    }

    public static void main(String[] args) {
        new signupOne();
    
    }
    
}
