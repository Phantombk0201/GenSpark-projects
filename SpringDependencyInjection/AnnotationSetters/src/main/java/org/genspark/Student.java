package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private int id;
    private String name;
    private List<Phone> ph;
    private Address add;

    @Autowired
    public void setId(int id) {this.id = id;}

    @Autowired
    @Qualifier("name")
    public void setName(String name) {this.name = name;}

    @Autowired
    public void setPh(List<Phone> ph) {this.ph = ph;}

    @Autowired
    public void setAdd(Address add) {this.add = add;}

    @Override
    public String toString() {
        return "Student name: " + name +
                ", id: " + id + '\n' +
                "Phone Number: " + ph + '\n' +
                "Address: " + add;
    }
}
