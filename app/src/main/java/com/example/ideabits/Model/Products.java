package com.example.ideabits.Model;

public class Products {
    private String Iname, description, price, image, category, pid, data, time;

    public Products()
    {

    }

    public Products(String Iname, String description, String image, String category, String pid, String data, String time) {
        this.Iname = Iname;
        this.description = description;

        this.image = image;
        this.category = category;
        this.pid = pid;
        this.data = data;
        this.time = time;
    }

    public String getIname() {
        return Iname;
    }

    public void setIname(String Iname) {
        this.Iname = Iname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
