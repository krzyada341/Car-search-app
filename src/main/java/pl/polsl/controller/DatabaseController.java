/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pl.polsl.model.Car;
import pl.polsl.model.Database;
import pl.polsl.model.ParametersException;
import pl.polsl.view.DatabaseView;

/**
 * Controller for managing the Database object
 *
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class DatabaseController {

    /**
     * Interface for managing Database
     */
    private Database model;

    /**
     * Interface for communicating with the user
     */
    private DatabaseView view;

    /**
     * Constructor with 3 arguments, creates default CarView, Car object and
     * filename string
     *
     * @param model is the database model
     * @param view is the database view
     */
    public DatabaseController(Database model, DatabaseView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Method for database making
     *
     * @throws FileNotFoundException when file is not found
     */
    public void makeDatabase() throws FileNotFoundException {
        model.setDatabase();
    }

    /**
     * Method for getting the database
     *
     * @return database
     */
    public ArrayList<Car> getDatabase() {
        return model.getDatabase();
    }

    /**
     * Method for getting the arraylist of Cars with price group selected by user
     * @return arraylist of Cars with price group selected by user
     */
    public ArrayList<Car> getFromCategory(char group) {
        ArrayList<Car> groupedCars = new ArrayList<>();
        for (Car p : model.getDatabase()) {
            if (p.getCategory() == group) {
                groupedCars.add(p);
            }
        }
        return groupedCars;
    }

    /**
     * Method for asking user for filename
     *
     */
    public void askUserForFilename() {
        String filename = JOptionPane.showInputDialog("Type database filename: ");
        model.setFilename(filename);
    }

    /**
     * Method for setting filename from arguments
     *
     * @param args array of arguments
     *
     */
    public void setFilenameFromArgs(String[] args) {
        model.setFilename(args[0]);
    }

    /**
     * Method for changing price for car's price group selected by user
     *
     */
    public void changeGroupPrice(String input) {
        char group = input.charAt(0);
        String strPrice = JOptionPane.showInputDialog("Type car's price: ");
        try {
            model.setGroupPrice(group, strPrice);
        } catch (ParametersException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Value error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
