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
public class Donut extends TheItem {

    private String flavor;
    private boolean syrup;
    
    public Donut(String flavor, int serialNum, String nameOfItem, String descriptionOfItem, double priceOfItem) {
        super(serialNum, nameOfItem, descriptionOfItem, priceOfItem);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public boolean getSyrup() {
        return syrup;
    }

    public void setSyrup(boolean syrup) {
        this.syrup = syrup;
    }
    
    public void Choice() {
        if (syrup == true) {
            System.out.println("Add syrup for your Dount");
        } else {
            System.out.println("No syrup for this dount");
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s Size of the Burger: %s Cheese on the burger: %b ", super.toString(), getFlavor());

    }
   
}
