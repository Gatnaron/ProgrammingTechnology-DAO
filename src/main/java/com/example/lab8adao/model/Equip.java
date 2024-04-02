package com.example.lab8adao.model;

import lombok.Data;

@Data

public class Equip {
    public int id;
    public String name;
    public String status;

    public Equip(int id, String name, String status) {
        this.id = id; this.name = name; this.status = status;
    }
    public Equip(String name, String status) {
        this.name = name; this.status = status;
    }
    @Override
    public String toString(){
        return id + " " + name + " " + status;
    }
}
