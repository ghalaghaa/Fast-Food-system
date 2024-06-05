/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Mjd MAH
 */
public class ReadItem {
    private ObjectInputStream inputStream; //to read objects

    public void openFile(String fileName) {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(new File(fileName)));

        } catch (FileNotFoundException ex) {
            System.err.println("Error opening or creating file." + ex);
        } catch (IOException ex) {
            System.out.println("Can't open file");
        }
    }

    public ArrayList<TheItem> readProducts() {
        ArrayList<TheItem> products = new ArrayList<>();

        while (true) {
            try {
                TheItem product = (TheItem) inputStream.readObject();
                products.add(product);

            } catch (EOFException ex) {
                break;//stop the loop
            } catch (IOException ex) {
                System.out.println("Can't read object");
            } catch (ClassNotFoundException ex) {
                System.out.println("Class not found");
            }
        }
        return products;
    }

    public void closeFile() {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException ex) {
                System.out.println("Can't close file.");
            }
        }
    }


}
