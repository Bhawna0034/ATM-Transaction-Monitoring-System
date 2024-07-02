package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton one100, five100, five1000, one1000, ten1000, two1000, back;
    String pin;

    public FastCash(String pin) {

        this.pin = pin;

        JLabel txt = new JLabel("SELECT WITHDRAWAL AMOUNT");
        txt.setBounds(200,80,600,35);
        txt.setFont(new Font("System", Font.BOLD,20));
        add(txt);

        one100 = new JButton("Rs 100");
        one100.setBounds(80, 150, 200, 30 );
        one100.setFont(new Font("System", Font.BOLD, 18));
        one100.setBackground(Color.WHITE);
        one100.addActionListener(this);
        add(one100);


        five100 = new JButton("Rs 500");
        five100.setBounds(380, 150, 200, 30 );
        five100.setFont(new Font("System", Font.BOLD, 18));
        five100.setBackground(Color.WHITE);
        five100.addActionListener(this);
        add(five100);

        one1000 = new JButton("Rs 1000");
        one1000.setBounds(80, 200, 200, 30 );
        one1000.setFont(new Font("System", Font.BOLD, 18));
        one1000.setBackground(Color.WHITE);
        one1000.addActionListener(this);
        add(one1000);

        two1000= new JButton("Rs 2000");
        two1000.setBounds(380, 200, 200, 30 );
        two1000.setFont(new Font("System", Font.BOLD, 18));
        two1000.setBackground(Color.WHITE);
        two1000.addActionListener(this);
        add(two1000);

        five1000 = new JButton("Rs 5000");
        five1000.setBounds(80, 250, 200,30);
        five1000.setFont(new Font("System", Font.BOLD, 18));
        five1000.setBackground(Color.WHITE);
        five1000.addActionListener(this);
        add(five1000);

        ten1000 = new JButton("Rs 10000");
        ten1000.setBounds(380,250, 200,30);
        ten1000.setFont(new Font("System", Font.BOLD, 18));
        ten1000.setBackground(Color.WHITE);
        ten1000.addActionListener(this);
        add(ten1000);

        back = new JButton("BACK");
        back.setBounds(430,350,150,30);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        getContentPane().setBackground(new Color(204, 229,255));

        setLayout(null);
        setSize(700,500);
        setLocation(400,150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== back){
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else{
            String amount = ((JButton)e.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while(rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!= back && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values ('"+pin+"', '"+date+"', 'withdrawal', '"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " + amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }catch(Exception exception){
                System.out.println(exception.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
