import java.awt.*;
import javax.swing.*;
import java.awt.event.*;// imports the event package for ActionListener and ActionEvent

public class Example extends JFrame implements ActionListener {
    Container c;
    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3, b4, addReset;

    Example() {
        setSize(500, 700);
        setTitle("GUIProgram");
        setLocationRelativeTo(null); //to place the window in the centre of the screen
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = this.getContentPane(); // gets the content pane of the JFrame
        c.setBackground(Color.white);

        l1 = new JLabel("First Number:");
        l2 = new JLabel("Second Number:");
        l3 = new JLabel("Result:");


        c.setLayout(null); // to set the location of label as our wish
        l1.setBounds(20, 50, 100, 20);
        l2.setBounds(20, 80, 100, 20);
        l3.setBounds(20, 140, 100, 20);

        c.add(l1); // Add components individually
        c.add(l2);
        c.add(l3);


        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t1.setBounds(120, 50, 100, 20);
        t2.setBounds(120, 80, 100, 20);
        t3.setBounds(120, 140, 300, 20);

        c.add(t1); // Add components individually
        c.add(t2);
        c.add(t3);
        //t3.setEditable(false); // Make it non-editable

        //in addition
        b1 = new JButton("+");
        b1.setBounds(120, 110, 40, 22);
        c.add(b1);

        //in subtracton
        b2 = new JButton("-");
        b2.setBounds(180, 110, 40, 22);
        c.add(b2);

        //in multiplication
        b3 = new JButton("*");
        b3.setBounds(240, 110, 40, 22);
        c.add(b3);

        //in division
        b4 = new JButton("/");
        b4.setBounds(300, 110, 40, 22);
        c.add(b4);

        //in reset
        addReset = new JButton("Reset");
        addReset.setBounds(120, 170, 80, 20);
        c.add(addReset);

        // Add action listener for the button
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        addReset.addActionListener(this);


        setVisible(true);// this must always be written in the last line of the constructor

    }
        public void actionPerformed (ActionEvent e){ //here actionperformed is the method which overrides the ActionListener interface
            if (e.getSource()==addReset) {
                t1.setText("");
                t2.setText("");
                t3.setText("");

            } else{
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            double result = 0;
                if (e.getSource() == b1){
                    result = a + b;
                } else if (e.getSource() == b2) {
                    result = a - b;
                } else if (e.getSource() == b3) {
                    result = a * b;
                } else if (e.getSource() == b4) {
                    result = a / b;
                }

                t3.setText("" + result);
            }

        }

        public static void main(String[] args) {
        new Example();
    }
}
