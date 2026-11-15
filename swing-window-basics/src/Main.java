import org.w3c.dom.events.EventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.beans.EventHandler;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {
                    JFrame jFrame = new JFrame(); // создаем пустое окошко

                    jFrame.setSize(640, 480); // задаем параметры окошка
                    jFrame.setLocation(500, 500); // задаем локацию окошка на экране



                    ImageIcon imageIcon = new ImageIcon("images/icon.png");

                    JLabel jLabel = new JLabel(); // создаем область куда можно добавлять текст и картинки
                    jLabel.setText("Dude");
                    jLabel.setIcon(imageIcon);
                    jLabel.setHorizontalTextPosition(JLabel.CENTER);
                    jLabel.setVerticalTextPosition(JLabel.TOP);
                    jLabel.setForeground(Color.GREEN);
                    jLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
                    jLabel.setIconTextGap(-25);
                    jLabel.setBackground(Color.BLACK);
                    jLabel.setOpaque(true);

                    jFrame.setVisible(true); // делаем окошко видимым
                    jFrame.setSize(500,500);
                    jFrame.setTitle("This is my frame"); // даем окошку имя
                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // делаем так, чтобы окошко могло закрываться
                    jFrame.add(jLabel);







///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//                    JFrame.add(jPanel);
//                    JPanel.setLayout(null);
//
//                    JButton jButton = new JButton("submit");
//                    jButton.setBounds(50,50,150,50);
//                    jPanel.add(jButton);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//                    JFrame.add(new JButton("one"), BorderLayout.CENTER); // задаем кнопке располжение

//                    JPanel jPanel = new JPanel(); // создаем панель для кнопок
//                    JFrame.add(jPanel);
//                    JPanel.setLayout(new GridLayout(2,2));
//                    JPanel.add(new JButton("one"));
//                    JPanel.add(new JButton("two"));
//                    JPanel.add(new JButton("three"));
//                    JPanel.add(new JButton("four"));
//                    JPanel.add(new JButton("five"));
//                    JPanel.add(new JButton("six"));
//                    JPanel.add(new JButton("seven"));
//                    JPanel.add(new JButton("eight"));
//                    JPanel.add(new JButton("nine"));
//                    JPanel.add(new JButton("zero"));



/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                    JButton jButton1 = new JButton("Metal");
//                    JButton jButton2 = new JButton("Nimbus");
//                    JButton jButton3 = new JButton("Motif");
//                    JButton jButton4 = new JButton("Mac OS X");
//                    jPanel.add(jButton1);
//                    jPanel.add(jButton2);
//                    jPanel.add(jButton3);
//                    jPanel.add(jButton4);
//
//                    jButton1.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            try {
//                                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//                            } catch (Exception e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    });
//
//
//                    jButton2.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            try {
//                                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//                            } catch (Exception e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    });
//
//                    jButton3.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            try {
//                                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//                            } catch (Exception e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    });
//
//
//                    jButton4.addActionListener(new ActionListener() {
//                        @Override
//                        public void actionPerformed(ActionEvent e) {
//                            try {
//                                UIManager.setLookAndFeel("com.apple.laf.AquaLookAndFeel");
//                            } catch (Exception e1) {
//                                e1.printStackTrace();
//                            }
//                        }
//                    });


//        //просмотр команд
//        UIManager.LookAndFeelInfo [] lookAndFeelInfos = UIManager.getInstalledLookAndFeels();
//        for (UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeelInfos) {
//            System.out.println(lookAndFeelInfo.getName());
//            System.out.println(lookAndFeelInfo.getClassName());
//            }


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        JButton jButton = new JButton("Hello World");
//        JPanel.add(jButton);


//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                jFrame.setBackground(Color.BLUE); // при нажатии кнопки будет закрашиваться окошко в синий
//                jFrame.setTitle(((JButton)e.getSource()).getText()); // при нажатии кнопки окошко будет присваивать себе имя кнопки
//            }
//        }); // делаем так, чтобы кнопка что-то делала


                    // более упрощенная форма записи ^^^
//        jButton.addActionListener(EventHandler.create(ActionListener.class, JFrame, "title", "source.text"));


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    // просмотр шртфтов
//        String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
//        for (String font : fonts) {
//            System.out.println(font);
//        }

//                    jFrame.getContentPane().setLayout(null);
//
//                    jFrame.setSize(640, 480); // задаем параметры окошка
//                    jFrame.setLocation(500, 500); // задаем локацию окошка на экране
//
//                    Toolkit toolkit = Toolkit.getDefaultToolkit();
//                    Dimension screenSize = toolkit.getScreenSize();
//                    jFrame.setBounds(screenSize.width / 2 - 250, screenSize.height / 2 - 150, 500, 300);
//                    // можно написать вместо 16 и 17 строчки, но только, если мы знаем разрешение экрана
//
//                    jFrame.setVisible(true); // делаем окошко видимым
//                    jFrame.setTitle("This is my frame"); // даем окошку имя
//                    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // делаем так, чтобы окошко могло закрываться


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//        JFrame.add(new MyComponent());



                    // класс для рисования
//    static class MyComponent extends JComponent {
//
//        @Override
//        public void paint(Graphics g) {
//            Font font = new Font("Arial", Font.PLAIN, 12);
//            Graphics2D g2 = (Graphics2D) g;
//            g2.setFont(font);
//            g2.drawString("Hello World", 20, 20);
//            Point2D point2D = new Point2D.Double(100,100);
//            Point2D point2D2 = new Point2D.Double(200,200);
//            Line2D line2D = new Line2D.Double(point2D, point2D2);
//            g2.draw(line2D);
//            Ellipse2D ellipse2D = new Ellipse2D.Double(100,100,200,200);
//            g2.draw(ellipse2D); // рисует
//            g2.fill(ellipse2D); // закращивает
//            g2.setPaint(new Color(117, 120, 170)); // цифрами
//            g2.setPaint(Color.red);
//            Rectangle2D rectangle2D = new Rectangle2D.Double(100,100,200,200);
//            g2.draw(rectangle2D);
//
//
//        }
//    }

                }
        );

    }
}