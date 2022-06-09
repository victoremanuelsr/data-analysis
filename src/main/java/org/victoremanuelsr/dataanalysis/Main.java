package org.victoremanuelsr.dataanalysis;

import org.apache.commons.io.FilenameUtils;
import org.victoremanuelsr.dataanalysis.services.DataAnalysisService;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        DataAnalysisService service = new DataAnalysisService();
        String path = System.getenv("HOME") + "//data//";
        Path inputFolder = Files.createDirectories(Paths.get(path + "in"));
        Path outputFolder = Files.createDirectories(Paths.get(path + "out"));
        WatchService watch = FileSystems.getDefault().newWatchService();
        inputFolder.register(watch, ENTRY_CREATE);
        while (true){
            WatchKey wk = watch.take();
            for(WatchEvent<?> event : wk.pollEvents()){
                if (event.kind() == OVERFLOW) continue;
                WatchEvent<Path> ev = (WatchEvent<Path>) event;
                Path file = ev.context();
                String fileName = FilenameUtils.getExtension(String.valueOf(file.getFileName()));
                if(fileName.equalsIgnoreCase("dat")){
                    Path way = inputFolder.resolve(file);
                    service.setPath(way.toString());
                    service.startDataAnalysis();
                }
            }
            if(!wk.reset()) break;
        }
    }
}