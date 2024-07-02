package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pin;
    BalanceEnquiry(String pin) {

        this.pin = pin;

        back = new JButton("BACK");
        back.setBounds(450, 380, 150, 30);
        back.addActionListener(this);
        add(back);

        Conn conn = new Conn();
        int balance = 0;
        try{
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
        JLabel text = new JLabel("Your Current Account Balance is Rs " + balance);
        text.setBounds(148,40,500,30);
        text.setFont(new Font("System", Font.BOLD,22));
        add(text);

        setLayout(null);
        getContentPane().setBackground(new Color(204, 229, 255));
        setSize(700, 500);
        setLocation(370, 180);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin).setVisible(true);

    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
