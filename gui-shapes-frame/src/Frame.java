import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Frame extends JFrame implements ActionListener{

    private JMenuBar menuBar = new JMenuBar();

    private JMenu fileMenu = new JMenu("File");
    private JMenu drawMenu = new JMenu("Draw");
    private JMenu figureMenu = new JMenu("Figure");

    private JMenuItem openItem = new JMenuItem("Open");
    private JMenuItem saveItem = new JMenuItem("Save");
    private JMenuItem saveAsItem = new JMenuItem("Save As...");
    private JMenuItem quitItem = new JMenuItem("Quit");

    private JMenuItem colorItem = new JMenuItem("Color");
    private JMenuItem clearItem = new JMenuItem("Clear");

    private ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton circleItem = new JRadioButton("Circle");
    private JRadioButton squareItem = new JRadioButton("Square");
    private JRadioButton penItem = new JRadioButton("Pen");

    private JLabel statusLabel = new JLabel("New");
    private JLabel modeLabel = new JLabel(" ");
    private JPanel statusModePanel = new JPanel();

    private List <Shape> shapes = new ArrayList<>();
    private Color currentColor = Color.RED;
    private boolean isDPressed = false;
    private String name="Simple Draw";

    private File currentFile;
    private JPanel contentPane = new JPanel() {
        //private boolean isDPressed = false;



        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape shape : shapes) {
                g.setColor(shape.getColor());
                if (shape.getType().equals("circle")) {
                    g.fillOval(shape.getX() - shape.getSize() / 2, shape.getY() - shape.getSize() / 2, shape.getSize(), shape.getSize());
                } else if (shape.getType().equals("square")) {
                    g.fillRect(shape.getX() - shape.getSize() / 2, shape.getY() - shape.getSize() / 2, shape.getSize(), shape.getSize());
                } else {
                    g.drawLine(shape.getStartX(), shape.getStartY(), shape.getEndX(), shape.getEndY());
                }
            }
        }
    };


    public Frame() {

        UIManager.put("MenuItem.acceleratorForeground", Color.BLUE);

//        JPanel panel = new JPanel();
//        this.getContentPane().setLayout(new FlowLayout());
//        this.add(panel);
        this.setSize(300, 300);

        this.setJMenuBar(menuBar);
        this.setTitle(name);
        this. addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D && !isDPressed) {
                    isDPressed = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    isDPressed = false;
                }
            }
        });


        menuBar.add(fileMenu);
        menuBar.add(drawMenu);
        drawMenu.add(figureMenu);

        fileMenu.setMnemonic(KeyEvent.VK_F);
        drawMenu.setMnemonic(KeyEvent.VK_D);
        figureMenu.setMnemonic(KeyEvent.VK_F);



        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        fileMenu.add(openItem);
        openItem.addActionListener(this);


        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        fileMenu.add(saveItem);
        saveItem.addActionListener(this);


        saveAsItem.setMnemonic(KeyEvent.VK_A);
        KeyStroke saveKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK);
        saveAsItem.setAccelerator(saveKeyStroke);
        fileMenu.add(saveAsItem);
        saveAsItem.addActionListener(this);

        fileMenu.addSeparator();

        quitItem.setMnemonic(KeyEvent.VK_Q);
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        fileMenu.add(quitItem);



        colorItem.setMnemonic(KeyEvent.VK_C);
        KeyStroke colorKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK);
        colorItem.setAccelerator(colorKeyStroke);
        drawMenu.add(colorItem);

        drawMenu.addSeparator();

        clearItem.setMnemonic(KeyEvent.VK_C);
        KeyStroke clearKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK);
        clearItem.setAccelerator(clearKeyStroke);
        drawMenu.add(clearItem);



        buttonGroup.add(circleItem);
        circleItem.setMnemonic(KeyEvent.VK_C);
        KeyStroke circleKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
//        circleItem.setAccelerator(circleKeyStroke);
        figureMenu.add(circleItem);
        circleItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMode("Circle");
            }
        });


        buttonGroup.add(squareItem);
        squareItem.setMnemonic(KeyEvent.VK_R);
        KeyStroke squareKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
//        squareItem.setAccelerator(squareKeyStroke);
        figureMenu.add(squareItem);
        squareItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMode("Square");
            }
        });


        buttonGroup.add(penItem);
        penItem.setMnemonic(KeyEvent.VK_P);
        KeyStroke penKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
//        penItem.setAccelerator(penKeyStroke);
        figureMenu.add(penItem);
        penItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMode("Pen");
            }
        });


        statusModePanel.setLayout(new BorderLayout());

        statusModePanel.add(statusLabel, BorderLayout.EAST);
        statusModePanel.add(modeLabel, BorderLayout.WEST);

        add(statusModePanel, BorderLayout.SOUTH);


        contentPane.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if(penItem.isSelected()) {
                    int x = e.getX();
                    int y = e.getY();
                    shapes.add(new Shape(x, y, x, y, currentColor, "line"));
                    contentPane.repaint();
                }
            }
        });


        contentPane.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int x = e.getX();
                    int y = e.getY();
                    if (circleItem.isSelected()) {
                        shapes.add(new Shape(x, y, getRandomColor(), "circle"));
                    }
                    if (squareItem.isSelected()) {
                        shapes.add(new Shape(x, y, getRandomColor(), "square"));
                    }
                    contentPane.repaint();
                }
            }
        });


        colorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JColorChooser colorChooser = new JColorChooser();
                currentColor = colorChooser.showDialog(null, "Choose Color", currentColor);

            }
        });

        clearItem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                shapes.clear();
                contentPane.repaint();
            }
        });
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)  && isDPressed) {
                    Iterator<Shape> iterator = shapes.iterator();
                    while (iterator.hasNext()) {
                        Shape shape = iterator.next();
                        if (shape.getType().equals("circle") && isPointInCircle(e.getX(), e.getY(), shape.getX(), shape.getY(), shape.getSize())) {
                            isDPressed=false;
                            if (confirmDeleteShape("Вы уверены, что хотите удалить этот круг?")) {
                                iterator.remove();
                            }
                        } else if (shape.getType().equals("square") && isPointInSquare(e.getX(), e.getY(), shape.getX(), shape.getY(), shape.getSize())) {
                            isDPressed=false;
                            if (confirmDeleteShape("Вы уверены, что хотите удалить этот квадрат?")) {
                                iterator.remove();
                            }
                        }
                    }
                    contentPane.repaint();
                }
            }
        });
        getContentPane().add(contentPane, BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == openItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Serialized Shape files", "ser"));
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                setStatus("Modified");
                File file = fileChooser.getSelectedFile();
                this.setTitle(file.getName());
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                    this.shapes = (ArrayList<Shape>) ois.readObject();
                    System.out.println("Файл загружен: " + file.getAbsolutePath());
                    contentPane.repaint();
                } catch (IOException | ClassNotFoundException ex) {
                    System.out.println("Ошибка при загрузке файла");
                }

            }
        }

        if (e.getSource() == saveItem) {
            if (currentFile != null) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(currentFile))) {
                    oos.writeObject(shapes);
                    System.out.println("Файл сохранен: " + currentFile.getAbsolutePath());
                } catch (IOException ex) {
                    System.out.println("Ошибка при сохранении файла");
                }
            } else {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Serialized Shape files", "ser"));
                int result = fileChooser.showSaveDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    setStatus("Saved");
                    File file = fileChooser.getSelectedFile();
                    this.setTitle(file.getName());
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                        oos.writeObject(shapes);
                        System.out.println("Файл сохранен: " + file.getAbsolutePath());
                    } catch (IOException ex) {
                        System.out.println("Ошибка при сохранении файла");
                    }
                }
            }
        }

        if (e.getSource() == saveAsItem) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Serialized Shape files", "ser"));
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                setStatus("Saved");
                File file = fileChooser.getSelectedFile();
                this.setTitle(file.getName());
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    oos.writeObject(shapes);
                    System.out.println("Файл сохранен: " + file.getAbsolutePath());
                } catch (IOException ex) {
                    System.out.println("Ошибка при сохранении файла");
                }
            }
        }

    }

    private Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }


    private void setMode(String mode){
        modeLabel.setText(mode);
    }

    private void setStatus(String status){
        statusLabel.setText(status);
    }


    private boolean isPointInCircle(int clickX, int clickY, int circleX, int circleY, int radius) {
        int dx = clickX - circleX;
        int dy = clickY - circleY;
        return dx * dx + dy * dy <= radius * radius;
    }

    private boolean isPointInSquare(int clickX, int clickY, int squareX, int squareY, int size) {
        return clickX >= squareX - size / 2 && clickX <= squareX + size / 2 && clickY >= squareY - size / 2 && clickY <= squareY + size / 2;
    }

    private boolean confirmDeleteShape(String message) {
        int option = JOptionPane.showConfirmDialog(contentPane, message, "Подтверждение удаления", JOptionPane.YES_NO_OPTION);
        return option == JOptionPane.YES_OPTION;

    }
}