package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    
    JButton button100, button500, button1000, button2000, button5000, button10000, backButton;
    String pinNumber;
    
    FastCash(String pinNumber) {
        
        this.pinNumber = pinNumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 1125, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 1125);
        add(image);
        
        JLabel text1 = new JLabel("Select amount to withdraw");
        text1.setFont(new Font("System", Font.BOLD, 18));
        text1.setForeground(Color.WHITE);
        text1.setBounds(265, 400, 700, 35);
        image.add(text1);
        
        button100 = new JButton("Rs 100");
        button100.setBounds(200, 520, 150, 35);
        button100.addActionListener(this);
        image.add(button100);
        
        button500 = new JButton("Rs 500");
        button500.setBounds(470, 520, 150, 35);
        button500.addActionListener(this);
        image.add(button500);
        
        button1000 = new JButton("Rs 1000");
        button1000.setBounds(200, 563, 150, 35);
        button1000.addActionListener(this);
        image.add(button1000);
        
        button2000 = new JButton("Rs 2000");
        button2000.setBounds(470, 563, 150, 35);
        button2000.addActionListener(this);
        image.add(button2000);
        
        button5000 = new JButton("Rs 5000");
        button5000.setBounds(200, 606, 150, 35);
        button5000.addActionListener(this);
        image.add(button5000);
        
        button10000 = new JButton("Rs 10000");
        button10000.setBounds(470, 606, 150, 35);
        button10000.addActionListener(this);
        image.add(button10000);
        
        backButton = new JButton("Back");
        backButton.setBounds(470, 649, 150, 35);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setLayout(null);
        setTitle("ATM Transaction");
        setSize(1100, 1125);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backButton) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //Rs will be removed and 500 will be captured
            Conn conn = new Conn();
            try {
                ResultSet rs = conn.s.executeQuery("select * from bank where pin_no = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposite")) {
                        balance = balance + Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance = balance - Integer.parseInt(rs.getString("amount"));
                    }
                    
                    if(ae.getSource() != backButton && balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    }
                    
                    Date date = new Date();
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw','"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amount + " debited successfully");
                    
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            }catch(Exception e) {
                System.out.println(e);
            }
        }
        
    }
    public static void main(String args[]) {
        new FastCash("");
    }
}