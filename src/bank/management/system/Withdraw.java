package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener{
    
    JTextField amountTextField;
    JButton withdrawButton, backButton;
    String pinNumber;
    
    Withdraw(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 1125, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 1125);
        add(image);
        
        JLabel text1 = new JLabel("Enter the amount you want to withdraw");
        text1.setFont(new Font("System", Font.BOLD, 18));
        text1.setForeground(Color.WHITE);
        text1.setBounds(210, 400, 700, 35);
        image.add(text1);
        
        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTextField.setBounds(210, 450, 395, 40);
        image.add(amountTextField);
        
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(470, 606, 150, 35);
        withdrawButton.addActionListener(this);
        image.add(withdrawButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(470, 649, 150, 35);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setTitle("Withdraw");
        setSize(1100, 1125);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == withdrawButton) {
            String amountVal = amountTextField.getText();
            Date date = new Date();
            if(amountTextField.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount to withdraw");
            }else {
                try {
                    Conn conn = new Conn();
                    String query1 = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amountVal+"')";
                    conn.s.executeUpdate(query1);
                    
                    JOptionPane.showMessageDialog(null, "Rs "+amountVal+" Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }catch(Exception e) {
                    System.out.println(e);
                }
            }
        }else if(ae.getSource() == backButton) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Withdraw("");
    }
}
