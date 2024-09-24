import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comp extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JRadioButton r1, r2;
    JTextArea ta;
    JComboBox cb;
    Container c;

    Comp(){
        setTitle("AWT components");
        setSize(800,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        l1 = new JLabel("Gender:");
        l1.setBounds(10, 100, 80, 30);
        c.add(l1);

        l2 = new JLabel("Password:");
        l2.setBounds(10, 140, 80, 30);
        c.add(l2);

        l3 = new JLabel("CheckBox:");
        l3.setBounds(10, 180, 80, 30);
        c.add(l3);

        l4 = new JLabel("Country:");
        l4.setBounds(10, 260, 80, 30);
        c.add(l4);

        //Radio Button
        ButtonGroup bg = new ButtonGroup();
        r1 = new JRadioButton("Male");
        r1.setBounds(80, 100, 60, 30);
        c.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(150, 100, 80, 30);
        c.add(r2);
        r2.setSelected(true);

        //PasswordField
        JPasswordField p = new JPasswordField();
        p.setBounds(80, 140, 150, 30);
        p.setEchoChar('#'); // default char is dot and by setting echochar we can change the char
        c.add(p);

        //CheckBox
        JCheckBox c1 = new JCheckBox("Advanced Java");
        c1.setBounds(80, 180, 150, 30);
        c.add(c1);

        JCheckBox c2 = new JCheckBox("DWDM");
        c2.setBounds(80, 220, 150, 30);
        c.add(c2);
        c2.setEnabled(false);

        //ComboBox
        String [] val = {"Nepal", "India", "China", "Pakistan", "Bangladesh"};
        cb = new JComboBox(val);
        cb.setBounds(80, 260, 150, 30);
        c.add(cb);

        //TextArea
        ta = new JTextArea();
        ta.setBounds(240, 260, 200, 200);
        c.add(ta);
        ta.setLineWrap(true);

        cb.addActionListener(this);
        setVisible(true);
    }
        public void actionPerformed (ActionEvent e){
        ta.setText("Country = " + cb.getSelectedItem());
        }

    public static void main(String[] args) {
        new Comp();
    }
}
