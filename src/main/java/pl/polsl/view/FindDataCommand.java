/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

import javax.swing.JOptionPane;

/**
 * Command class which pops dialog windows connected with finding elements. Asks
 * the user for parameters and inform them about progress
 *
 * @author Krzysztof Adamczyl
 * @version 3.0
 */
public class FindDataCommand {
    
     /**
     * Asks the user for parameter type
     * 
     * @return the parameter type
     */
    public String getSearchMethod() {
        Object[] options = {"All categories", "Category A", "Category B", "Category C"};
        return (String) JOptionPane.showInputDialog(
                null,
                "How do you want to search?",
                "Searching",
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                "All categories");
    }
}
