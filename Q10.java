
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q10 extends JFrame implements ActionListener {
    JTextField account, name, balance, amount;
    JButton deposit, withdraw, check, clear;

    Q10() {
        setTitle("Mini Banking Application");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Account Number:"));
        account = new JTextField();
        add(account);

        add(new JLabel("Customer Name:"));
        name = new JTextField();
        add(name);

        add(new JLabel("Current Balance:"));
        balance = new JTextField();
        add(balance);

        add(new JLabel("Amount:"));
        amount = new JTextField();
        add(amount);

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");
        check = new JButton("Check Balance");
        clear = new JButton("Clear");

        add(deposit);
        add(withdraw);
        add(check);
        add(clear);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        check.addActionListener(this);
        clear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == deposit) {
                double bal = Double.parseDouble(balance.getText());
                double amt = Double.parseDouble(amount.getText());

                if (bal < 0 || amt <= 0)
                    throw new NumberFormatException();

                bal += amt;
                balance.setText(String.valueOf(bal));

                JOptionPane.showMessageDialog(this,
                        "Amount Deposited Successfully!");

            } else if (e.getSource() == withdraw) {
                double bal = Double.parseDouble(balance.getText());
                double amt = Double.parseDouble(amount.getText());

                if (bal < 0 || amt <= 0)
                    throw new NumberFormatException();

                if (amt <= bal) {
                    bal -= amt;
                    balance.setText(String.valueOf(bal));

                    JOptionPane.showMessageDialog(this,
                            "Withdrawal Successful!");
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Insufficient Balance!");
                }

            } else if (e.getSource() == check) {
                double bal = Double.parseDouble(balance.getText());

                if (bal < 0)
                    throw new NumberFormatException();

                JOptionPane.showMessageDialog(this,
                        "Account Number: " + account.getText()
                        + "\nCustomer Name: " + name.getText()
                        + "\nCurrent Balance: " + bal);

            } else {
                account.setText("");
                name.setText("");
                balance.setText("");
                amount.setText("");
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid positive numbers!");
        }
    }

    public static void main(String[] args) {
        new Q10();
    }
}