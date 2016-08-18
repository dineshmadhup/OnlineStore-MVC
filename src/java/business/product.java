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
public class product {
    private int id;
    private String name;
    private String link;
    private double price;

    public product(int id, String name, String link, double price) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) 
            return false;
        if (o instanceof product) {
            product p = (product) o;
            if (p.id == id) 
                return true;            
        }
        return false;
    }    
}
