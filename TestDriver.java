package oop_project;

import java.io.*;
import java.util.Scanner;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("=== Object Oriented Programming Project ===");
        System.out.println("Reading from input.txt...\n");
        
        File inputFile = new File("src/input.txt");
        
        Drawable[] shapes = null;
        double totalArea = 0;
        int shapeCount = 0;

        try (Scanner scanner = new Scanner(inputFile)) {
            int count = scanner.nextInt();
            scanner.nextLine();
            
            shapes = new Drawable[count];
            shapeCount = count;

            System.out.println("Creating " + count + " shapes:");
            
            for (int i = 0; i < count; i++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(" ");
                
                Drawable shape = null;
                
                if (parts.length == 2) {
                    String type = parts[0].toLowerCase();
                    double value = Double.parseDouble(parts[1]);
                    
                    if (type.equals("circle")) {
                        shape = new Circle(value);
                        System.out.println("Created Circle with radius: " + value);
                    } else if (type.equals("cube")) {
                        shape = new Cube(value);
                        System.out.println("Created Cube with side: " + value);
                    }
                    
                } else if (parts.length == 3) {
                    String color = parts[0];
                    String type = parts[1].toLowerCase();
                    double value = Double.parseDouble(parts[2]);
                    
                    if (type.equals("circle")) {
                        shape = new Circle(color, value);
                        System.out.println("Created " + color + " Circle with radius: " + value);
                    } else if (type.equals("cube")) {
                        shape = new Cube(color, value);
                        System.out.println("Created " + color + " Cube with side: " + value);
                    }
                }
                
                shapes[i] = shape;
                
                if (shape instanceof Shape) {
                    totalArea += ((Shape) shape).getArea();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Error: File 'src/input.txt' not found!");
            System.out.println("Please make sure input.txt is in src/ folder");
            System.out.println("File location should be: " + new File(".").getAbsolutePath() + "/src/input.txt");
            return;
        } catch (Exception e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
            return;
        }


        System.out.println("\n=== Shape Information ===");
        for (int i = 0; i < shapeCount; i++) {
            if (shapes[i] != null) {
                System.out.println("\nShape " + (i+1) + ":");
                System.out.println("  " + shapes[i].toString());
                System.out.println("  Area: " + String.format("%.2f", ((Shape)shapes[i]).getArea()));
                System.out.println("  How to draw: " + shapes[i].howToDraw());
            }
        }

         
        try (PrintWriter writer = new PrintWriter("sumAreas.txt")) {
            writer.printf("Total area of all shapes: %.2f%n", totalArea);
            System.out.printf("\n✅ Total area saved to sumAreas.txt: %.2f%n", totalArea);
        } catch (FileNotFoundException e) {
            System.out.println("❌ Error writing to sumAreas.txt: " + e.getMessage());
        }

       
        System.out.println("\n=== Launching GUI ===");
        new ShapeGUI(shapes);
    }
}