/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;

/**
 *
 * @author awarsyle
 */
public class Item implements Serializable {

    private String itemName;

    public Item() {
    }

    
    public Item(String itemName) {
        this.itemName = itemName;
    }

    
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


}