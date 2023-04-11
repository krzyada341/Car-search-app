/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pl.polsl.controller.DatabaseController;
import pl.polsl.model.Car;

/**
 * Class which contains data in the form of a table
 *
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class DataTableModel extends AbstractTableModel {

    /**
     * Displayed column's names
     */
    private String[] columnNames = {"Category", "Type", "Price"};

    /**
     * Contained data about cars in the form of a list
     */
    private ArrayList<Car> cars;

    /**
     * Reference to the main database controller
     */
    private DatabaseController controller;

    /**
     * Constructor which creates lists of cars from database
     *
     * @param controller controls the data from database
     */
    public DataTableModel(DatabaseController controller) {
        this.controller = controller;
        this.cars = controller.getDatabase();
    }

    /**
     * Overridden method which displays the contents of the table
     *
     * @param rowIndex is the row number
     * @param columnIndex is the column number
     * @return the table contents
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Car car = cars.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return car.getCategory();
            case 1:
                return car.getType();
            case 2:
                return car.getPrice();
            default:
                return null;
        }
    }

    /**
     * Method which sets price value for group price category
     *
     * @param input is the new person
     */
    public void setPriceValue(String input) {
        controller.changeGroupPrice(input);
        this.cars = controller.getDatabase();
        this.update();
    }

    /**
     * Method which prints Cars with selected group price category
     *
     * @param group Car's group price category
     */
    public void printGroupedCars(char group) {
        if (group == 'A' || group == 'B' || group == 'C') {
            ArrayList<Car> groupedCars = controller.getFromCategory(group);
            this.cars = groupedCars;
            this.update();
        } else {
            this.cars = controller.getDatabase();
            this.update();
        }
    }

    /**
     * Sets the car list from the database
     *
     */
    public void setCarList() {
        this.cars = controller.getDatabase();
    }

    /**
     * Refreshes the displayed table
     */
    private void update() {
        this.fireTableDataChanged();
    }

    /**
     * Gets chosen column's name
     *
     * @param columnIndex is the chosen column number
     * @return chosen's column name
     */
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    /**
     * Overidden method which counts the row number
     *
     * @return the row number
     */
    @Override
    public int getRowCount() {
        return cars.size();
    }

    /**
     * Overidden method which counts the column number
     *
     * @return the column number
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Gets the Cars list
     *
     * @return the Cars list
     */
    public ArrayList<Car> getCarList() {
        return cars;
    }
}
