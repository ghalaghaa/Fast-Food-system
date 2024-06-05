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
public interface Resturant {
    
    public static final int MaxItems=100;
    
    
    public abstract TheItem getItemByserialNum(int serialNum); 
    public abstract ArrayList<TheItem> getthingslist(); 
    
    public abstract void ShowMenu();
    public abstract void makeOrder(); 
    public abstract void CancelOrder(); 
    public abstract void TheBill(); 
    
    
    public abstract void ReadFile();
    public abstract void SaveData();
}
