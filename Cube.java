package oop_project;

public class Cube extends ThreeDShape implements Drawable {
    private double side;

    // Constructor with rib only

    public Cube(double side) {
       
 super(); // summons Shape()
        this.side = side;
    }

// Constructor with color and rib

    public Cube(String color, double side) {
    	super(); // summons Shape()
        this.side = side;
    }
    
    // Getter for the rib
    public double getSide() {
        return side;
    }
    
    // Setter for the rib 
    public void setSide(double side) {
        this.side = side;
    }

  // Calculating the surface area

    @Override
    public double getArea() {
        return 6 * side * side;
    }
    
  // Calculate the perimeter (sum of letters)

    @Override
    public double getPerimeter() {
        return 12 * side;
    }

    // Size calculation (from ThreeDShape)

    @Override
    public double getVolume() {
        return side * side * side;
    }
    
    // howToDraw From  Drawable
    @Override
    public String howToDraw() {
        return "Draw a cube with side " + side + " and color " + color;
    }
    
    // toString
    @Override
    public String toString() {
        return super.toString() + " -> Cube [side=" + side + "]";
    }
}
