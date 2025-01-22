package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailIdTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton nextButton;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dateChooser;

    SignupOne() {
        
        setLayout(null);
        setTitle("New Account Application Form - Page 2");
        
        //-------------------------------------------------------------------------------------------
        
        //generating 4 digit random number
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("Application Form no: " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 30));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        personalDetails.setBounds(200, 60, 400, 30);
        add(personalDetails);
        
        //----------------------------------------------------------------------------------------
        
        
        //name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        //Fathers name
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        
        //Date of Birth
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 16));
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);
        
        
        //Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        male = new JRadioButton(" Male");
        male.setFont(new Font("Raleway", Font.BOLD, 16));
        male.setBounds(300, 290, 120, 30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton(" Female");
        female.setFont(new Font("Raleway", Font.BOLD, 16));
        female.setBounds(430, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other = new JRadioButton(" Other");
        other.setFont(new Font("Raleway", Font.BOLD, 16));
        other.setBounds(560, 290, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(other);
        
        
        //Email ID
        JLabel emailId = new JLabel("Email ID:");
        emailId.setFont(new Font("Raleway", Font.BOLD, 18));
        emailId.setBounds(100, 340, 200, 30);
        add(emailId);
        
        emailIdTextField = new JTextField();
        emailIdTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        emailIdTextField.setBounds(300, 340, 400, 30);
        add(emailIdTextField);
        
        
        //Marital Status
        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 18));
        maritalStatus.setBounds(100, 390, 200, 30);
        add(maritalStatus);
        
        married = new JRadioButton(" Married");
        married.setFont(new Font("Raleway", Font.BOLD, 16));
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);
        
        unmarried = new JRadioButton(" Unmarried");
        unmarried.setFont(new Font("Raleway", Font.BOLD, 16));
        unmarried.setBounds(430, 390, 125, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        
        
        //Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        
        //City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        
        //State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        
        //PIN Code
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 18));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        pincodeTextField.setBounds(300, 590, 400, 30);
        add(pincodeTextField);
        
        
        //Button
        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Raleway", Font.BOLD, 18));
        nextButton.setBounds(590, 660, 110, 30);
        nextButton.addActionListener(this);
        add(nextButton);
        //----------------------------------------------------------------------------------------------
        
        setSize(800,800);
        setVisible(true);
        setLocation(350, 10);
        getContentPane().setBackground(Color.WHITE);
        
        
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            String formno = "" + random; //long to String convertion using concatination
            String name = nameTextField.getText();
            String fname = fnameTextField.getText();
            String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if(male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            } else if(other.isSelected()){
                gender = "Other";
            }
            
            String emailId = emailIdTextField.getText();
            String maritalStatus = null;
            if(married.isSelected()) {
                maritalStatus = "Married";
            } else if(unmarried.isSelected()){
                maritalStatus = "Unmarried";
            }
            
            String address = addressTextField.getText();
            String city = cityTextField.getText();
            String state = stateTextField.getText();
            String pincode = pincodeTextField.getText();
            
            //warning for empty fields
            try {
                if(name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                }else if(fname.equals("")) {
                    JOptionPane.showMessageDialog(null, "Father's Name is required");
                }else if(dob.equals("")) {
                    JOptionPane.showMessageDialog(null, "Date of Birth is required");
                }else if(emailId.equals("")) {
                    JOptionPane.showMessageDialog(null, "Email ID is required");
                }else if(address.equals("")) {
                    JOptionPane.showMessageDialog(null, "Address is required");
                }else if(city.equals("")) {
                    JOptionPane.showMessageDialog(null, "City name is required");
                }else if(state.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name of State is required");
                }else if(pincode.equals("")) {
                    JOptionPane.showMessageDialog(null, "Pin Code is required");
                } else {
                    Conn c = new Conn();
                    String query = "insert into signup values ('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+emailId+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                    c.s.executeUpdate(query);
                    
                    
                    setVisible(false);
                    new SignupTwo(formno).setVisible(true);
                }
            } catch (Exception ae) {
                System.out.println(ae);
            }
                
    }
        
    public static void main(String args[]) {
        new SignupOne();
    }

}
