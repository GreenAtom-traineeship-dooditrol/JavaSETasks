package com.dooditrol.javasetasks.multithreading;

public class AsynchronousMessages extends Thread {

    private String strOne;
    private String strTwo;

    public AsynchronousMessages(String name, String strOne, String strTwo) {
        super(name);
        this.strOne = strOne;
        this.strTwo = strTwo;
    }

    @Override
    public void run() {

        while (!isInterrupted()) {

            try {
                System.out.println(strOne);
                sleep(5_000);
                System.out.println(strTwo);
                sleep(10_000);
            }
            catch (InterruptedException ex) {
                interrupt();
            }
        }
        System.out.println(getName() + " finished");
    }
}
