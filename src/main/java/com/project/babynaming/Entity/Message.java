package com.project.babynaming.Entity;


import java.util.ArrayList;
import java.util.List;

public class Message {
    private String message = "";
    private List<Food> add_on = new ArrayList<Food>();
    //private Object=new Object();
    private String error = "";
    public Object HttpStatus;

    public Message(String message, List<Food> add_on, String error) {
        this.message = message;
        this.add_on = add_on;
        this.error = error;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Food> getFoods(){
        return add_on;
    }

    public void setFoods(ArrayList<Food> foods) {

        this.add_on = foods;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return this.error;
    }
}


