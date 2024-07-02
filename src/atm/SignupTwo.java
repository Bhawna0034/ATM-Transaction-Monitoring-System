package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements  ActionListener{

    JTextField  panTextField, aadharTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religionComboBox, categoryComboBox, qualificationComboBox, occupationComboBox, incomeComboBox;
    String formno;
    SignupTwo(String formno){

        this.formno = formno;
        setLayout(null);
        setTitle("New Account Application Form - Page 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details ");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100,140,100,30);
        add(religion);

        String[] religionCategory = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionComboBox = new JComboBox(religionCategory);
        religionComboBox.setBounds(300, 140, 400,30);
        religionComboBox.setBackground(Color.WHITE);
        add(religionComboBox);

        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,190,200,30);
        add(category);

        String[] Category = {"General", "OBC", "SC", "ST", "Other"};
        categoryComboBox = new JComboBox(Category);
        categoryComboBox.setBounds(300, 190, 400,30);
        categoryComboBox.setBackground(Color.WHITE);
        add(categoryComboBox);

        JLabel income =new JLabel("Income: ");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,240,200,30);
        add(income);

        String[] incomeCategory = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        incomeComboBox = new JComboBox(incomeCategory);
        incomeComboBox.setBounds(300, 240, 400,30);
        incomeComboBox.setBackground(Color.WHITE);
        add(incomeComboBox);

        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100,290,200,30);
        add(educational);

        JLabel qualification = new JLabel("Qualification: ");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,330,200,30);
        add(qualification);

        String[] qualificationCategory = {"Non-Graduation", "Graduation", "Post-Graduation", "Doctorate", "Others"};
        qualificationComboBox = new JComboBox(qualificationCategory);
        qualificationComboBox.setBounds(300, 330, 400,30);
        qualificationComboBox.setBackground(Color.WHITE);
        add(qualificationComboBox);

        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,390,200,30);
        add(occupation);

        String[] occupationCategory = {"Salaried", "Self-Employeed", "Business", "Student", "Retired", "Others"};
        occupationComboBox = new JComboBox(occupationCategory);
        occupationComboBox.setBounds(300, 390, 400,30);
        occupationComboBox.setBackground(Color.WHITE);
        add(occupationComboBox);

        JLabel pan = new JLabel("Pan Number: ");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);


        JLabel aadhar = new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 16));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);


        JLabel senior = new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100,540,200,30);
        add(senior);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,540, 100,30);
        syes.setBackground(new Color(204, 229,255));
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,540, 100,30);
        sno.setBackground(new Color(204, 229,255));
        add(sno);

        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);

        JLabel pincode = new JLabel("Exisiting Account: ");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes = new JRadioButton("No");
        eyes.setBounds(300,590, 100,30);
        eyes.setBackground(new Color(204, 229,255));
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450,590, 100,30);
        eno.setBackground(new Color(204, 229,255));
        add(eno);

        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(new Color(204, 229,255));
        setLayout(null);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = " " ;
        String sreligion = (String) religionComboBox.getSelectedItem();
        String scategory = (String) categoryComboBox.getSelectedItem();
        String sincome = (String)incomeComboBox.getSelectedItem();
        String squalification = (String)qualificationComboBox.getSelectedItem();
        String soccupation = (String)occupationComboBox.getSelectedItem();
        String seniorCitizen = null;
        if(syes.isSelected()){
            seniorCitizen = "Yes";
        }else if(sno.isSelected()){
            seniorCitizen= "No";
        }
        String existingAccount = null;
        if(eyes.isSelected()){
            existingAccount= "Yes";
        }else if(eno.isSelected()){
            existingAccount = "No";
        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();

        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('" +formno+" ', '"+sreligion+"', '"+scategory+"', '"+sincome+"','"+squalification+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        new SignupTwo("").setVisible(true);
    }

}
