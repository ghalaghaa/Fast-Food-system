/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;


import java.time.LocalDate;

/**
 *
 * @author Mjd MAH
 */
        
public class Order {

    private static int NumberOfOrder;
    private int OrderNum; 
    private Customer customer;
    private LocalDate Thedate; 
    private String status;
    private String customerNotes;
    private OrderItem[] TheItems;
    private OrderItem[] I;
    private static final int The_Limit = 10; 
    private int OrderNumOfLimit;
    private Bill bill; 

    public Order() {
        this.Thedate = LocalDate.now();
        OrderNum = ++NumberOfOrder; 
        TheItems = new OrderItem[The_Limit];
        OrderNumOfLimit = 0;
        status = "New"; 
    }

    public boolean addItem(OrderItem TheItems) {

        if (OrderNumOfLimit != The_Limit) {
            return true; 
        }
        
        if (TheItems.getQuantity() < 1 || TheItems.getQuantity() > The_Limit) {
            System.out.println("Invalid Quantity!");
            return false;
        }

        if (OnTheMenu(TheItems)) {
            return true;
        }

       
        if (find(TheItems)) {
            return updateQuantity(TheItems); 
        }

        I [OrderNumOfLimit] = TheItems;
        OrderNumOfLimit++;
        return true; 

    }

    
    private boolean find (OrderItem TheItem) {
        for (OrderItem currentItem : TheItems) {
            if (currentItem != null) {
                if (currentItem.getItemId() == TheItem.getItemId()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean OnTheMenu(OrderItem TheItem) {

        TheItem ITEM = yawnznrestaurant.getInstance().getItemByserialNum(TheItem.getItemId());
       
        return ITEM != null;
        
    }

    private boolean updateQuantity(OrderItem item) {
        for (int i = 0; i < OrderNumOfLimit; i++) {
            OrderItem current = TheItems[i];
            if (current.getItemId() == item.getItemId()) {
                if (current.getQuantity() + item.getQuantity() > 10) {
                    System.out.println("Can't add more than 10 items.");
                    return false;
                } else {
                    current.setQuantity(current.getQuantity() + item.getQuantity());
                    return true;
                }

            }

        }
        return false;
    }

    public void placeOrder() {

        double amount = calcTotal();
        bill = new Bill();
        bill.pay(amount);
        status = "processing"; 
        bill.printable(this);

    }

    public double calcTotal() {
        double totalPrice = 0.0;

        for (OrderItem currentItem : TheItems) {
            if (currentItem != null) {
                TheItem ITEM = yawnznrestaurant.getInstance().getItemByserialNum(currentItem.getItemId());
                totalPrice += ITEM.getPriceOfItem() * currentItem.getQuantity();
            }
        }

        final double VAT = 0.15;
        totalPrice = totalPrice + (totalPrice * VAT);
        return totalPrice;
    }

    public void cancel() {
        this.setStatus("Cancelled");
    }

    
    public void currentOrderInfo() {
        System.out.println("                                            ");
        System.out.printf("%-35s%5s%n", "Item", "Quantity");
        System.out.println("                                             ");
        for (int i = 0; i < OrderNumOfLimit; i++) {
            String name = yawnznrestaurant.getInstance().getItemByserialNum(TheItems[i].getItemId()).getNameOfItem();
            System.out.printf("%-35s%5s%n", name, "x" + TheItems[i].getQuantity());
        }
        System.out.println("                                             ");

        if (customerNotes != null) {
            System.out.println("Notes: " + customerNotes);
        }
        if (customer != null) {
            System.out.println("Customer Info:\n" + customer);
        }
        System.out.printf("\nTotal (Including 15%% VAR): %.3f SAR.%n", calcTotal());
        System.out.println("Status: " + getStatus());
        System.out.println("                                             ");

    }

    public static int getNumberOfOrder() {
        return NumberOfOrder;
    }

    public void setNumberOfOrder(int NumberOfOrder) {
        Order.NumberOfOrder = NumberOfOrder;
    }

    public int getOrderNum() {
        return OrderNum;
    }

    public void setOrderNum(int OrderNum) {
        this.OrderNum = OrderNum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getTheDate() {
        return Thedate;
    }

    public void setTheDate(LocalDate Thedate) {
        this.Thedate = Thedate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerNotes() {
        return customerNotes;
    }

    public void setCustomerNotes(String customerNotes) {
        if (customerNotes !=("")) {
            this.customerNotes = customerNotes;
        }
    }

    public OrderItem[] getTheItems() {
        return TheItems;
    }

    public void setTheItems(OrderItem[] items) {
        this.TheItems = items;
    }

    public int getOrderNumOfLimit() {
        return OrderNumOfLimit;
    }

    public void setOrderNumOfLimit(int currentNumOfItems) {
        this.OrderNumOfLimit = currentNumOfItems;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}


