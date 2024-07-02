package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1, r2;
    JCheckBox c1;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(250,40,400,40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBackground(new Color(204, 229,255));
        r1.setBounds(100,180,250,20);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBackground(new Color(204, 229,255));
        r2.setBounds(100,220,250,20);
        add(r2);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);

        JLabel card = new JLabel("Card Number: ");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184 ");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);

        JLabel cardDetails = new JLabel("Your 16 Digit Card Number ");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        cardDetails.setBounds(100,330,300,20);
        add(cardDetails);

        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinNumber.setBounds(330,370,300,30);
        add(pinNumber);

        JLabel pinDetails = new JLabel("Your 4 Digit Password");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pinDetails.setBounds(100,400,300,20);
        add(pinDetails);

        c1 = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        c1.setBackground(new Color(204, 229,255));
        c1.setFont(new Font("Raleway", Font.BOLD,12));
        c1.setBounds(100, 480, 560, 30);
        add(c1);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(220,550,100,30 );
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,550,100,30 );
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(new Color(204, 229,255));
        setSize(750,750);
        setLocation(350,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }else if(r2.isSelected()){
                accountType = "Current Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 900000000L) + 5040936200000000L);
            String pin = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            try{
                if(accountType.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('" +formno+" ', '"+accountType+"', '"+cardnumber+"','"+pin+"')";
                    String query2 =  "insert into login values('" +formno+"','"+cardnumber+"', '"+pin+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pin );

                    setVisible(false);
                    new Login().setVisible(true);

                }

            }catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        }else if(e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }

    }

    public static void main(String[] args) {

        new SignupThree("").setVisible(true);
    }
}
