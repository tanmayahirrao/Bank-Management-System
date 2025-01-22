package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    String pinNumber;
    MiniStatement(String pinNumber) {
        this.pinNumber = pinNumber;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel bank = new JLabel("Bank of India");
        bank.setFont(new Font("System", Font.BOLD, 16));
        bank.setBounds(140, 20, 150, 30);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel miniState = new JLabel();
        miniState.setBounds(20, 100, 400, 200);
        add(miniState);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 310, 400, 30);
        add(balance);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin_no = '"+pinNumber+"'");
            while(rs.next()) {
                card.setText("Card Number: " + rs.getString("card_no").substring(0, 4)+ "-XXXX-XXXX-" + rs.getString("card_no").substring(12));
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        
        try{
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin_no = '"+pinNumber+"'");
            while(rs.next()) {
                miniState.setText(miniState.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><html>");
                
                if(rs.getString("type").equals("Deposite")) {
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                
                balance.setText("Your current account balance is:  Rs " + bal);
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        
        setSize(400, 600);
        setLocation(30, 30);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
