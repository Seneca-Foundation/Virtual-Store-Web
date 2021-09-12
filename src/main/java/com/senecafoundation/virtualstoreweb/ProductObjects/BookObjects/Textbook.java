package com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects;

import java.util.ArrayList;
import java.util.List;

public class Textbook extends Book 
{
    protected List<String> authors = new ArrayList<String>();

    public Textbook(String name, double price, String author, String cover, String description, List<String> authors, double weight) {
        ////inherited name, price, description, weight, itemNum, author, cover
        super(name, price, author, cover, description, weight);
        this.authors = authors;
    }
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public String GetData() {

        return "Title: " + name + ", Price: $" + this.textFormatter.getPrice() + ", Authors: " + String.join(",", authors) + ", Cover: " + cover + ", Weight: " + weight + ", Item Number: " + getID();
        
    }
    @Override 
    public String toString() {
        return this.getClass().getSimpleName() + "," + this.getID() + "," + this.getName() + "," + String.valueOf(this.getPrice()) + "," + this.getAuthor() + "," + this.getCover() + "," +this.getDescription() + "," + this.getAuthors() + "," + this.getWeight();
    }
}
