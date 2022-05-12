package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;

    @Autowired
    Student(int id,String name, List<Phone> ph, Address add){
        this.id = id;
        this.name = name;
        this.ph = ph;
        this.add = add;
    }

    @Override
    public String toString() {
        return "Student name: " + name +
                ", id: " + id + '\n' +
                "Phone Number: " + ph + '\n' +
                "Address: " + add;
    }
}
