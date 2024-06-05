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
public class HotDrinks extends Drinks {
       private boolean Suger;
    public HotDrinks() {
    }

   
    public HotDrinks(int serialNum, String nameOfItem, String descriptionOfItem, double priceOfItem, char sizeOfDrink) {
        super(serialNum, nameOfItem, descriptionOfItem, priceOfItem, sizeOfDrink);

    }
        @Override
    public void Choice(){
         if (Suger == true) {
            System.out.println("Add suger to your drink");
        } else {
            System.out.println("No suger for your drink");
        }
    }
    
}
