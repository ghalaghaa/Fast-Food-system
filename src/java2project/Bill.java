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
public class Bill implements Payable, printable {
    
    private static int Bills;
    private int serialNum;
    
    public Bill() {
        serialNum = ++Bills;
    }

    public static int getBills() {
        return Bills;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public static void setBills(int Bills) {
        Bill.Bills = Bills;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }
    
    @Override
    public boolean pay(double Howmuch) {

        System.out.println(Howmuch + " SAR. has been paid successfully.");
        return true;
    }
    
    @Override
    public void printable(Order order) {

        System.out.println("Your order Number is: " + getSerialNum());
        Order O = new Order();
        O.currentOrderInfo();

    }

}

