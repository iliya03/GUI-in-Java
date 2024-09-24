import javax.swing.*;
import java.awt.*;

public class Example2 extends JFrame {
    JLabel l1, l2;
    JTextField t1;
    Container c;

    Example2(){
        setTitle("Iliya");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        c = this.getContentPane();
        c.setLayout(null);
        c.setBackground(Color.GRAY);

        l1 = new JLabel();// for the image
        ImageIcon icon = new ImageIcon("E://Java_Learnings//GUI//src//profile.jpg");
        l1.setIcon(icon);
        l1.setBounds(120, 120, icon.getIconWidth(), icon.getIconHeight());
        c.add(l1);

        l2 = new JLabel("Iliya");
        l2.setBounds(0, 80, 60, 15);
        Font f = new Font("Calibri", Font.ITALIC, 16);
        l2.setFont(f);
        c.add(l2);

        t1 = new JTextField("PKC");
        Font fn = new Font("Arial", Font.BOLD, 16);
        t1.setFont(fn);
        t1.setBounds(0, 20, 60, 30);
        t1.setForeground(Color.BLUE);
        t1.setBackground(Color.cyan);
        t1.setEditable(false);
        c.add(t1);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Example2();
    }
}
