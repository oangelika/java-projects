import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleDraw extends JFrame {
    private JMenuBar menuBar;
    private JMenu fileMenu, drawMenu, figureMenu;
    private JMenuItem openItem, saveItem, saveAsItem, quitItem;
    private JMenuItem circleItem, squareItem, penItem, colorItem, clearItem;
    private JToolBar toolBar;
    private JLabel modeLabel, statusLabel;
    private DrawArea drawArea;
    private Color currentColor = Color.BLACK;
    private String currentFigure = "Circle";
    private File currentFile;
    private boolean isModified = false;

    public SimpleDraw() {
        setTitle("Simple Draw");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        drawMenu = new JMenu("Draw");
        figureMenu = new JMenu("Figure");

        openItem = new JMenuItem("Open");
        openItem.setMnemonic(KeyEvent.VK_O);
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        saveItem = new JMenuItem("Save");
        saveItem.setMnemonic(KeyEvent.VK_S);
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        saveAsItem = new JMenuItem("Save As...");
        saveAsItem.setMnemonic(KeyEvent.VK_A);
        saveAsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        quitItem = new JMenuItem("Quit");
        quitItem.setMnemonic(KeyEvent.VK_Q);
        quitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

        circleItem = new JMenuItem("Circle");
        circleItem.setMnemonic(KeyEvent.VK_C);
        circleItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
        squareItem = new JMenuItem("Square");
        squareItem.setMnemonic(KeyEvent.VK_S);
        squareItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
        penItem = new JMenuItem("Pen");
        penItem.setMnemonic(KeyEvent.VK_P);
        penItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        colorItem = new JMenuItem("Color");
        colorItem.setMnemonic(KeyEvent.VK_L);
        colorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
        clearItem = new JMenuItem("Clear");
        clearItem.setMnemonic(KeyEvent.VK_R);
        clearItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(quitItem);

        figureMenu.add(circleItem);
        figureMenu.add(squareItem);
        figureMenu.add(penItem);

        drawMenu.add(figureMenu);
        drawMenu.add(colorItem);
        drawMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(drawMenu);
        setJMenuBar(menuBar);

        toolBar = new JToolBar();
        modeLabel = new JLabel("Mode: Circle");
        statusLabel = new JLabel("Status: New");
        toolBar.add(modeLabel);
        toolBar.addSeparator();
        toolBar.add(statusLabel);
        add(toolBar, BorderLayout.SOUTH);

        drawArea = new DrawArea();
        add(drawArea, BorderLayout.CENTER);

        // Action Listeners
        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        saveAsItem.addActionListener(e -> saveAsFile());
        quitItem.addActionListener(e -> quitApplication());

        circleItem.addActionListener(e -> setCurrentFigure("Circle"));
        squareItem.addActionListener(e -> setCurrentFigure("Square"));
        penItem.addActionListener(e -> setCurrentFigure("Pen"));

        colorItem.addActionListener(e -> chooseColor());
        clearItem.addActionListener(e -> clearDrawArea());

        setVisible(true);
    }

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(currentFile))) {
                drawArea.setShapes((ArrayList<ShapeObject>) ois.readObject());
                drawArea.repaint();
                setTitle(currentFile.getName() + " - Simple Draw");
                isModified = false;
                updateStatusLabel();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveFile() {
        if (currentFile != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(currentFile))) {
                oos.writeObject(drawArea.getShapes());
                isModified = false;
                updateStatusLabel();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            saveAsFile();
        }
    }

    private void saveAsFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            saveFile();
            setTitle(currentFile.getName() + " - Simple Draw");
        }
    }

    private void quitApplication() {
        if (isModified) {
            int result = JOptionPane.showConfirmDialog(this, "Do you want to save changes before quitting?", "Save Changes", JOptionPane.YES_NO_CANCEL_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                saveFile();
                System.exit(0);
            } else if (result == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    private void setCurrentFigure(String figure) {
        currentFigure = figure;
        modeLabel.setText("Mode: " + figure);
    }

    private void chooseColor() {
        Color chosenColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
        if (chosenColor != null) {
            currentColor = chosenColor;
        }
    }

    private void clearDrawArea() {
        drawArea.clear();
        isModified = true;
        updateStatusLabel();
    }

    private void updateStatusLabel() {
        statusLabel.setText("Status: " + (isModified ? "Modified" : "Saved"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleDraw::new);
    }

    class DrawArea extends JPanel {
        private List<ShapeObject> shapes;
        private ShapeObject currentShape;

        public DrawArea() {
            shapes = new ArrayList<>();
            setBackground(Color.WHITE);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e)) {
                        if (currentFigure.equals("Circle")) {
                            currentShape = new ShapeObject(new Ellipse2D.Double(e.getX(), e.getY(), 50, 50), currentColor);
                        } else if (currentFigure.equals("Square")) {
                            currentShape = new ShapeObject(new Rectangle2D.Double(e.getX(), e.getY(), 50, 50), currentColor);
                        } else if (currentFigure.equals("Pen")) {
                            currentShape = new ShapeObject(new ArrayList<Point>(), currentColor);
                            ((List<Point>) currentShape.getShape()).add(e.getPoint());
                        }
                        shapes.add(currentShape);
                        repaint();
                        isModified = true;
                        updateStatusLabel();
                    } else if (SwingUtilities.isRightMouseButton(e) && e.isControlDown()) {
                        for (int i = shapes.size() - 1; i >= 0; i--) {
                            ShapeObject shapeObj = shapes.get(i);
                            if (shapeObj.getShape() instanceof Shape && ((Shape) shapeObj.getShape()).contains(e.getPoint())) {
                                int result = JOptionPane.showConfirmDialog(null, "Delete this shape?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION) {
                                    shapes.remove(i);
                                    repaint();
                                    isModified = true;
                                    updateStatusLabel();
                                }
                                break;
                            }
                        }
                    }
                }
            });

            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if (currentFigure.equals("Pen") && SwingUtilities.isLeftMouseButton(e)) {
                        ((List<Point>) currentShape.getShape()).add(e.getPoint());
                        repaint();
                    }
                }
            });
        }

        public void clear() {
            shapes.clear();
            repaint();
        }

        public List<ShapeObject> getShapes() {
            return shapes;
        }

        public void setShapes(List<ShapeObject> shapes) {
            this.shapes = shapes;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (ShapeObject shapeObj : shapes) {
                g2d.setColor(shapeObj.getColor());
                if (shapeObj.getShape() instanceof Shape) {
                    g2d.fill((Shape) shapeObj.getShape());
                } else if (shapeObj.getShape() instanceof List) {
                    List<Point> points = (List<Point>) shapeObj.getShape();
                    for (int i = 1; i < points.size(); i++) {
                        g2d.drawLine(points.get(i - 1).x, points.get(i - 1).y, points.get(i).x, points.get(i).y);
                    }
                }
            }
        }
    }

    class ShapeObject implements Serializable {
        private static final long serialVersionUID = 1L;
        private Object shape;
        private Color color;

        public ShapeObject(Object shape, Color color) {
            this.shape = shape;
            this.color = color;
        }

        public Object getShape() {
            return shape;
        }

        public Color getColor() {
            return color;
        }
    }
}