
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q4 extends JFrame implements ActionListener {
    JTextField[] marks = new JTextField[5];
    String[] subjects = {
        "English", "Mathematics", "Java", "DBMS",
        "Computer Networks"
    };
    JButton calculate;
    JLabel result;

    Q4() {
        setTitle("Student Marksheet");
        setSize(400, 350);
        setLayout(new GridLayout(7, 2, 5, 5));

        for (int i = 0; i < 5; i++) {
            add(new JLabel(subjects[i] + ":"));
            marks[i] = new JTextField();
            add(marks[i]);
        }

        calculate = new JButton("Calculate Result");
        add(calculate);

        result = new JLabel("Result will appear here");
        add(result);

        calculate.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int total = 0;
            boolean pass = true;

            for (int i = 0; i < 5; i++) {
                int m = Integer.parseInt(marks[i].getText());

                if (m < 0 || m > 100)
                    throw new NumberFormatException();

                total += m;

                if (m < 33)
                    pass = false;
            }

            double percentage = total / 5.0;
            String grade;

            if (!pass)
                grade = "F";
            else if (percentage >= 90)
                grade = "A+";
            else if (percentage >= 80)
                grade = "A";
            else if (percentage >= 70)
                grade = "B";
            else if (percentage >= 60)
                grade = "C";
            else if (percentage >= 50)
                grade = "D";
            else
                grade = "E";

            result.setText("<html>Total: " + total
                    + "<br>Percentage: " + percentage + "%"
                    + "<br>Grade: " + grade
                    + "<br>Status: "
                    + (pass ? "Pass" : "Fail") + "</html>");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Enter valid marks between 0 and 100!");
        }
    }

    public static void main(String[] args) {
        new Q4();
    }
}