package com.dooditrol.javasetasks.multithreading;

import java.util.List;
import java.util.Scanner;

public class ControllerOfExit extends Thread {

    private List<Thread> threads;

    public ControllerOfExit(String name, List<Thread> threads) {
        super(name);
        this.threads = threads;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
