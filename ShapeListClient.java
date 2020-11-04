import java.rmi.*;
import java.util.*;
import java.util.Vector;
import java.awt.Rectangle;
import java.awt.Color;

public class ShapeListClient {
    public static void main(String args[]) {
        System.setSecurityManager(new RMISecurityManager());
        ShapeList aShapeList = null;

        try {
            System.out.println(
                    "Client info:\n\nPress\n1 - List shapes;\n2 - Insert a square shape;\n0 - Exit program.\n\n");

            aShapeList = ((ShapeList) Naming.lookup("//localhost:1099/ShapeList"));

            Vector sList;
            Scanner option = new Scanner(System.in);
            System.out.println("Choice: ");
            int choice = option.nextInt();
            do {
                switch (choice) {

                    case 1: {
                        sList = aShapeList.allShapes();
                        if (sList.size() == 0) {
                            System.out.println("List is empty.");
                        } else {
                            System.out.println("Listing shapes...\n");
                            for (int i = 0; i < sList.size(); i++) {
                                // Casting para (Shape).
                                GraphicalObject view = ((Shape) sList.elementAt(i)).getAllState();
                                view.print();
                            }
                        }

                    }
                        break;
                    case 2: {
                        String Type = "Square";
                        Rectangle Shape = new Rectangle(10, 10);
                        Color lineColor = new Color(255, 255, 255);
                        Color fillColor = new Color(0, 0, 0);
                        boolean isFilled = true;

                        GraphicalObject g = new GraphicalObject(Type, Shape, lineColor, fillColor, isFilled);
                        aShapeList.newShape(g);

                        System.out.println("Added a square.\n");
                    }
                        break;
                    default: {
                        System.out.println("No can do.\n");
                    }
                        break;
                }
                System.out.println("Choice: ");

                choice = option.nextInt();
            } while (choice != 0);
            System.out.println("Bye!");

        } catch (RemoteException e) {
            System.out.println("Server: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Client: " + e.getMessage());

        }
    }
}
