package org.genspark;

import org.springframework.beans.factory.annotation.Autowired;

public class Phone {
    private String mob;

    @Autowired
    public void setMob(String mob) {this.mob = mob;}

    @Override
    public String toString() {
        return "Phone: " +
                "mobile-" + mob;
    }
}
