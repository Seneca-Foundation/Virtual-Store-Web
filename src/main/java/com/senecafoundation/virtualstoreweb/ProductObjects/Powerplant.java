package com.senecafoundation.virtualstoreweb.ProductObjects;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.senecafoundation.virtualstoreweb.ITextFormatter;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.WeightItem;

public class Powerplant extends WeightItem

{
    public Powerplant(String name, double price,  String description, double weight) 
    {
        super(name,price,description, weight);
    }
    public Powerplant() {
        super();
    }

    public String GetData(ITextFormatter userTextFormatter){
        this.textFormatter = userTextFormatter;
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        return "Product: " + this.getName() + ", Price: $" + df.format(this.textFormatter.getPrice()) + ", Weight:" + weight + ", Item Number: " + getID();
    }  
    public String WhatItPowers() {
        String[] parts = this.getName().split("k");
        String amount = parts[0];
        int amountInkWh = Integer.parseInt(amount);
        System.out.println("With this amount of energy, you can power: ");
        if (amountInkWh > 380)
        {
            return "An electric water heater for a month";
        }
        if (amountInkWh >= 100)
        {
            return "A refrigerator for two months";
        }
        if (amountInkWh >= 54) {
            return "A Nissan Leaf Electric Car, clothes washer";
        }
        else
        {
            return "50\" LED television for many hours";
        }
    
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "," + this.getID() + "," + this.getName() + "," + String.valueOf(this.getPrice()) + "," + this.getDescription() +"," +this.getWeight();
    }

}
