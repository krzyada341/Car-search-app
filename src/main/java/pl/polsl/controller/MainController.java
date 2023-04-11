/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import pl.polsl.view.DataTableModel;
import pl.polsl.model.Database;
import pl.polsl.view.DatabaseView;

/**
 * MainController of the car rental application
 *
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class MainController {
    
     /**
     * Container for the inforamtion about cars
     */
    private DataTableModel data;
    
     /**
     * Controller for database
     */
    private DatabaseController controller;
    
     /**
     * Array of main's arguments
     */
    private String[] args;
    
     /**
     * Conctructor for MainController making database and setting data on the table
     * @param args array of main's arguments
     */
    public MainController(String[] args) {
        this.args = args;
        Database model = new Database();
        DatabaseView view = new DatabaseView();
        DatabaseController controller = new DatabaseController(model, view);
        this.controller = controller;
        this.setFilename(this.args);
        try {
            controller.makeDatabase();
        } catch (FileNotFoundException e) {
           JOptionPane.showMessageDialog(null, "No such a filename or is empty", "Filename error", JOptionPane.ERROR_MESSAGE);
        }
        this.data = new DataTableModel(controller);
    }
    
     /**
     * Method for setting filename from main's arguments or 
     * typed by a user
     * @param args array of main's arguments
     *
     */
    private void setFilename(String[] args) {
        if(args.length == 0)
           controller.askUserForFilename();
        else controller.setFilenameFromArgs(args);          
    }
    
     /**
     * Gets data about cars
     * 
     * @return the data
     */   
    public DataTableModel getData() {
        return data;
    }
    
     /**
     * Gets database controller
     * 
     * @return the database controller
     */
    public DatabaseController getDataController() {
        return controller;
    }
    
}
