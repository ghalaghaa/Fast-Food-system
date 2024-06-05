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
public class Burger extends TheItem {
    
    private char sizeOfBurger;
    private boolean addCheese;

    public Burger(char sizeOfBurger, boolean addCheese, int serialNum, String nameOfItem, String descriptionOfItem, double priceOfItem) {
        super(serialNum, nameOfItem, descriptionOfItem, priceOfItem);
        this.sizeOfBurger = sizeOfBurger;
        this.addCheese = addCheese;
    }

    public char getSizeOfBurger() {
        return sizeOfBurger;
    }

    public void setSizeOfBurger(char sizeOfBurger) {
        this.sizeOfBurger = sizeOfBurger;
    }

    public boolean getAddCheese() {
        return addCheese;
    }

    public void setAddCheese(boolean addCheese) {
        this.addCheese = addCheese;
    }
    
    @Override
    public void Choice(){
         if (addCheese == true) {
            System.out.println("One cheese slice for you!");
        } else {
            System.out.println("No cheese was added");
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s Size of the Burger: %s Cheese on the burger: %b ", super.toString(), sizeOfBurger, addCheese);

    }

}
