package com.project.babynaming.Entity;

import javax.persistence.*;

@Entity
@Table
public class adminfood {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String foodname;
    private String imageurl;
    private String category;
    private String price;

    public adminfood(Long id, String foodname, String imageurl, String category, String price) {
        this.id = id;
        this.foodname = foodname;
        this.imageurl = imageurl;
        this.category = category;
        this.price = price;
    }

    public adminfood() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
