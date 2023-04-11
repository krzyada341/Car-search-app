/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;
import java.util.ArrayList;
import java.util.stream.Stream;
import pl.polsl.model.Car;
import pl.polsl.controller.CarController;

/**
 * The interface between Database class and the user
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class DatabaseView {
       
    /**
     * Prints database on the standard output
     *
     * @param cars is the arrayList of the car objects
     */
    public void displayDatabase(ArrayList<Car> cars) {
       CarView view = new CarView();
       Stream<Car> carsStream = cars.stream();
       carsStream.forEach(c -> new CarController(c,view).updateView());
    }
    
     /**
     * Prints the cars with selected price group
     * @param cars is the arrayList of the car objects
     * @param group selected car's price group
     */
    public void displayFromCategory(ArrayList<Car> cars, char group) { 
        CarView view = new CarView();
        Stream<Car> carsStream = cars.stream();
        Stream<Car> filteredStream = carsStream
                .filter(c -> c.getCategory() == group);
        filteredStream.forEach(c -> new CarController(c,view).updateView());
    }
}
