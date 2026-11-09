import java.awt.*;
import java.awt.event.*;

public class Q2 extends Frame implements ActionListener {
    TextField t1, t2;
    Label result;
    Button add, sub, mul, div;

    Q2() {
        setTitle("Simple Calculator");
        setSize(350, 300);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new Label("First Number:"));
        t1 = new TextField();
        add(t1);

        add(new Label("Second Number:"));
        t2 = new TextField();
        add(t2);

        add = new Button("Addition");
        sub = new Button("Subtraction");
        mul = new Button("Multiplication");
        div = new Button("Division");

        add(add);
        add(sub);
        add(mul);
        add(div);

        result = new Label("Result: ");
        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            double ans = 0;

            if (e.getSource() == add)
                ans = a + b;
            else if (e.getSource() == sub)
                ans = a - b;
            else if (e.getSource() == mul)
                ans = a * b;
            else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Cannot divide by zero!");
                    return;
                }
                ans = a / b;
            }

            result.setText("Result: " + ans);

        } catch (NumberFormatException ex) {
            result.setText("Enter valid numbers!");
        }
    }

    public static void main(String[] args) {
        new Q2();
    }
}