package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    
    JButton loginButton, clearButton, signupButton;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        //adding title to window
        setTitle("ATM Machine");
        
        //setting layout null so we can use setBounds to manually adjust the components
        setLayout(null);
        
        //adding logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        //adding logo using label
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        //label for title of login frame
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Raleway", Font.BOLD, 38));
        text.setBounds(200, 20, 400, 40);
        add(text);
        
        //label for card no text
        JLabel cardno = new JLabel("Card No :");
        cardno.setFont(new Font("Raleway", Font.PLAIN, 18));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        //adding text field for card no
        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Raleway", Font.PLAIN, 18));
        cardTextField.setBounds(270, 150, 250, 30);
        add(cardTextField);
        
        //label for pin no text
        JLabel pin = new JLabel("PIN No :");
        pin.setFont(new Font("Raleway", Font.PLAIN, 18));
        pin.setBounds(120, 220, 150, 30);
        add(pin);
        
        //adding text field for pin no
        pinTextField = new JPasswordField();
        pinTextField.setFont(new Font("Raleway", Font.PLAIN, 18));
        pinTextField.setBounds(270, 220, 250, 30);
        add(pinTextField);
        
        loginButton = new JButton("SIGN IN");
        loginButton.setBounds(270, 300, 110, 30);
        loginButton.addActionListener(this);
        add(loginButton);
        
        clearButton = new JButton("Clear");
        clearButton.setBounds(410, 300, 110, 30);
        clearButton.addActionListener(this);
        add(clearButton);
        
        signupButton = new JButton("SIGN UP");
        signupButton.setBounds(270, 350, 250, 30);
        signupButton.addActionListener(this);
        add(signupButton);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    public static void main(String args[]) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == clearButton) { //clears the text from text field
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == loginButton) {
            Conn conn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where card_no = '"+cardNumber+"' and pin_no = '"+pinNumber+"'";
            
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()) {
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card number or PIN");
                }
                
            } catch(Exception e) {
                System.out.println(e);
            }
            
        } else if (ae.getSource() == signupButton) { //opens the signup form 1
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
}
