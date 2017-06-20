package com.red.innopolis;

import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;
import java.io.*;
import java.nio.file.WatchService;
import java.util.*;

/**
 * Created by _red_ on 16.06.17.
 */
public class WatcherService {
    public static void main (String[] args) {
        for (; ; )
            try {
                WatchService watcher = FileSystems.getDefault().newWatchService();
        
                Path directory = Paths.get("/Users/_red_/IdeaProjects/WatchService/src/com/red/innopolis");
                try {
                    WatchKey key = directory.register(watcher, ENTRY_MODIFY);
                    while (true) {
                        key = watcher.take();
                        for (WatchEvent<?> event : key.pollEvents()) {
                            if (event.kind() == ENTRY_MODIFY) System.out.println("Files Modify!!!");
                        }
                        key.reset();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    }
}
