package com.dooditrol.javasetasks.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ControllerOfView {

    private Object view;
    private Method methodShow;

    public ControllerOfView(Object view)
            throws IllegalArgumentException {

        Class<?> viewType = view.getClass();

        if (viewType.getAnnotation(View.class) != null) {
            Method[] methods = viewType.getMethods();

            for (Method method : methods) {

                if (method.getAnnotation(Show.class) != null) {
                    this.view = view;
                    this.methodShow = method;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("argument isn't View");
    }

    public void display() {

        if (!methodShow.getAnnotation(Show.class).isStdout()) {
            System.out.println("Not stdout");
        }

        try {
            methodShow.invoke(view);
        }
        catch (IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
