package com.dooditrol.javasetasks.multithreading;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        AsynchronousMessages printerAsyncMes = new AsynchronousMessages("printer"
                ,"Асинхронный привет!", "Асинхронный пока!");
        ControllerOfExit exit = new ControllerOfExit("exitOne",
                Arrays.asList(printerAsyncMes, Thread.currentThread()));
        exit.start();
        printerAsyncMes.start();

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Работает основная программа");

            try {
                Thread.sleep(1_000);
            }
            catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
