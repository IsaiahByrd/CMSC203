/*
 * Class: CMSC203 	
 * Instructor: Eivazi
 * Description: Class that represents an order
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Isaiah Byrd
*/

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface {

	private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer cust;
    private ArrayList<Beverage> beverage;
    
    //constructors
    public Order(int orderTime, Day orderDay, Customer cust) {
    	this.orderNo = generateOrder();
    	this.orderTime = orderTime;
    	this.orderDay = orderDay;
    	this.cust = cust;
    	this.beverage = new ArrayList<>();
    }

    //Methods
    public int generateOrder() {
    	 Random rand = new Random();
         // [10_000, 90_000)
         int randInt = rand.nextInt(90_000-10_000)+10_000;
         
         return randInt;
    }
    
    public int getOrderNo() {
        return orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }
    
    public Day getOrderDay() {
        return orderDay;
    }
    
    public Day getDay() {
    	return orderDay;
    }
    
    public Customer getCustomer() {
        return new Customer(cust);
    }
    
    public boolean isWeekend() {
        if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
                return true;
        }
        return false;
    }
    
    //getBeverage method
    @Override
    public Beverage getBeverage(int itemNo) {
        // Check if itemNo is within the valid range
        if (itemNo >= 0 && itemNo < beverage.size()) {
            // Return a shallow copy of the Beverage at the specified itemNo
            return this.beverage.get(itemNo);
        } else {
            // Return null if itemNo is out of range
            return null;
        }
    }

    public int getTotalItems() {
        return beverage.size();
    }
    
    //add coffee
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Coffee s = new Coffee(bevName, size, extraShot, extraSyrup);
        beverage.add(s);
    }
    
    //add alcohol
    public void addNewBeverage(String name, Size size) {
        boolean isWeekend = false;
        if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
                isWeekend = true;
        }
        Alcohol a = new Alcohol(name, size, isWeekend);
        beverage.add(a);
    }
    
    //add smoothie
    public void addNewBeverage(String name, Size size, int numOfFruits, boolean proteinPowder) {
        Smoothie s = new Smoothie(name, size, numOfFruits, proteinPowder);
        beverage.add(s);
    }
    
    public double calcOrderTotal() {
        double orderTotal = 0.0;
        
        for (Beverage b : beverage) {
                orderTotal += b.calcPrice();
        }
        
        return orderTotal;
    }
    
    public int findNumOfBeveType(Type type) {
        int count = 0;
        
        for (Beverage b : beverage) {
                if (b.getType() == type) {
                        count++;
                }
        }
        return count;
    }
    
    public ArrayList<Beverage> getBeverages() {
        return beverage;
    }
    
    //toString method
    @Override
    public String toString() {
        String s = orderDay.toString() + ", " + orderTime
                           + "\n" + cust.toString() + " Order Num: " + orderNo;
        
        for (Beverage b : beverage) {
                s += "\n" +b.toString();
        }
        s += "\n Order Total: " +calcOrderTotal();
        
        return s;
    }
    
    public int compareTo(Order anotherOrder) {
        if (orderNo == anotherOrder.getOrderNo()) {
                return 0;
        }
        else if (orderNo > anotherOrder.getOrderNo()) {
                return 1;
        }
        else {
                return -1;
        }
    }

}
