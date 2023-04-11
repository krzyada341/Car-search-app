/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package pl.polsl.carRental;

import pl.polsl.controller.MainController;
import pl.polsl.view.ApplicationWindow;

/**
 * Main class of the application car rental service
 *
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class CarRental {

    /**
     * Main method of the application.
     *
     * @param args first arg - name of database file
     */
    public static void main(String[] args) {
        MainController mainController = new MainController(args);
        ApplicationWindow app = new ApplicationWindow();
        
        //spreading thread to create application GUI for safety
        javax.swing.SwingUtilities.invokeLater(() -> {
            app.startWindow(mainController);
        });
    }
}
