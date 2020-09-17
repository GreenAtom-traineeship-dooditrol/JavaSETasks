package com.dooditrol.javasetasks.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Human> people = new ArrayList<>();
        Collections.addAll(people,
                new Human("Pasha", 5),
                new Human("Sasha", 19),
                new Human("Masha", 66));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("humans.dat"))) {

            for (Human human : people) {
                oos.writeObject(human);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("serialization successful");


        System.out.println("deserialization from file humans.dat");

        try (FileInputStream fis = new FileInputStream("humans.dat");
                ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (fis.available() > 0) {
                Human human = (Human) ois.readObject();
                human.setOccupation();
                System.out.println(human);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
