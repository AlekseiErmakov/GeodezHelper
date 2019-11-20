package com.example.geodezhelper;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.PortUnreachableException;
import java.util.ArrayList;

public class GeodezFileWriter {
    private TotalStationFile tsfile;
    String filename;
    private FileOutputStream writer;

    public GeodezFileWriter(TotalStationFile tsfile,String filename){
        this.tsfile = tsfile;
        this.filename = filename;
    }
    public void write()  {
        try {
            writer = new FileOutputStream(filename);
            ArrayList<String> res = tsfile.getResult();
            for (String s : res) {
                writer.write(s.getBytes());
                writer.write(System.lineSeparator().getBytes());
            }
            writer.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }


    }

}
