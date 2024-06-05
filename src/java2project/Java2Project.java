/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2project;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mjd MAH
 */
public class Java2Project {

    /**
     * @param args the command line arguments
     */
    
        public static void main(String[] args) {
            
        Scanner READ = new Scanner(System.in);
        Resturant M =  yawnznrestaurant.getInstance();
        
        ArrayList<TheItem> I = new ArrayList<TheItem>();
       
        Burger B = new Burger( 'A' , true , 222 , "Burger" , "chicken" , 22.5 );
        Donut D = new Donut ("Strawberries" , 333 , "Donut" , "Dessert" , 5.5);
        Fresh F =new Fresh();
        HotChocolate HC = new HotChocolate();
        I.add(B); I.add(D); I.add(F); I.add(HC);
        
        int choice;
     
     try{
         do{
             display();
             choice=READ.nextInt();
             switch (choice){
                 case 1 : M.ShowMenu();
                 break;
                 case 2: M.makeOrder();
                   break;
                 case 3: M.CancelOrder();
                   break;
                     
                 case 4: M.TheBill();
                   break;
                 case 5: System.out.println("save data? :");
                 String answer=READ.next(); 
                         if (answer=="yes"){
                             M.SaveData();
                               break;   
                         }
                         System.out.print("thank you ");
                         break;
                 default:
                     System.out.println("invalied choice");
                 
             }
         }while (choice !=5);
     }catch (InputMismatchException ex){
         System.err.println("invalied input");
     }
    }
        
        
        
    public static void display(){
        System.out.println("-1.display menu \n"
                + "-2.new order\n"
                + "-3.cancle order\n"
                + "-4.print bill\n"
                + "-5.exist\n"
                + "                  " );
                
               }
    

}
    
    

    

