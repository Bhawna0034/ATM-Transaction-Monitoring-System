package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pin;
    public Withdrawal(String pin) {

        this.pin = pin;

        setTitle("Withdrawal");
        setLayout(null);
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setFont(new Font("System", Font.BOLD,22));
        text.setBounds(148,40,500,30);
        add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD,16));
        amount.setBounds(100, 100, 500, 30);
        add(amount);

        withdraw = new JButton("Cash Withdraw");
        withdraw.setBounds(450, 330, 150, 30);
        withdraw.setFont(new Font("Raleway", Font.BOLD, 14));
        withdraw.setBackground(Color.WHITE);
        withdraw.addActionListener(this);
        add(withdraw);

        back = new JButton("Back");
        back.setBounds(450, 380, 150, 30);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
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
        if(e.getSource()==withdraw){
            String number = amount.getText();
            Date date = new Date();
            if(number.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            }
            else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values ('" + pin + "', '" + date + "', 'withdraw', '" + number + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + number + " Withdrawal Successfully");
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
        new Withdrawal("");
    }
}
