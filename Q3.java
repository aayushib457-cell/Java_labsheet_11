
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q3 extends JFrame implements ActionListener {
    JTextField username;
    JPasswordField password;
    JButton login, reset;

    Q3() {
        setTitle("Student Login Form");
        setSize(350, 200);
        setLayout(new GridLayout(3, 2, 5, 5));

        add(new JLabel("Username:"));
        username = new JTextField();
        add(username);

        add(new JLabel("Password:"));
        password = new JPasswordField();
        add(password);

        login = new JButton("Login");
        reset = new JButton("Reset");

        add(login);
        add(reset);

        login.addActionListener(this);
        reset.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String u = username.getText();
            String p = new String(password.getPassword());

            if (u.equals("student") && p.equals("1234")) {
                JOptionPane.showMessageDialog(this,
                        "Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password!");
            }
        } else {
            username.setText("");
            password.setText("");
        }
    }

    public static void main(String[] args) {
        new Q3();
    }
}