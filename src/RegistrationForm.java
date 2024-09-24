import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrationForm extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, msg;
    JTextField t1, t2;
    JRadioButton r1, r2;
    JTextArea ta;
    JComboBox<String> dayComboBox, monthComboBox, yearComboBox;
    JCheckBox c1;
    JButton submit;
    Container c;

    RegistrationForm() {
        setTitle("Registration Form");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        // Labels
        l1 = new JLabel("Name:");
        l1.setBounds(50, 50, 80, 30);
        c.add(l1);

        l2 = new JLabel("Address:");
        l2.setBounds(50, 100, 80, 30);
        c.add(l2);

        l3 = new JLabel("Gender:");
        l3.setBounds(50, 150, 80, 30);
        c.add(l3);

        l4 = new JLabel("DOB:");
        l4.setBounds(50, 200, 80, 30);
        c.add(l4);

        // TextFields
        t1 = new JTextField();
        t1.setBounds(150, 50, 200, 30);
        c.add(t1);

        t2 = new JTextField();
        t2.setBounds(150, 100, 200, 30);
        c.add(t2);

        // Radio Buttons for Gender
        ButtonGroup bg = new ButtonGroup();
        r1 = new JRadioButton("Male");
        r1.setBounds(150, 150, 80, 30);
        r1.setBackground(Color.GRAY);
        bg.add(r1);
        c.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(250, 150, 80, 30);
        r2.setBackground(Color.GRAY);
        bg.add(r2);
        c.add(r2);

        // Text Area to display all the values
        ta = new JTextArea();
        ta.setBounds(450, 100, 300, 300);
        ta.setLineWrap(true);
        c.add(ta);

        // Date of Birth (DOB) ComboBoxes
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = String.valueOf(i);
        }
        dayComboBox = new JComboBox<>(days);  // Using generics here
        dayComboBox.setBounds(150, 200, 60, 30);
        c.add(dayComboBox);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthComboBox = new JComboBox<>(months);  // Using generics here
        monthComboBox.setBounds(215, 200, 80, 30);
        c.add(monthComboBox);

        String[] years = new String[100];
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(1925 + i);
        }
        yearComboBox = new JComboBox<>(years);  // Using generics here
        yearComboBox.setBounds(300, 200, 80, 30);
        c.add(yearComboBox);

        // Checkbox
        c1 = new JCheckBox("Please accept the terms and conditions.");
        c1.setBounds(80, 250, 300, 30);
        c.add(c1);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(150, 300, 80, 30);
        c.add(submit);

        // Message Label for Registration Success/Error
        msg = new JLabel("");
        msg.setBounds(150, 350, 300, 30);
        c.add(msg);

        submit.addActionListener(this);

        // Display the form
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!c1.isSelected()) {
            msg.setText("Please accept the terms and conditions.");
            ta.setText("");  // Clear the text area if checkbox is not selected
        } else {
            String name = t1.getText();
            String address = t2.getText();
            String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "";
            String dob = dayComboBox.getSelectedItem() + "-" + monthComboBox.getSelectedItem() + "-" + yearComboBox.getSelectedItem();

            if (name.isEmpty()) {
                msg.setText("Please enter your name.");
                ta.setText("");
            } else if (address.isEmpty()) {
                msg.setText("Please enter your address.");
                ta.setText("");
            } else if (gender.isEmpty()) {
                msg.setText("Please select a gender.");
                ta.setText("");
            } else {
                ta.setText(String.format("Name: %s\nAddress: %s\nGender: %s\nDOB: %s", name, address, gender, dob));
                msg.setText("Registration Successful!!");

                // Writing to a file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reg.txt", true))) {
                    writer.write("Name: " + name);
                    writer.write("\nAddress: " + address);
                    writer.write("\nGender: " + gender);
                    writer.write("\nDOB: " + dob);
                    writer.newLine();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
