
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Q8 extends JFrame implements ActionListener {
    JTextArea area;
    JMenuItem newFile, open, save, exit;

    Q8() {
        setTitle("Simple Notepad");
        setSize(600, 450);

        area = new JTextArea();
        add(new JScrollPane(area));

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");

        newFile = new JMenuItem("New");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(exit);

        menuBar.add(file);
        setJMenuBar(menuBar);

        newFile.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newFile) {
            area.setText("");
        }

        else if (e.getSource() == open) {
            JFileChooser chooser = new JFileChooser();

            if (chooser.showOpenDialog(this)
                    == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = chooser.getSelectedFile();

                    BufferedReader br = new BufferedReader(
                            new FileReader(file));

                    area.setText("");
                    String line;

                    while ((line = br.readLine()) != null) {
                        area.append(line + "\n");
                    }

                    br.close();

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error opening file!");
                }
            }
        }

        else if (e.getSource() == save) {
            JFileChooser chooser = new JFileChooser();

            if (chooser.showSaveDialog(this)
                    == JFileChooser.APPROVE_OPTION) {
                try {
                    FileWriter writer = new FileWriter(
                            chooser.getSelectedFile());

                    writer.write(area.getText());
                    writer.close();

                    JOptionPane.showMessageDialog(this,
                            "File Saved Successfully!");

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error saving file!");
                }
            }
        }

        else if (e.getSource() == exit) {
            dispose();
        }
    }

    public static void main(String[] args) {
        new Q8();
    }
}