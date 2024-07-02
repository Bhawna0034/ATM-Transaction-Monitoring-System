package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JLabel text,cardNumber, pin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    JButton signIn, clear, signup;

    Login()  {
        setTitle("ATM");

        text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,450,40);
        add(text);

        cardNumber = new JLabel("Card No:");
        cardNumber.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNumber.setBounds(125,150,375,30);
        add(cardNumber);

        cardTextField = new JTextField(15);
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(125,220,375,30);
        add(pin);

        pinTextField = new JPasswordField(15);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);

        signIn = new JButton("SIGN IN");
        signIn.setBackground(Color.BLACK);
        signIn.setForeground(Color.WHITE);

        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);

        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        setLayout(null);

        signIn.setFont(new Font("Arial", Font.BOLD, 14));
        signIn.setBounds(300,300,100,30);
        add(signIn);

        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setBounds(430,300,100,30);
        add(clear);

        signup.setFont(new Font("Arial", Font.BOLD, 14));
        signup.setBounds(300,350,230,30);
        add(signup);

        signIn.addActionListener(this);
        clear.addActionListener(this);
        signup.addActionListener(this);

        getContentPane().setBackground(new Color(204,229,255));

        setSize(800,480);
        setLocation(350,200);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        try{
            if(ae.getSource()== signIn){
                Conn conn = new Conn();
                String cardNumber  = cardTextField.getText();
                String pin  = pinTextField.getText();
                String query  = "select * from login where cardnumber = '"+cardNumber+"' and pin = '"+pin+"'";

                try{
                    ResultSet rs =  conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pin).setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource()== clear){
                cardTextField.setText("");
                pinTextField.setText("");
            }else if(ae.getSource()== signup){
                setVisible(false);
                new Signup().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Login().setVisible(true);
    }


}


