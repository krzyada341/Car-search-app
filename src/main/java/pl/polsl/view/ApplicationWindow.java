/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import pl.polsl.controller.ChangeButtonListener;
import pl.polsl.controller.FindDataListener;
import pl.polsl.controller.MainController;

/**
 * The main window of the program. Defines its shape and listeners
 *
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class ApplicationWindow extends JFrame {
    
     /**
     * Constructor for window which sets window's name and window's size in pixels
     * 
     */
    public ApplicationWindow() {
        this.setTitle("Car Rental Application");
        this.setSize(400,400);
    }
    
     /**
     * Initializes and builds the window
     * 
     * @param mainController is the flow control
     */
    public void startWindow(MainController mainController) {
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       //create window's panels
       JPanel panel = new JPanel(new BorderLayout());
       JPanel tablePanel = new JPanel(new BorderLayout());    
       JLabel labelSettings = new JLabel("Settings:");
       JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
       
       //create buttons with listeners
       JButton changeDataButton = new JButton("Change price category");
       changeDataButton.addActionListener(new ChangeButtonListener(mainController, mainController.getData()));
       JButton findDataButton = new JButton("Find car");
       findDataButton.addActionListener(new FindDataListener(mainController, mainController.getData()));

       //adding buttons to panel
       buttonPanel.add(labelSettings);
       buttonPanel.add(changeDataButton);
       buttonPanel.add(findDataButton);
       
       //create dataTab and adding to panel
       JPanel dataTab = new DataTab( mainController.getData() );
       tablePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Rental cars", TitledBorder.CENTER, TitledBorder.TOP));
       tablePanel.add(dataTab);
       
       //adding panels to window
       this.add(tablePanel);
       this.add(panel, BorderLayout.NORTH);
       this.add(buttonPanel,BorderLayout.SOUTH);
       
       this.setVisible(true);
    }   
}
