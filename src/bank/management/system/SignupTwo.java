
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panNoTextField, aadharNoTextField;
    JButton nextButton;
    JRadioButton yes, no, existingYes, existingNo;
    JComboBox religionList, categoryList, incomeList, qualificationList, occupationList;
    String formno;

    SignupTwo(String formno) {
        
        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 3");
        
        //-------------------------------------------------------------------------------------------
       
        JLabel additionalDetails = new JLabel("Page 2: Additonal Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 24));
        additionalDetails.setBounds(200, 60, 400, 30);
        add(additionalDetails);
        
        //----------------------------------------------------------------------------------------
        
        
        //religion
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 18));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String arrReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionList = new JComboBox(arrReligion);
        religionList.setBounds(300, 140, 400, 30);
        religionList.setBackground(Color.WHITE);
        add(religionList);
        
        //category
        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String arrCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryList = new JComboBox(arrCategory);
        categoryList.setBounds(300, 190, 400, 30);
        categoryList.setBackground(Color.WHITE);
        add(categoryList);
        
        //Income
        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 18));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String arrIncome[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
        incomeList = new JComboBox(arrIncome);
        incomeList.setBounds(300, 240, 400, 30);
        incomeList.setBackground(Color.WHITE);
        add(incomeList);
     
        //Educational Qualification
        JLabel qualificaiton = new JLabel("Education:");
        qualificaiton.setFont(new Font("Raleway", Font.BOLD, 18));
        qualificaiton.setBounds(100, 290, 200, 30);
        add(qualificaiton);
        
        String arrQualification[] = {"Non-Graduate", "Diploma", "Graduate", "Post-Graduate", "PHD", "Other"};
        qualificationList = new JComboBox(arrQualification);
        qualificationList.setBounds(300, 290, 400, 30);
        qualificationList.setBackground(Color.WHITE);
        add(qualificationList);
           
        //Email ID
        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 18));
        occupation.setBounds(100, 340, 200, 30);
        add(occupation);
        
        String arrOccupation[] = {"Salaried", "Self-Employeed", "Business", "Student", "Retierd", "Other"};
        occupationList = new JComboBox(arrOccupation);
        occupationList.setBounds(300, 340, 400, 30);
        occupationList.setBackground(Color.WHITE);
        add(occupationList);
           
        //Marital Status
        JLabel panNo = new JLabel("PAN No:");
        panNo.setFont(new Font("Raleway", Font.BOLD, 18));
        panNo.setBounds(100, 390, 200, 30);
        add(panNo);
        
        panNoTextField = new JTextField();
        panNoTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        panNoTextField.setBounds(300, 390, 400, 30);
        add(panNoTextField);
        
        //Address
        JLabel aadharNo = new JLabel("Aadhar No:");
        aadharNo.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharNo.setBounds(100, 440, 200, 30);
        add(aadharNo);
       
        aadharNoTextField = new JTextField();
        aadharNoTextField.setFont(new Font("Raleway", Font.BOLD, 18));
        aadharNoTextField.setBounds(300, 440, 400, 30);
        add(aadharNoTextField);
    
        
        //City
        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorCitizen.setBounds(100, 490, 200, 30);
        add(seniorCitizen);
        
        yes = new JRadioButton(" Yes");
        yes.setFont(new Font("Raleway", Font.BOLD, 16));
        yes.setBounds(300, 490, 120, 30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no = new JRadioButton(" No");
        no.setFont(new Font("Raleway", Font.BOLD, 16));
        no.setBounds(430, 490, 120, 30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup seniorCitizenGroup = new ButtonGroup();
        seniorCitizenGroup.add(yes);
        seniorCitizenGroup.add(no);
        
        
        //State
        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Raleway", Font.BOLD, 18));
        existingAcc.setBounds(100, 540, 200, 30);
        add(existingAcc);

        existingYes = new JRadioButton(" Yes");
        existingYes.setFont(new Font("Raleway", Font.BOLD, 16));
        existingYes.setBounds(300, 540, 120, 30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);
        
        existingNo = new JRadioButton(" No");
        existingNo.setFont(new Font("Raleway", Font.BOLD, 16));
        existingNo.setBounds(430, 540, 120, 30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);
        
        ButtonGroup existingAccGroup = new ButtonGroup();
        existingAccGroup.add(existingYes);
        existingAccGroup.add(existingNo);
      
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
            //String formno = "" + random; //long to String convertion using concatination
            String religion = (String) religionList.getSelectedItem();
            String category = (String) categoryList.getSelectedItem();
            String income = (String) incomeList.getSelectedItem();
            String qualification = (String) qualificationList.getSelectedItem();
            String occupation = (String) occupationList.getSelectedItem();
            String panNo = panNoTextField.getText();
            String aadharNo = aadharNoTextField.getText();
            
            String seniorCitizen = null;
            if(yes.isSelected()) {
                seniorCitizen = "Yes";
            } else if (no.isSelected()) {
                seniorCitizen = "No";
            }
            
            String existingAcc = null;
            if(existingYes.isSelected()) {
                existingAcc = "Yes ";
            } else if(existingNo.isSelected()){
                existingAcc = "No";
            }
            
            //warning for empty fields
            try {
                    Conn c = new Conn();
                    String query = "insert into signuptwo values ('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+qualification+"', '"+occupation+"', '"+panNo+"', '"+aadharNo+"', '"+seniorCitizen+"', '"+existingAcc+"')";
                    c.s.executeUpdate(query);
                    
                    setVisible(false);
                    new SignupThree(formno).setVisible(true);
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }

    public static void main(String args[]) {
        new SignupTwo("");
    }

}
