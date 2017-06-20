package com.red.innopolis;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        
        Path myPath =
                Paths.get("/Users/_red_/IdeaProjects/NewInputOutput/src/com/red/innopolis/test.txt");

        try {
            List<String> content = Files.readAllLines(myPath);
            System.out.println(content);
        } catch (Exception e) {}

        try {
            BufferedWriter bw = Files.newBufferedWriter(myPath,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.WRITE
            );
            bw.write("Bye");
            bw.flush();
            bw.close();
//            Path myPath2 = Files.createFile(secondFile, myFileAttribute);
            List<String> content = Files.readAllLines(myPath);
            System.out.println(content);
        } catch (Exception e) {}
    
    }
}
