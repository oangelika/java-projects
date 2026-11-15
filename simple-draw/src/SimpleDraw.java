import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.ArrayList;


    public class SimpleDraw extends JFrame {
        private JMenuBar menuBar;
        private JMenu fileMenu, drawMenu, figureMenu;
        private JMenuItem openItem, saveItem, saveAsItem, quitItem;
        private JMenuItem circleItem, squareItem, penItem, colorItem, clearItem;
        private DrawArea drawArea;
        private Color currentColor = Color.BLACK;
        private String currentFigure = "Circle";
        private File currentFile;

        public SimpleDraw() {
            setTitle("Simple Draw");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());

            menuBar = new JMenuBar();
            fileMenu = new JMenu("File");
            drawMenu = new JMenu("Draw");
            figureMenu = new JMenu("Figure");

            openItem = new JMenuItem("Open");
            saveItem = new JMenuItem("Save");
            saveAsItem = new JMenuItem("Save As...");
            quitItem = new JMenuItem("Quit");

            circleItem = new JMenuItem("Circle");
            squareItem = new JMenuItem("Square");
            penItem = new JMenuItem("Pen");
            colorItem = new JMenuItem("Color");
            clearItem = new JMenuItem("Clear");

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

            drawArea = new DrawArea();
            add(drawArea, BorderLayout.CENTER);

            // Action Listeners
            openItem.addActionListener(e -> openFile());
            saveItem.addActionListener(e -> saveFile());
            saveAsItem.addActionListener(e -> saveAsFile());
            quitItem.addActionListener(e -> System.exit(0));

            circleItem.addActionListener(e -> currentFigure = "Circle");
            squareItem.addActionListener(e -> currentFigure = "Square");
            penItem.addActionListener(e -> currentFigure = "Pen");

            colorItem.addActionListener(e -> {
                Color chosenColor = JColorChooser.showDialog(null, "Choose a color", currentColor);
                if (chosenColor != null) {
                    currentColor = chosenColor;
                }
            });

            clearItem.addActionListener(e -> drawArea.clear());

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
                } catch (IOException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }

        private void saveFile() {
            if (currentFile != null) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(currentFile))) {
                    oos.writeObject(drawArea.getShapes());
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
            }
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(SimpleDraw::new);
        }

        class DrawArea extends JPanel {
            private ArrayList<ShapeObject> shapes;
            private ShapeObject currentShape;

            public DrawArea() {
                shapes = new ArrayList<>();
                setBackground(Color.WHITE);
                addMouseListener(new MouseAdapter() {
                    public void mousePressed(MouseEvent e) {
                        if (currentFigure.equals("Circle")) {
                            currentShape = new ShapeObject(new Ellipse2D.Double(e.getX(), e.getY(), 50, 50), currentColor);
                        } else if (currentFigure.equals("Square")) {
                            currentShape = new ShapeObject(new Rectangle2D.Double(e.getX(), e.getY(), 50, 50), currentColor);
                        } else if (currentFigure.equals("Pen")) {
                            currentShape = new ShapeObject(new ArrayList<Point>(), currentColor);
                            ((ArrayList<Point>) currentShape.getShape()).add(e.getPoint());
                        }
                        shapes.add(currentShape);
                        repaint();
                    }
                });

                addMouseMotionListener(new MouseAdapter() {
                    public void mouseDragged(MouseEvent e) {
                        if (currentFigure.equals("Pen")) {
                            ((ArrayList<Point>) currentShape.getShape()).add(e.getPoint());
                            repaint();
                        }
                    }
                });
            }

            public void clear() {
                shapes.clear();
                repaint();
            }

            public ArrayList<ShapeObject> getShapes() {
                return shapes;
            }

            public void setShapes(ArrayList<ShapeObject> shapes) {
                this.shapes = shapes;
            }

            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                for (ShapeObject shapeObj : shapes) {
                    g2d.setColor(shapeObj.getColor());
                    if (shapeObj.getShape() instanceof Shape) {
                        g2d.fill((Shape) shapeObj.getShape());
                    } else if (shapeObj.getShape() instanceof ArrayList) {
                        ArrayList<Point> points = (ArrayList<Point>) shapeObj.getShape();
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

