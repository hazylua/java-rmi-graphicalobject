import java.awt.Rectangle;
import java.awt.Color;
import java.io.Serializable;

public class GraphicalObject implements Serializable {
  public String type;
  public Rectangle enclosing;
  public Color line;
  public Color fill;
  public boolean isFilled;

  // Construtor.
  public GraphicalObject() {
  }

  public GraphicalObject(String aType, Rectangle anEnclosing, Color aLine, Color aFill, boolean anIsFilled) {
    type = aType;
    enclosing = anEnclosing;
    line = aLine;
    fill = aFill;
    isFilled = anIsFilled;
  }

  public void print() {

    System.out.print("Type: " + type + '\n');
    System.out.print(
        "Dimensions: " + enclosing.x + " , " + enclosing.y + " , " + enclosing.width + " , " + enclosing.height + '\n');
    if (isFilled)
      System.out.println("Fill: is filled.\n");
    else
      System.out.println("Fill: not filled.\n");
  }
}
