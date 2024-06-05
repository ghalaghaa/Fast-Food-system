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
public class Address {
    private String city;
    private String street;
    private int houseNum;

    public Address() {
        this("", "", 0);
    }

    public Address(String city, String street, int houseNum) {
        this.city = city;
        this.street = street;
        this.houseNum = houseNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(int houseNum) {
        this.houseNum = houseNum;
    }

    @Override
    public String toString() {
        return String.format("City: %s\nStreet: %s\nHouse Number: %d", getCity(), getStreet(), getHouseNum());
    }

}