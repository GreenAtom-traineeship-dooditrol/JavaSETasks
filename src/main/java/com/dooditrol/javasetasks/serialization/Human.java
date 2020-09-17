package com.dooditrol.javasetasks.serialization;

import java.io.Serializable;

public class Human implements Serializable {

    private static final long serialVersionUID = 5454654465465451888L;
    private String name;
    private int age;
    private transient Occupation occupation;

    public Human(String name, int age) {
        this.name = name;
        this.age = (age < 0) ? 0 : age;
        setOccupation();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setOccupation() {

        if (age < 3) {
            this.occupation = Occupation.STAYS_AT_HOME;
        }
        else if (age < 7) {
            this.occupation = Occupation.KINDERGARTNER;
        }
        else if (age < 18) {
            this.occupation = Occupation.SCHOOLBOY;
        }
        else if (age < 23) {
            this.occupation = Occupation.STUDENT;
        }
        else if (age < 65) {
            this.occupation = Occupation.WORKING;
        }
        else {
            this.occupation = Occupation.RETIREE;
        }
    }

    public Occupation getOccupation() {
        return occupation;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ":\n"
                + "\tName: " + name + "\n"
                + "\tAge: " + age + "\n"
                + "\tOccupation:" + occupation + "\n";
    }

    public enum Occupation {
        STAYS_AT_HOME,
        KINDERGARTNER,
        SCHOOLBOY,
        STUDENT,
        WORKING,
        RETIREE
    }
}
