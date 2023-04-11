/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

/**
 * The interface between Car class and the user
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class CarView {
    
     /**
     * Prints the information about car on the standard output
     *
     * @param type is the type of the car
     * @param category is category of the car
     * @param price is price for the car category
     */
    public void displayInfo(String type, char category, double price) {
        System.out.println("Type: " + type + " Category: " + category + " Price: " + price);
    }
}
