package com.dooditrol.javasetasks.exceptions;

public class ExceptionMaxCountElement extends Exception {

    public ExceptionMaxCountElement() {

    }

    public ExceptionMaxCountElement(String message) {
        super(message);
    }

    @Override
    public String getMessage() {

        if (super.getMessage() == null) {
            return "MyArrayList contains max elements";
        }
        else {
            return super.getMessage();
        }
    }

    @Override
    public String getLocalizedMessage() {
        return "exception for add operation to " + MyArrayList.class;
    }

    @Override
    public String toString() {
        String result = getClass().getSimpleName();
        result += " : " + getLocalizedMessage();

        return result;
    }

    @Override
    public void printStackTrace() {
        for (StackTraceElement ste : getStackTrace()) {
            System.err.println(ste.getMethodName());
        }
    }
}
