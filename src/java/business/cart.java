/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Dinesh
 */
public class cart {
    private ArrayList<order> orders;
    
    public cart() {
        orders = new ArrayList<order>();
    }

    public ArrayList<order> getOrders() {
        return orders;
    }
    
    public order getOrder(int id){        
        for (order ord : orders) {
            if (ord.getP().getId() == id) {
                return ord;
            }
        }        
        return null;
    }
    
    public double getCost(){
        double cost = 0;
        for (order ord : orders) {
            cost += ord.getCost();
        }
        return cost;
    }
    
    public void clear(){
        while (!orders.isEmpty()) {            
            orders.remove(0);
        }
    }
    
    public void add(product p){
        for (order or : orders) {
            product po = or.getP();
            if (p.equals(po)) {
                or.setQuantity(or.getQuantity() + 1);
                return ;
            }
        }
        orders.add(new order(p, 1));        
    }    
    
    public void edit(product p, int quantity){
        if (quantity < 0) {
            remove(p);
        }
        for (order or : orders) {
            product po = or.getP();
            if (p.equals(po)) {
                or.setQuantity(quantity);
                return;
            }
        }
    }
    
    public  void remove(product p){
        orders.remove(new order(p, 1));
    }
        
    
}
