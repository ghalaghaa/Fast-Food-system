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
public class OrderItem {
    private int itemId;
    private int quantity;

    public OrderItem() {
        this(0, 0);
    }

    public OrderItem(int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "OrderItem: " + " itemId:" + itemId + "\n quantity:" + quantity;
    }

}