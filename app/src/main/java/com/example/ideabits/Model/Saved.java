package com.example.ideabits.Model;

public class Saved
{
    private String pid, pname,image,description;

    public Saved() {
    }

    public Saved(String pname, String pid, String description) {
        this.pname = pname;
        this.pid = pid;
        this.description = description;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
