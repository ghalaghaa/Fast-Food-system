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
public class Date {
    private int Day;
    private int month ; 
    private int year ;

    public Date(int Day, int month, int year) {
        this.Day = Day;
        this.month = month;
        this.year = year;
    }

    public Date() {
    }

    public int getDay() {
        return Day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int Day) {
        this.Day = Day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Date " + "Day:" + Day + "\n month=" + month + "\nyear: " + year;
    }
  

}