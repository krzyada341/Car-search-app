/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;
import pl.polsl.model.Car;
import pl.polsl.view.CarView;
/**
 * 
 * Controller for managing the car object
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class CarController {
    
     /**
     * Interface for managing car's data
     */
    private Car model;
    
     /**
     * Interface for communicating with the user
     */
    private CarView view;
    
     /**
     * Constructor with 2 arguments, creates default CarView and Car object
     *
     * @param model is the car model
     * @param view is the car view
     */
    public CarController(Car model, CarView view) {
        this.model = model;
        this.view = view;
    }
    
     /**
     * Gets the type of the car model
     * @return the type of the car
     */
    public String getType() {
        return model.getType();
    }
    
     /**
     * Sets the price category of the car model
     *
     * @param type the car's model type to set
     */
    public void setType(String type) {
        model.setType(type);
    }
    
     /**
     * Gets the price category of the car model
     * @return the price category of the car
     */
    public char getCategory() {
        return model.getCategory();
    }
    
     /**
     * Sets the price category of the car model
     *
     * @param category the car's model price category to set
     */
    public void setCategory(char category) {
        model.setCategory(category);
    }
    
     /**
     * Gets the price of the car model
     * @return the price of the car
     */
    public double getPrice() {
        return model.getPrice();
    }
    
     /**
     * Sets the price category of the car
     *
     * @param price the car's model price to set
     */
    public void setPrice(double price) {
        model.setPrice(price);
    }
    
     /**
     * Gets the Car object model
     *
     * @return Car object model
     */
    public Car getCar() {
        return model;
    }
    
     /**
     * Displays all informations about car model in standard output
     */
    public void updateView() {
        view.displayInfo(model.getType(), model.getCategory(), model.getPrice());
    }
}
