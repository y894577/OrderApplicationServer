package com.server.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Goods {
    @Id
    private String ID;
    private String name;
    private float price;
    private String tag;

    public Goods(String ID, String name, float price, String tag) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.tag = tag;
    }

    public Goods() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
