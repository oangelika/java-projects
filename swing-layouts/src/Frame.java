import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    String[] items = {"Элемент 1", "Элемент 2", "Элемент 3"};

    private JButton button = new JButton("Click Me");
    private JLabel label = new JLabel();
    private JCheckBox checkBox = new JCheckBox();
    private JComboBox comboBox = new JComboBox(items);
    private JTextArea textArea = new JTextArea("Bdjfh");

    public Frame() {
        Panel panel = new Panel();
        this.getContentPane().setLayout(new FlowLayout());
        // BorderLayout, GridLayout, BoxLayout, GridBagLayout
        this.add(panel);
        this.setSize(800, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(button);
        button.setBounds(20,20,200,50);
        label.setText("Click Me");
        panel.add(label);
        label.setBounds(100,100,200,50);
        panel.add(checkBox);
        checkBox.setBounds(300,300,100,70);
        panel.add(comboBox);
        comboBox.setBounds(200,200,60,70);
        comboBox.addItem("cool");
        panel.add(textArea);
        textArea.setBounds(250,150,200,200);






    }
}
