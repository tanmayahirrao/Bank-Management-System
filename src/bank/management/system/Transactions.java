
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    JButton deposite, cashWithdraw, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    Transactions(String pinNumber) {
        
        this.pinNumber = pinNumber;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 1125, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1100, 1125);
        add(image);
        
        JLabel text1 = new JLabel("Please select your Transaction");
        text1.setFont(new Font("System", Font.BOLD, 18));
        text1.setForeground(Color.WHITE);
        text1.setBounds(255, 400, 700, 35);
        image.add(text1);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(200, 520, 150, 35);
        deposite.addActionListener(this);
        image.add(deposite);
        
        cashWithdraw = new JButton("Cash Withdraw");
        cashWithdraw.setBounds(470, 520, 150, 35);
        cashWithdraw.addActionListener(this);
        image.add(cashWithdraw);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(200, 563, 150, 35);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(470, 563, 150, 35);
        miniStatement.addActionListener(this);
        image.add(miniStatement);
        
        pinChange = new JButton("PIN Change");
        pinChange.setBounds(200, 606, 150, 35);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(470, 606, 150, 35);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(470, 649, 150, 35);
        exit.addActionListener(this);
        image.add(exit);
        
        setLayout(null);
        setTitle("ATM Transaction");
        setSize(1100, 1125);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit) {
            System.exit(0);
        }else if(ae.getSource() == deposite) {
            setVisible(false);
            new Deposite(pinNumber).setVisible(true);
        }else if(ae.getSource() == cashWithdraw) {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }else if(ae.getSource() == fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }else if(ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }else if(ae.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        }else if(ae.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }  
    }
    public static void main(String args[]) {
        new Transactions("");
    }
}
