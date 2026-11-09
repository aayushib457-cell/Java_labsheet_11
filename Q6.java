
import java.awt.*;
import java.awt.event.*;

public class Q6 extends Frame implements ActionListener {
    TextField id, name, designation, salary;
    Choice department;
    Checkbox male, female;
    CheckboxGroup gender;
    TextArea output;
    Button submit, clear;

    Q6() {
        setTitle("Employee Registration Form");
        setSize(450, 500);
        setLayout(new GridLayout(9, 2, 5, 5));

        add(new Label("Employee ID:"));
        id = new TextField();
        add(id);

        add(new Label("Name:"));
        name = new TextField();
        add(name);

        add(new Label("Department:"));
        department = new Choice();
        department.add("IT");
        department.add("HR");
        department.add("Finance");
        department.add("Marketing");
        add(department);

        add(new Label("Designation:"));
        designation = new TextField();
        add(designation);

        add(new Label("Salary:"));
        salary = new TextField();
        add(salary);

        add(new Label("Gender:"));
        gender = new CheckboxGroup();
        male = new Checkbox("Male", gender, false);
        female = new Checkbox("Female", gender, false);

        Panel p = new Panel();
        p.add(male);
        p.add(female);
        add(p);

        submit = new Button("Submit");
        clear = new Button("Clear");
        add(submit);
        add(clear);

        add(new Label("Employee Details:"));
        output = new TextArea();
        add(output);

        submit.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                double sal = Double.parseDouble(salary.getText());

                String g = gender.getSelectedCheckbox() == null
                        ? "Not Selected"
                        : gender.getSelectedCheckbox().getLabel();

                output.setText(
                    "Employee ID: " + id.getText()
                    + "\nName: " + name.getText()
                    + "\nDepartment: " + department.getSelectedItem()
                    + "\nDesignation: " + designation.getText()
                    + "\nSalary: " + sal
                    + "\nGender: " + g
                );

            } catch (NumberFormatException ex) {
                output.setText("Please enter a valid salary!");
            }
        } else {
            id.setText("");
            name.setText("");
            designation.setText("");
            salary.setText("");
            department.select(0);
            gender.setSelectedCheckbox(null);
            output.setText("");
        }
    }

    public static void main(String[] args) {
        new Q6();
    }
}