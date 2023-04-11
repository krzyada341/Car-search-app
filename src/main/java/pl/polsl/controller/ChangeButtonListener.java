/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pl.polsl.view.DataTableModel;
import pl.polsl.view.ChangeGroupPriceCommand;

/**
 * Listener which takes action when ChangePriceCategory button is pressed
 *
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class ChangeButtonListener implements ActionListener {
    
     /**
     * The referenced data about cars
     */
    DataTableModel data;

     /**
     * Constructor which takes out references of the cars data
     *
     * @param mainController is the main controller which contains other controllers
     * @param data is the current source of data
     */
    public ChangeButtonListener(MainController mainController, DataTableModel data) {
        this.data = data;
    }

     /**
     * The action which is taken after clicking the button. Asks user for
     * choosing the group and input parameter then tries to change the price
     * of Car's group price.
     *
     * @param ae are the registered events
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        ChangeGroupPriceCommand changeGroupPriceCommand = new ChangeGroupPriceCommand();
        String searchMethod = changeGroupPriceCommand.getSearchMethod();
        if (searchMethod != null) {
            switch (searchMethod) {
                case "Category A":
                    data.setPriceValue("A");
                    break;
                case "Category B":
                    data.setPriceValue("B");
                    break;
                case "Category C":
                    data.setPriceValue("C");
                    break;
            }
        }
    }
}
