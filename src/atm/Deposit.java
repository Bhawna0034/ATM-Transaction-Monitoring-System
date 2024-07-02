package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    JTextField amount;
    JButton deposit, back;
    String pin;
    public Deposit(String pin) {

        this.pin = pin;

        setTitle("Deposit");
        setLayout(null);
        JLabel text = new JLabel("Enter the amount you want to deposit ");
        text.setFont(new Font("System", Font.BOLD,22));
        text.setBounds(148,40,500,30);
        add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,16));
        amount.setBounds(100, 100, 500, 30);
        add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(450, 330, 150, 30);
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        add(deposit);

        back = new JButton("Back");
        back.setBounds(450, 380, 150, 30);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(new Color(204, 229,255));
        setSize(700,500);
        setLocation(370,180);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values ('" + pin + "', '" + date + "', 'Deposit', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                }
            }

        }else if(e.getSource()==back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Deposit("");
    }
}
