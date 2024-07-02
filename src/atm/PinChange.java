package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pin, rePin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber) {

        this.pinnumber = pinnumber;
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 22));
        text.setBounds(230, 60, 500, 30);
        add(text);

        JLabel pinText = new JLabel("NEW PIN: ");
        pinText.setFont(new Font("System", Font.BOLD, 22));
        pinText.setBounds(100, 130, 200, 30);
        add(pinText);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(280, 130, 200, 30);
        add(pin);

        JLabel rePinText = new JLabel("CONFIRM PIN: ");
        rePinText.setFont(new Font("System", Font.BOLD, 22));
        rePinText.setBounds(100, 180, 200, 30);
        add(rePinText);

        rePin = new JPasswordField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 16));
        rePin.setBounds(280, 180, 200, 30);
        add(rePin);

        change = new JButton("CHANGE");
        change.setBounds(450, 330, 150, 30);
        change.setBackground(Color.WHITE);
        change.addActionListener(this);
        add(change);

        back = new JButton("BACK");
        back.setBounds(450, 380, 150, 30);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setLayout(null);
        getContentPane().setBackground(new Color(204, 229, 255));
        setSize(700, 500);
        setLocation(370, 180);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String nPin = pin.getText();
                String rPin = rePin.getText();

                if(nPin.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                else if(rPin.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                    return;
                }
                else if(!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+rPin+"' where pin = '" + pinnumber+"'";
                String query2 = "update login set pin = '"+rPin+"' where pin = '" + pinnumber+"'";
                String query3 = "update signupthree set pin = '"+rPin+"' where pin = '" + pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rPin).setVisible(true);

            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }


}
