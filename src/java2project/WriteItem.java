/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;
import java.io.*;
/**
 *
 * @author Mjd MAH
 */
public class WriteItem {
     private ObjectOutputStream outputStream; 

    public void openFile(String fileName) {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(new File(fileName)));
        } // end try
        catch (SecurityException ex) {
            System.err.println("You do not have write access to this file.");

        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file.");
        } catch (IOException ex) {
            System.out.println("Can't open file");
        }
    }

    public void saveProduct(TheItem p) {
        try {
            outputStream.writeObject(p);
        } catch (IOException ex) {
            System.out.println("Can't write to file" + ex);
        }
    }

    public void closeFile() {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException ex) {
                System.out.println("Can't close file");
            }
        }
    }
}


