/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;

/**
 *
 * @author Mjd MAH
 */
public abstract class Drinks extends TheItem {
    
    private char sizeOfDrink;

    public Drinks() {
        this(0, "", "", 0.0, ' ');
    }

    public Drinks(int serialNum, String nameOfItem, String descriptionOfItem, double priceOfItem, char sizeOfDrink) {
        super(serialNum, nameOfItem, descriptionOfItem, priceOfItem);
        this.sizeOfDrink = sizeOfDrink;

    }

    public char getSizeOfDrink() {
        return sizeOfDrink;
    }

    public void setSizeOfDrink(char sizeOfDrink) {
        this.sizeOfDrink = sizeOfDrink;
    }

    @Override
    public String toString() {
        return String.format("%s Size of the Drink: %s", super.toString(), sizeOfDrink);

    }

    
}
