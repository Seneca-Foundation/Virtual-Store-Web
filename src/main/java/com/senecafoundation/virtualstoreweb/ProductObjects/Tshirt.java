package com.senecafoundation.virtualstoreweb.ProductObjects;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.senecafoundation.virtualstoreweb.FundamentalObjects.FileUploadItem;

@Entity
@Table(name = "tshirt")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tshirt extends FileUploadItem{
    private Integer width;
    private Integer length;      
    private String size;
    private String color;

    public Tshirt(String name, double price, String color, String description, double weight, Integer width, Integer length,
    String size) {
        super(name, price, description, weight);
        this.setWidth(width);
        this.setLength(length);
        this.setSize(size);
        this.setColor(color);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }
    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }
    public Tshirt(Integer width, Integer height, String paper, String color) {
        this.setWidth(width);
        this.setLength(length);
        this.setSize(size);
        this.setColor(color);
    }

    public Tshirt() {
        super();
    }
}