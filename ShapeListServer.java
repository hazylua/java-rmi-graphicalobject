import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.net.SocketPermission;

public class ShapeListServer {
    public static void main(String args[]) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            ShapeList aShapeList = new ShapeListServant();
            ShapeList stub = (ShapeList) UnicastRemoteObject.exportObject(aShapeList, 0);
            Naming.rebind("rmi://localhost:1099/ShapeList", stub);
            System.out.println("ShapeList server ready");
        } catch (Exception e) {
            System.out.println("ShapeList server main " + e.getMessage());
        }
    }
}
