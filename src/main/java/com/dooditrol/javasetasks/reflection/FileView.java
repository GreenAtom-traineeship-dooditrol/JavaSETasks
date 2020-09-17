package com.dooditrol.javasetasks.reflection;

import java.io.FileWriter;
import java.io.IOException;

@View
public class FileView {

    @Show(isStdout = false)
    public void printToFile() {

        try(FileWriter writer = new FileWriter("out.txt", true)) {
            writer.write("something print\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
