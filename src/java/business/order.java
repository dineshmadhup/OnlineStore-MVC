/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Dinesh
 */
public class order {
    private product p;
    private int quantity;
       

    public order(product p, int quantity) {
        this.p = p;
        this.quantity = quantity;
    }

    public product getP() {
        return p;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public double getCost(){
        return (double) quantity * p.getPrice();
    }    

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) 
            return false;
        if (o instanceof order) {
            order or = (order) o;
            if (or.p.equals(p)) 
                return true;            
        }
        return false;
    }
    
    
}
