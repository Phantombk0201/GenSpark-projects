package org.genspark;

public class Phone {
    private String mob;

    Phone(String mob){
        this.mob = mob;
    }

    @Override
    public String toString() {
        return "Phone: " +
                "mobile-" + mob;
    }
}
