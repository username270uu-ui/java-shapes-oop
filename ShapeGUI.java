package oop_project;

import javax.swing.*;
import java.awt.*;

public class ShapeGUI extends JFrame {
    private static final long serialVersionUID = 1L; 
    private Drawable[] shapes;
    
    public ShapeGUI(Drawable[] shapes) {
        this.shapes = shapes;
        setupGUI();
    }
    
    private void setupGUI() {
        setTitle("Shapes Drawing - OOP Project");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);
        
        setVisible(true);
    }
    
    class DrawingPanel extends JPanel {
        private static final long serialVersionUID = 1L;  
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 16));
            g.drawString("Shapes Drawing", 320, 30);
            
            if (shapes == null || shapes.length == 0) {
                g.drawString("No shapes to display", 300, 100);
                return;
            }
            
            int x = 50;
            int y = 100;
            
            for (int i = 0; i < shapes.length; i++) {
                if (shapes[i] instanceof Circle) {
                    drawCircle(g, (Circle) shapes[i], x, y);
                    x += 200;
                } 
                else if (shapes[i] instanceof Cube) {
                    drawCube(g, (Cube) shapes[i], x, y);
                    x += 200;
                }
                
                if (x > 600) {
                    x = 50;
                    y += 200;
                }
            }
        }
        
        private void drawCircle(Graphics g, Circle circle, int x, int y) {
            int radius = (int) Math.min(circle.getRadius(), 50);
            
            String color = circle.getColor().toLowerCase();
            switch (color) {
                case "red": g.setColor(Color.RED); break;
                case "blue": g.setColor(Color.BLUE); break;
                case "green": g.setColor(Color.GREEN); break;
                case "yellow": g.setColor(Color.YELLOW); break;
                default: g.setColor(Color.BLACK);
            }
            
            g.fillOval(x, y, radius * 2, radius * 2);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, radius * 2, radius * 2);
            
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString("Circle", x, y - 10);
            g.drawString("Radius: " + circle.getRadius(), x, y + radius * 2 + 20);
            g.drawString("Area: " + String.format("%.2f", circle.getArea()), x, y + radius * 2 + 35);
        }
        
        private void drawCube(Graphics g, Cube cube, int x, int y) {
            int side = (int) Math.min(cube.getSide(), 60);
            
            String color = cube.getColor().toLowerCase();
            switch (color) {
                case "red": g.setColor(Color.RED); break;
                case "blue": g.setColor(Color.BLUE); break;
                case "green": g.setColor(Color.GREEN); break;
                case "yellow": g.setColor(Color.YELLOW); break;
                default: g.setColor(Color.GRAY);
            }
            
            g.fillRect(x, y, side, side);
            
            int[] xTop = {x, x + 10, x + side + 10, x + side};
            int[] yTop = {y, y - 8, y - 8, y};
            g.fillPolygon(xTop, yTop, 4);
            
            int[] xSide = {x + side, x + side + 10, x + side + 10, x + side};
            int[] ySide = {y, y - 8, y - 8 + side, y + side};
g.fillPolygon(xSide, ySide, 4);
            
            g.setColor(Color.BLACK);
            g.drawRect(x, y, side, side);
            g.drawPolygon(xTop, yTop, 4);
            g.drawPolygon(xSide, ySide, 4);
            
            g.drawLine(x + side, y, x + side + 10, y - 8);
            g.drawLine(x + side, y + side, x + side + 10, y - 8 + side);
            g.drawLine(x, y + side, x + 10, y - 8 + side);
            
            g.setFont(new Font("Arial", Font.PLAIN, 12));
            g.drawString("Cube", x, y - 25);
            g.drawString("Side: " + cube.getSide(), x, y + side + 20);
            g.drawString("Area: " + String.format("%.2f", cube.getArea()), x, y + side + 35);
        }
    }
}