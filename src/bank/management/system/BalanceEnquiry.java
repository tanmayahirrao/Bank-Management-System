package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
    
    JButton backButton;
    String pinNumber;
    BalanceEnquiry(String pinNumber) {
        setLayout(null);
        
        this.pinNumber = pinNumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 1125, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 1125);
        add(image);
        
        backButton = new JButton("Back");
        backButton.setBounds(470, 649, 150, 35);
        backButton.addActionListener(this);
        image.add(backButton);
        
        Conn conn = new Conn();
        int balance = 0;
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin_no = '"+pinNumber+"'");
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposite")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e) {
                System.out.println(e);       
            }
            
        JLabel text1 = new JLabel("Your current acc bal is :  Rs " + balance);
        text1.setFont(new Font("System", Font.BOLD, 18));
        text1.setForeground(Color.WHITE);
        text1.setBounds(220, 400, 700, 35);
        image.add(text1);
        
        setTitle("Balance Enquiry");
        setSize(1100, 1125);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
