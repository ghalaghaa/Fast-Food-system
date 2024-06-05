/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;

import java.util.ArrayList;

/**
 *
 * @author Mjd MAH
 */
public class Save {
    public static void main(String[] args) {
        
        
        
        ArrayList<TheItem> item = new ArrayList<>();

        item.add(new Fresh(true, 3113 , "Drinks", "Cold", 13, 'B'));
        item.add(new Fresh(false, 5555 , "Drinks", "Cold", 25 , 'A'));
        item.add(new Fresh(false, 2131 , "Drinks", "Cold", 17 , 'B'));
        item.add(new Fresh(true, 3333 , "Drinks", "Cold", 15 , 'A'));
        item.add(new Fresh(true, 3, "Drinks", "Cold", 20, 'A'));
        
        
        WriteItem writer = new WriteItem();
        writer.openFile("Item.ser");
        
        
        for (TheItem i : item) {
            writer.saveProduct(i);
        }

        writer.closeFile();


        WriteOrder writer2 = new WriteOrder();
        writer2.openFile("orders.ser");
        writer2.closeFile();
        System.out.println("All **Test Data** Saved.");
    }
}

