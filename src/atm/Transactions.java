package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawal,balanceEnquiry, fastCash, pinChange, exit;
    String pin;

    public Transactions(String pin) {

        this.pin = pin;

        JLabel txt = new JLabel("Please select your Transaction");
        txt.setBounds(200,80,600,35);
        txt.setFont(new Font("System", Font.BOLD,20));
        add(txt);

        deposit = new JButton("Cash Deposit");
        deposit.setBounds(80, 150, 200, 30 );
        deposit.setFont(new Font("System", Font.BOLD, 18));
        deposit.setBackground(Color.WHITE);
        deposit.addActionListener(this);
        add(deposit);


        withdrawal = new JButton("Cash Withdrawal");
        withdrawal.setBounds(380, 150, 200, 30 );
        withdrawal.setFont(new Font("System", Font.BOLD, 18));
        withdrawal.setBackground(Color.WHITE);
        withdrawal.addActionListener(this);
        add(withdrawal);

        fastCash = new JButton("Fash Cash");
        fastCash.setBounds(80, 200, 200, 30 );
        fastCash.setFont(new Font("System", Font.BOLD, 18));
        fastCash.setBackground(Color.WHITE);
        fastCash.addActionListener(this);
        add(fastCash);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(380, 200, 200, 30 );
        pinChange.setFont(new Font("System", Font.BOLD, 18));
        pinChange.setBackground(Color.WHITE);
        pinChange.addActionListener(this);
        add(pinChange);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(80, 250, 200, 30 );
        balanceEnquiry.setFont(new Font("System", Font.BOLD, 18));
        balanceEnquiry.setBackground(Color.WHITE);
        balanceEnquiry.addActionListener(this);
        add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(380, 250, 200, 30 );
        exit.setFont(new Font("System", Font.BOLD, 18));
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(new Color(204, 229,255));

        setLayout(null);
        setSize(700,500);
        setLocation(400,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==deposit){
            setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if(e.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }
        else if(e.getSource()==fastCash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(e.getSource()==pinChange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(e.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }



    }
    public static void main(String[] args) {
        new Transactions("");
    }
}
