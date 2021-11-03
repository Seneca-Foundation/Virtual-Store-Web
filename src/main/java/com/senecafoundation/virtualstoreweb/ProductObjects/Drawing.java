package com.senecafoundation.virtualstoreweb.ProductObjects;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.senecafoundation.virtualstoreweb.FundamentalObjects.WeightItem;

@Entity
@Table(name = "Drawing")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Drawing extends WeightItem{
    private Integer width;
    private Integer height;      
    private String paper;
    private String color;

    public Drawing(String name, double price, String description, double weight, Integer width, Integer height,
    String paper, String color) {
        super(name, price, description, weight);
        this.setWidth(width);
        this.setHeight(height);
        this.setPaper(paper);
        this.setColor(color);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getPaper() {
        return paper;
    }
    public void setPaper(String paper) {
        this.paper = paper;
    }
    public Integer getHeight() {
        return height;
    }
    public void setHeight(Integer height) {
        this.height = height;
    }
    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }
    public Drawing(Integer width, Integer height, String paper, String color) {
        this.setWidth(width);
        this.setHeight(height);
        this.setPaper(paper);
        this.setColor(color);
    }

    public Drawing() {};

    
}

