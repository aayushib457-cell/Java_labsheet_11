
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q7 extends JFrame implements ActionListener {
    JTextField temperature;
    JRadioButton cToF, fToC;
    JButton convert, clear;
    JLabel result;

    Q7() {
        setTitle("Temperature Converter");
        setSize(400, 250);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("Enter Temperature:"));
        temperature = new JTextField();
        add(temperature);

        add(new JLabel("Conversion:"));

        cToF = new JRadioButton("Celsius to Fahrenheit");
        fToC = new JRadioButton("Fahrenheit to Celsius");

        ButtonGroup bg = new ButtonGroup();
        bg.add(cToF);
        bg.add(fToC);

        JPanel p = new JPanel();
        p.add(cToF);
        p.add(fToC);
        add(p);

        convert = new JButton("Convert");
        clear = new JButton("Clear");

        add(convert);
        add(clear);

        result = new JLabel("Result: ");
        add(result);

        convert.addActionListener(this);
        clear.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convert) {
            try {
                double temp = Double.parseDouble(temperature.getText());
                double ans;

                if (cToF.isSelected()) {
                    ans = (temp * 9 / 5) + 32;
                    result.setText("Fahrenheit: " + ans);
                } else if (fToC.isSelected()) {
                    ans = (temp - 32) * 5 / 9;
                    result.setText("Celsius: " + ans);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "Please select a conversion!");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid temperature!");
            }
        } else {
            temperature.setText("");
            result.setText("Result: ");
            cToF.setSelected(false);
            fToC.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new Q7();
    }
}