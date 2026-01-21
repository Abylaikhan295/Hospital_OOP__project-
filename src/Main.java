import menu.Menu;          // This tells Main where the interface is
import menu.MenuHospital;  // This tells Main where the class is

import static java.awt.SystemColor.menu;


public class Main {
    public static void main(String[] args) {
        menu menu = new MenuHospital();
        menu.run();
    }
}