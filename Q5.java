
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q5 extends JFrame implements ActionListener {
    JTextField name;
    JComboBox<String> course;
    JRadioButton male, female;
    JCheckBox java, python, dbms;
    JButton submit, reset;

    Q5() {
        setTitle("Course Selection Form");
        setSize(400, 350);
        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Student Name:"));
        name = new JTextField();
        add(name);

        add(new JLabel("Course:"));
        course = new JComboBox<>(new String[]{
            "BCA", "B.Tech", "BBA", "MCA"
        });
        add(course);

        add(new JLabel("Gender:"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        add(genderPanel);

        add(new JLabel("Subjects:"));
        java = new JCheckBox("Java");
        python = new JCheckBox("Python");
        dbms = new JCheckBox("DBMS");

        JPanel subjectPanel = new JPanel();
        subjectPanel.add(java);
        subjectPanel.add(python);
        subjectPanel.add(dbms);
        add(subjectPanel);

        submit = new JButton("Submit");
        reset = new JButton("Reset");
        add(submit);
        add(reset);

        submit.addActionListener(this);
        reset.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String gender = male.isSelected() ? "Male"
                    : female.isSelected() ? "Female"
                    : "Not Selected";

            String subjects = "";

            if (java.isSelected()) subjects += "Java ";
            if (python.isSelected()) subjects += "Python ";
            if (dbms.isSelected()) subjects += "DBMS ";

            JOptionPane.showMessageDialog(this,
                    "Name: " + name.getText()
                    + "\nCourse: " + course.getSelectedItem()
                    + "\nGender: " + gender
                    + "\nSubjects: " + subjects);
        } else {
            name.setText("");
            course.setSelectedIndex(0);
            male.setSelected(false);
            female.setSelected(false);
            java.setSelected(false);
            python.setSelected(false);
            dbms.setSelected(false);
        }
    }

    public static void main(String[] args) {
        new Q5();
    }
}