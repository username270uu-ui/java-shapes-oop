# Java Shapes OOP

An object-oriented Java project that models 2D and 3D shapes, calculates their areas, and displays them in a Swing window.

## Features

- Class hierarchy: Shape -> Circle; ThreeDShape -> Cube
- Drawable interface implemented by the shapes
- Overloaded constructors, getters/setters, and method overriding (getArea, getPerimeter, howToDraw)
- Reads shapes from src/input.txt
- Calculates the total area and saves it to sumAreas.txt
- Swing GUI that draws each shape with its dimensions and area

## Tech Stack

Java, Java Swing, VS Code

## Input Format

First line: number of shapes. Then one shape per line:

2
circle 22.5
cube 23.6
## How to Run

Keep input.txt in a src folder next to the .java files, then:

javac -d bin *.java
java -cp bin oop_project.TestDriver
## Sample Output

- Circle (radius 22.5): area 1590.43
- Cube (side 23.6): area 3341.76
- Total area: 4932.19

## Author

Nourhan Mohamed
