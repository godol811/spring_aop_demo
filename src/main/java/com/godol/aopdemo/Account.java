package com.godol.aopdemo;

public class Account {


    private String name;
    private String level;

    public Account(){

    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "계정[" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                ']';
    }
}
