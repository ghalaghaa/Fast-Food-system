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
public class Soda extends ColdDrinks {

    public Soda() {
    }

    public Soda(boolean addIce, int serialNum, String nameOfItem, String descriptionOfItem, double priceOfItem, char sizeOfDrink) {
        super(addIce, serialNum, nameOfItem, descriptionOfItem, priceOfItem, sizeOfDrink);

    }
    @Override
    public String toString() {
        return super.toString();
    }
}

