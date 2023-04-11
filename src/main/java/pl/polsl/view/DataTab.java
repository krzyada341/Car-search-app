/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.polsl.view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Class which contains information about cars in Car table
 *
 * @author Krzysztof Adamczyk
 * @version 3.0
 */
public class DataTab extends JPanel {
    
    /**
    * Table of contents
    */
    private final JTable content;
    
    /**
     * Constructor which needs the data for displaying
     * 
     * @param data is the presented data
     */
    DataTab( DataTableModel data ) {
        super(new BorderLayout());
        content = new JTable(data);
        JScrollPane scrollPane = new JScrollPane(content);
        add(scrollPane);
    }
    
}
