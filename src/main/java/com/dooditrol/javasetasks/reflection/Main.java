package com.dooditrol.javasetasks.reflection;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Object[] arrayViews = {"Ssdsfs", new WrongView(), new ConsoleView(), new FileView()};
        List<ControllerOfView> controllers = new ArrayList<>();

        for (Object view : arrayViews) {

            try {
                ControllerOfView controller = new ControllerOfView(view);
                controllers.add(controller);
                System.out.println("ok");
            }
            catch (IllegalArgumentException ex) {
                System.err.println(ex.getMessage());
            }
        }

        for (ControllerOfView controller : controllers) {
            System.out.println("controller.display()");
            controller.display();
        }
    }
}
