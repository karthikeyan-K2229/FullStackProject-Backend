package com.project.babynaming.Entity;


import javax.persistence.*;

@Entity
@Table
public class themeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long themeid;
    private String themeName;
    private String imageUrl;
    private String  photographerDetails;
    private String videographerDetails;
    private String returnGift;
    private String themeCost;
    private String themeDiscription;

    public themeModel() {
    }

    public themeModel(Long themeid, String themeName, String imageUrl, String photographerDetails, String videographerDetails, String returnGift, String themeCost, String themeDiscription) {
        this.themeid = themeid;
        this.themeName = themeName;
        this.imageUrl = imageUrl;
        this.photographerDetails = photographerDetails;
        this.videographerDetails = videographerDetails;
        this.returnGift = returnGift;
        this.themeCost = themeCost;
        this.themeDiscription = themeDiscription;
    }

    public Long getThemeid() {
        return themeid;
    }

    public void setThemeid(Long themeid) {
        this.themeid = themeid;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPhotographerDetails() {
        return photographerDetails;
    }

    public void setPhotographerDetails(String photographerDetails) {
        this.photographerDetails = photographerDetails;
    }

    public String getVideographerDetails() {
        return videographerDetails;
    }

    public void setVideographerDetails(String videographerDetails) {
        this.videographerDetails = videographerDetails;
    }

    public String getReturnGift() {
        return returnGift;
    }

    public void setReturnGift(String returnGift) {
        this.returnGift = returnGift;
    }

    public String getThemeCost() {
        return themeCost;
    }

    public void setThemeCost(String themeCost) {
        this.themeCost = themeCost;
    }

    public String getThemeDiscription() {
        return themeDiscription;
    }

    public void setThemeDiscription(String themeDiscription) {
        this.themeDiscription = themeDiscription;
    }
}
