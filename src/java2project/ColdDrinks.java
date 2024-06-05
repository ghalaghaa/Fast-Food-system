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
public class ColdDrinks extends Drinks{
     private boolean addIce;

    public ColdDrinks() {
    }

    public ColdDrinks(boolean addIce, int serialNum, String nameOfItem, String descriptionOfItem, double priceOfItem, char sizeOfDrink) {
        super(serialNum, nameOfItem, descriptionOfItem, priceOfItem, sizeOfDrink);
        setAddIce(addIce);

    }

    public boolean getAddIce() {
        return addIce;
    }

    public void setAddIce(boolean addIce) {
        this.addIce = addIce;
    }

    @Override
    public void Choice() {
        if (addIce == true) {
            System.out.println("A cold drink with ice");
        } else {
            System.out.println("A cold drink with no ice");
        }
    }

    ;  
   @Override
    public String toString() {
        return String.format("%s Ice: %s", super.toString(), addIce);
    }


}
