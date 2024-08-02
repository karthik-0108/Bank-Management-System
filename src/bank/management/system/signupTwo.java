
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class signupTwo extends JFrame implements ActionListener {
    JTextField panText,aadharText;
    JRadioButton yes,no,govt,priv,other;
    JComboBox cate1,religion1,range1,qual1;
    JButton next;
    String formno;
    signupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2 ");
        setVisible(true);
     
        JLabel additional=new JLabel("PAGE-2 ADDITIONAL DETAILS");
        additional.setFont(new Font("raleway",Font.BOLD,28));
        additional.setBounds(200,80,500,30);
        add(additional);
        
        JLabel religion=new JLabel("RELIGION:");
        religion.setFont(new Font("raleway",Font.BOLD,17));
        religion.setBounds(80,140,160,30);
        add(religion);
        
        String valrel []={"HINDU","CHRISTIAN","MUSLIM","SIKH","JAIN","OTHERS"};
        religion1=new JComboBox(valrel);
        religion1.setBackground(Color.WHITE);
        religion1.setFont(new Font("raleway",Font.BOLD,17));
        religion1.setBounds(300,140,400,30);
        add(religion1);
        
        JLabel cateogory=new JLabel("CATEOGORY:");
        cateogory.setFont(new Font("ralewy",Font.BOLD,17));
        cateogory.setBounds(80,190,160,30);
        add(cateogory);
        
        String caste[]={"OC","BC","SC","ST","OTHER"};
        cate1=new JComboBox(caste);
        cate1.setBackground(Color.WHITE);
        cate1.setFont(new Font("raleway",Font.BOLD,17));
        cate1.setBounds(300,190,400,30);
        add(cate1);
        
        JLabel income=new JLabel("INCOME:");
        income.setFont(new Font("raleway",Font.BOLD,17));
        income.setBounds(80,240,160,30);
        add(income);
        
        String range[]={"3-5LAKHS","5-7LAKHS","7-9LAKHS","9-12LAKHS","12+LAKHS"};
        range1=new JComboBox(range);
        range1.setBackground(Color.WHITE);
        range1.setFont(new Font("raleway",Font.BOLD,17));
        range1.setBounds(300,240,400,30);
        add(range1);
        
        JLabel qualification=new JLabel("QUALIFICATION:");
        qualification.setFont(new Font("raleway",Font.BOLD,17));
        qualification.setBounds(80,290,160,30);
        add(qualification);
        
        String quali[]={"SELF-EMPLOYED","UNDERGRADUATE","POSTGRADUATE","METRICULATION"};
        qual1=new JComboBox(quali);
        qual1.setBackground(Color.WHITE);
        qual1.setBounds(300,290,400,30);
        add(qual1);
        
        JLabel occupation=new JLabel("OCCUPATION:");
        occupation.setFont(new Font("raleway",Font.BOLD,17));
        occupation.setBounds(80,340,160,30);
        add(occupation);
        
        govt=new JRadioButton("GOVERNMENT");
        govt.setBounds(300,340,120,30);
        govt.setBackground(Color.WHITE);
        add(govt);
        
        priv = new JRadioButton("PRIVATE");
        priv.setBounds(440,340,120,30);
        priv.setBackground(Color.WHITE);
        add(priv);
        
        other=new JRadioButton("OTHERS");
        other.setBounds(580,340,120,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup occupation1 = new ButtonGroup();
        occupation1.add(govt);
        occupation1.add(priv);
        occupation1.add(other);
        
        JLabel pan=new JLabel("PAN NUMBER:");
        pan.setBounds(80,390,160,30);
        pan.setFont(new Font("raleway",Font.BOLD,17));
        add(pan);
        
        panText=new JTextField();
        panText.setFont(new Font("raleway",Font.BOLD,17));
        panText.setBounds(300,390,400,30);
        add(panText);
        
        JLabel aadhar=new JLabel("AADHAR NUMBER:");
        aadhar.setBounds(80,440,160,30);
        aadhar.setFont(new Font("raleway",Font.BOLD,17));
        add(aadhar);
        
        aadharText=new JTextField();
        aadharText.setFont(new Font("raleway",Font.BOLD,17));
        aadharText.setBounds(300,440,400,30);
        add(aadharText);
        
        JLabel senior =new JLabel("SENIOR CITIZEN:");
        senior.setFont(new Font("raleway",Font.BOLD,17));
        senior.setBounds(80,490,160,30);
        add(senior);
        
        yes = new JRadioButton("YES");
        yes.setBounds(300,490,120,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no = new JRadioButton("NO");
        no.setBounds(440,490,120,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup seni=new ButtonGroup();
        seni.add(yes);
        seni.add(no);
        
        next=new JButton("NEXT");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("raleway",Font.BOLD,14));
        next.setBounds(550,520,90,30);
        next.addActionListener(this);
        add(next);
        
        

        
        
        setSize(850,600);
        setLocation(350,30);
        getContentPane().setBackground(Color.WHITE);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
       String ereligion= (String) religion1.getSelectedItem();
       String ecateogary=(String) cate1.getSelectedItem();
       String eincome=(String) range1.getSelectedItem();
       String equalification=(String) qual1.getSelectedItem();
       String citizen=null;
       if(yes.isSelected()){
           citizen="yes";
       }if(no.isSelected()){
           citizen="no";
       }
       String occupation=null;
       if(govt.isSelected()){
           occupation="GOVERNMENT";
       }if(priv.isSelected()){
           occupation="PRIVATE";
       }if(other.isSelected()){
           occupation="OTHER";
       }
       String epan=panText.getText();
       String eaadhar=aadharText.getText();
       try{
            if(epan.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER VALID PAN NUMBER");
            }else if(eaadhar.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER AADHAR NUMBER");
            }else{
                conn c=new conn();
                String query = "insert into signupTwo values('" + ereligion + "','" + ecateogary + "','" + eincome + "','" +equalification+ "','" + citizen + "','" + occupation + "','" + epan + "','" +eaadhar+ "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "SignupTwo Successful");
                
                
                

            }
            setVisible(false);
            new signupThree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        
        }
    
    }
    
   
    public static void main(String[] args) {
        new signupTwo("");
    }

}
    
