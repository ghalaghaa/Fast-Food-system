/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mjd MAH
 */
public class yawnznrestaurant implements Resturant {

    private static Resturant instance;
    Scanner READ = new Scanner(System.in);
    Order[] orders;
    ArrayList<TheItem> thingslist = new ArrayList<TheItem>();
    private int numOfOrders;

    public yawnznrestaurant() {
    ReadFile();
    }

    public static Resturant getInstance() {
        if (instance == null) {
            instance = new yawnznrestaurant();
        }
        return instance;
    }

    @Override
    public TheItem getItemByserialNum(int serialNum) {
        for (TheItem things : thingslist) {
            if (TheItem.getNumberOfItems() == serialNum) {
                return things;
            }
        }
        return null;
    }

    @Override
    public void ShowMenu() {
         System.out.println("yawnzn restaurant menu is as following: \n"
                + " 1-burger For 25SR \n"
                + " 2-Dount For 5SR \n"
                + " 3-Hot chocolate For 18SR \n"
                + " 4-Fresh juice For 15SR \n"
                + " 5-Soda For 3SR");
    }

    @Override
    public void makeOrder() {

        Order order = new Order();
        ShowMenu();
        int YC;
        try {
            do {
                System.out.print("1. Add new order 2.continue");
                YC = READ.nextInt();
                switch (YC) {
                    case 1:
                        System.out.println("Enter serialNum of the food you want: ");
                        int serialNum = READ.nextInt();
                        System.out.print("How many of that do you want? ");
                        int NummerOfItem = READ.nextInt();
                        OrderItem orderItem = new OrderItem(serialNum, NummerOfItem);
                        if (order.addItem(orderItem)) {
                            System.out.println("your Item has been added to the bill ");
                        } else {
                            System.out.println("Error, operation failed");
                        }
                        order.currentOrderInfo();
                        break;

                    case 2:
                        System.out.println("Enter your Name, phone number and your address");

                        System.out.print("Your Name: ");
                        String customerName = READ.nextLine();

                        System.out.print("Phone Number: ");
                        String phonenum = READ.nextLine();

                        System.out.print("City name: ");
                        String City = READ.nextLine();

                        System.out.print("Street name: ");
                        String Street = READ.nextLine();

                        System.out.print("House number: ");
                        int HouseNum = READ.nextInt();

                        Customer customer = new Customer(customerName, phonenum, new Address(City, Street, HouseNum));
                        order.setCustomer(customer);
                        break;
                    default:
                        System.out.println("Invalid Option.");
                }

            } while (YC != 2);
            System.out.print("Do you want to add notes? \n"
                    + "1.Yes 2.No, End of the order");
            YC = READ.nextInt();
            String CusNote = "";
            if (YC == 1) {
                System.out.println("write your note: ");
            }
            CusNote = READ.nextLine();
            order.setCustomerNotes(CusNote);
            order.placeOrder();

            System.out.println("Thank you for ordring from Yawnzn restaurant we have your order and will tell you once it is ready");
        } catch (InputMismatchException ex) {
            System.out.println("Invalid Input, Try again");
        }

        int index = Order.getNumberOfOrder() - 1;
        orders[index] = order;
        numOfOrders++;
    }

    @Override
    public void CancelOrder() {

        System.out.println("Enter order Number: ");

        try {

            int orderNUM = READ.nextInt();

            for (int i = 0; i < orders.length; i++) {
                Order order = orders[i];
                if (order != null) {
                    if (order.getOrderNum() == orderNUM) {
                        order.cancel();
                        System.out.println("The order has been cancelled");
                        return;
                    }

                }

            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid Input, Try again");
        }
        System.out.println("there is no order with this serialNum ");

    }

    @Override
    public void TheBill() {

        System.out.println("Enter order Number: ");

        try {
            int orderNUM = READ.nextInt();

            for (int i = 0; i < orders.length; i++) {
                Order order = orders[i];
                if (order != null) {
                    if (order.getNumberOfOrder() == orderNUM) {
                        order.getBill().printable(order);
                        System.out.println("Your bill is printed");
                        return;
                    }

                }

            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid Input, Try again");
        }
        System.out.println("Order with this serialNum not found.");

    }

    @Override
    public ArrayList<TheItem> getthingslist() {
        return thingslist;
    }

    public void addOrder(Order order) {
        if (numOfOrders >= orders.length) {
            System.out.println("Can't add more orders");
        } else {
            orders[numOfOrders] = order;
            numOfOrders++;
        }
    }

    @Override
    public void ReadFile() {
        ObjectInputStream I = null;
        try {
            System.out.println("Reading from file");
            I = new ObjectInputStream(new FileInputStream(new File("items.ser")));

            while (true) {
                try {
                    TheItem item = (TheItem) I.readObject();
                    thingslist.add(item);
                } catch (EOFException ex) {
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error, File dose not exist " + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("Error: Can not read that " + ex);
        } catch (ClassNotFoundException ex) {
            System.err.println("Error: class not found " + ex.getMessage());
        } finally {
            if (I != null) {
                try {
                    I.close();
                } catch (IOException ex) {
                    System.out.println("Error during closing ");
                }
            }
        }
    }

    @Override
    public void SaveData() {
        ObjectOutputStream I = null;
        try {
            I = new ObjectOutputStream(new FileOutputStream(new File("items.ser")));

            for (TheItem A : thingslist) {
                I.writeObject(A.toString());
            }
            System.out.println("data saved");
        } catch (FileNotFoundException ex) {
            System.err.println("Error, File dose not exist ");
        } catch (IOException ex) {
            System.err.println("Error, Can't save data.");
        } finally {
            if (I != null) {
                try {
                    I.close();
                } catch (IOException ex) {
                    System.out.println("Error during closing stream");
                }
            }
        }
    }

    public void readOrders(String fileName) {

        ReadOrder reader = new ReadOrder();
        reader.openFile(fileName);
        ArrayList<Order> orderList = reader.readOrders();

        for (Order order : orderList) {
            addOrder(order);
        }

        reader.closeFile();
    }

    public void saveOrders(String fileName) {

        WriteOrder writer = new WriteOrder();
        writer.openFile(fileName);
        for (Order order : orders) {
            if (order != null) {
                writer.saveOrder(order);
            }
        }
        writer.closeFile();
    }

    public void readProducts(String fileName) {
        ReadItem reader = new ReadItem();
        reader.openFile(fileName);
        thingslist = reader.readProducts();
        reader.closeFile();
    }

    public void saveProduct(TheItem p, String fileName) {

        WriteItem writer = new WriteItem();
        writer.openFile(fileName);
        writer.saveProduct(p);
        writer.closeFile();
    }

}
