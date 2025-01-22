package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton savingAcc, fixedAcc, currentAcc, recurringAcc;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submitButton, cancelButton;
    String formno;
    
    SignupThree(String formno) {
        this.formno = formno;
        
        setLayout(null);
        setTitle("New Account Application Form - Page 4");
        
        JLabel accDetails = new JLabel("Page 3: Account Details");
        accDetails.setFont(new Font("Dialog", Font.BOLD, 24));
        accDetails.setBounds(250, 40, 400, 40);
        add(accDetails);
        
        JLabel accType = new JLabel("Account Type");
        accType.setFont(new Font("Dialog", Font.BOLD, 22));
        accType.setBounds(100, 140, 200, 30);
        add(accType);
        
        savingAcc = new JRadioButton(" Savings Account");
        savingAcc.setFont(new Font("Dialog", Font.BOLD, 16));
        savingAcc.setBounds(100, 180, 180, 20);
        savingAcc.setBackground(Color.WHITE);
        add(savingAcc);
        
        fixedAcc = new JRadioButton(" Fixed Deposite Account");
        fixedAcc.setFont(new Font("Dialog", Font.BOLD, 16));
        fixedAcc.setBounds(380, 180, 250, 20);
        fixedAcc.setBackground(Color.WHITE);
        add(fixedAcc);
        
        currentAcc = new JRadioButton(" Current Account");
        currentAcc.setFont(new Font("Dialog", Font.BOLD, 16));
        currentAcc.setBounds(100, 220, 180, 20);
        currentAcc.setBackground(Color.WHITE);
        add(currentAcc);
        
        recurringAcc = new JRadioButton(" Recurring Deposite Account");
        recurringAcc.setFont(new Font("Dialog", Font.BOLD, 16));
        recurringAcc.setBounds(380, 220, 300, 20);
        recurringAcc.setBackground(Color.WHITE);
        add(recurringAcc);
        
        ButtonGroup accTypeGroup = new ButtonGroup();
        accTypeGroup.add(savingAcc);
        accTypeGroup.add(fixedAcc);
        accTypeGroup.add(currentAcc);
        accTypeGroup.add(recurringAcc);
        
        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Dialog", Font.BOLD, 22));
        cardNo.setBounds(100, 300, 200, 30);
        add(cardNo);
        
        JLabel cardNoMetaData = new JLabel("Your 16 Digit Card Number");
        cardNoMetaData.setFont(new Font("Dialog", Font.BOLD, 12));
        cardNoMetaData.setBounds(100, 330, 200, 30);
        add(cardNoMetaData);
        
        JLabel cardNoDetails = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNoDetails.setFont(new Font("Dialog", Font.BOLD, 22));
        cardNoDetails.setBounds(370, 300, 300, 30);
        add(cardNoDetails);
        
        JLabel pinNo = new JLabel("PIN:");
        pinNo.setFont(new Font("Dialog", Font.BOLD, 22));
        pinNo.setBounds(100, 370, 200, 30);
        add(pinNo);
        
        JLabel pinNoMetaData = new JLabel("Your 4 Digit Password");
        pinNoMetaData.setFont(new Font("Dialog", Font.BOLD, 12));
        pinNoMetaData.setBounds(100, 400, 200, 30);
        add(pinNoMetaData);
        
        JLabel pinNoDetails = new JLabel("XXXX");
        pinNoDetails.setFont(new Font("Dialog", Font.BOLD, 22));
        pinNoDetails.setBounds(370, 370, 100, 30);
        add(pinNoDetails);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Dialog", Font.BOLD, 22));
        services.setBounds(100, 480, 250, 30);
        add(services);
        
        c1 = new JCheckBox(" ATM card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Dialog", Font.BOLD, 16));
        c1.setBounds(100, 520, 200, 30);
        add(c1);
        
        c2 = new JCheckBox(" Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Dialog", Font.BOLD, 16));
        c2.setBounds(380, 520, 200, 30);
        add(c2);
        
        c3 = new JCheckBox(" Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Dialog", Font.BOLD, 16));
        c3.setBounds(100, 560, 200, 30);
        add(c3);
        
        c4 = new JCheckBox(" Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Dialog", Font.BOLD, 16));
        c4.setBounds(380, 560, 200, 30);
        add(c4);
        
        c5 = new JCheckBox(" Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Dialog", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);
        
        c6 = new JCheckBox(" E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Dialog", Font.BOLD, 16));
        c6.setBounds(380, 600, 200, 30);
        add(c6);
        
        c7 = new JCheckBox(" I hereby declare that the above entered details are correct to the best of my knowledege.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Dialog", Font.BOLD, 12));
        c7.setBounds(100, 700, 670, 30);
        add(c7);
        
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Dialog", Font.BOLD, 16));
        submitButton.setBounds(270, 750, 100, 30);
        submitButton.addActionListener(this);
        add(submitButton);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("Dialog", Font.BOLD, 16));
        cancelButton.setBounds(420, 750, 100, 30);
        cancelButton.addActionListener(this);
        add(cancelButton);
        
        setSize(850, 870);
        setVisible(true);
        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);
    }
            //--------------------------------------------------
        //Fuction to generate card number

        public static String generateCardNumber() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        // Generate 16 digits
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);  // Generates a random digit (0-9)
            cardNumber.append(digit);
        }

        return cardNumber.toString();
    }
        
        //----------------------------------------------------------------------------
        //function to generate pin number
        public static String generatePinNumber() {
        Random random = new Random();
        StringBuilder pinNumber = new StringBuilder();

        // Generate 16 digits
        for (int i = 0; i < 4; i++) {
            int digit = random.nextInt(10);  // Generates a random digit (0-9)
            pinNumber.append(digit);
        }

        return pinNumber.toString();
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == submitButton) {
            
            //Radio Button
            String accountType = null;
            if(savingAcc.isSelected()) {
                accountType = "Saving Account";
            }else if(fixedAcc.isSelected()) {
                accountType = "Fixed Deposite Account";
            }else if(currentAcc.isSelected()) {
                accountType = "Current Account";
            }else if(recurringAcc.isSelected()) {
                accountType = "Recurring Deposite Account";
            }
            
            //generating card and pin number
            String cardNumber = generateCardNumber();
            String pinNumber = generatePinNumber();
            
            //Check Box
            String facility = "";
            if(c1.isSelected()) {
                facility = facility + " ATM card";
            }else if(c2.isSelected()) {
                facility = facility + " Internet Banking";
            }else if(c3.isSelected()) {
                facility = facility + " Mobile Banking";
            }else if(c4.isSelected()) {
                facility = facility + " Email & SMS Alerts";
            }else if(c5.isSelected()) {
                facility = facility + " Cheque Book";
            }else if(c6.isSelected()) {
                facility = facility + " E-Statement";
            }
            
            
            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n" + "PIN: " + pinNumber);
                    
                    setVisible(false);
                    new Deposite(pinNumber).setVisible(true);
                }
                
            }catch(Exception e) {
                System.out.println(e);
            }
        }else if (ae.getSource() == cancelButton) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]) {
        new SignupThree("");
    }
    
}
