/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;

import java.io.Serializable;

/**
 *
 * @author Mjd MAH
 */
public abstract class TheItem implements Serializable {

    private static int NumberOfItems = 0;
    private int serialNum;
    private String nameOfItem;
    private String descriptionOfItem;
    private double priceOfItem;

    public TheItem() {
    }

    public TheItem(int serialNum, String nameOfItem, String descriptionOfItem, double priceOfItem) {
        setserialNum(serialNum);
        setNameOfItem(nameOfItem);
        setDescriptionOfItem(descriptionOfItem);
        this.priceOfItem = priceOfItem;
        ++NumberOfItems;

    }

    public static int getNumberOfItems() {
        return NumberOfItems;
    }

    public int getserialNum() {
        return serialNum;
    }

    public String getNameOfItem() {
        return nameOfItem;
    }

    public String getDescriptionOfItem() {
        return descriptionOfItem;
    }

    public double getPriceOfItem() {
        return priceOfItem;
    }

    public static void setNumberOfItems(int NumberOfItems) {
        TheItem.NumberOfItems = NumberOfItems;
    }

    public void setserialNum(int serialNum) {
        this.serialNum = serialNum;

    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public void setDescriptionOfItem(String descriptionOfItem) {
        this.descriptionOfItem = descriptionOfItem;
    }

    public void setPriceOfItem(double priceOfItem) {
        this.priceOfItem = priceOfItem;
    }

    
    public abstract void Choice();
    
    
    
    @Override
    public String toString() {
        return String.format("Item:%n Name:%s serialNum:%d Item Descritption: %s Item price:%f", nameOfItem, serialNum, descriptionOfItem, priceOfItem);
    }

}