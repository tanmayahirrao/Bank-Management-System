package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PinChange extends JFrame implements ActionListener{
    String pinNumber;
    JButton changeButton, backButton;
    JPasswordField pinEnter, pinReEnter;
    PinChange(String pinNumber) {
        setLayout(null);
        this.pinNumber = pinNumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 1125, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 1125);
        add(image);
        
        JLabel text1 = new JLabel("CHANGE YOUR PIN");
        text1.setFont(new Font("System", Font.BOLD, 18));
        text1.setForeground(Color.WHITE);
        text1.setBounds(310, 380, 200, 35);
        image.add(text1);
        
        JLabel pinText = new JLabel("New PIN:");
        pinText.setFont(new Font("System", Font.BOLD, 18));
        pinText.setForeground(Color.WHITE);
        pinText.setBounds(200, 440, 180, 30);
        image.add(pinText);
        
        pinEnter = new JPasswordField();
        pinEnter.setFont(new Font("System", Font.BOLD, 18));
        pinEnter.setBounds(470, 440, 150, 30);
        image.add(pinEnter);
        
        JLabel pinText2 = new JLabel("Re-Enter New PIN:");
        pinText2.setFont(new Font("System", Font.BOLD, 18));
        pinText2.setForeground(Color.WHITE);
        pinText2.setBounds(200, 480, 200, 30);
        image.add(pinText2);
        
        pinReEnter = new JPasswordField();
        pinReEnter.setFont(new Font("System", Font.BOLD, 18));
        pinReEnter.setBounds(470, 480, 150, 30);
        image.add(pinReEnter);
        
        changeButton = new JButton("Change PIN");
        changeButton.setBounds(470, 606, 150, 35);
        changeButton.addActionListener(this);
        image.add(changeButton);
        
        backButton = new JButton("Back");
        backButton.setBounds(470, 649, 150, 35);
        backButton.addActionListener(this);
        image.add(backButton);
        
        setTitle("Pin Change");
        setSize(1100, 1125);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == changeButton) {
            try {
                String npin = pinEnter.getText();
                String rpin = pinReEnter.getText();
                
                if(!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Enter PIN doesnt match");
                    return;
                }
                
                if(npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the new PIN");
                    return;
                }
                
                if(rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter the new PIN");
                    return;
                }
                
                if(npin.equals(rpin)) {
                    Conn conn = new Conn();
                    String query1 = "update bank set pin_no = '"+rpin+"' where pin_no = '"+pinNumber+"'";
                    String query2 = "update login set pin_no = '"+rpin+"' where pin_no = '"+pinNumber+"'";
                    String query3 = "update signupthree set pin_no = '"+rpin+"' where pin_no = '"+pinNumber+"'";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transactions(rpin).setVisible(true);
                }
            }catch(Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == backButton) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
