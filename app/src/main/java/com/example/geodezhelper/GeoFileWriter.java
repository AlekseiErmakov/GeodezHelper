package com.example.geodezhelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GeoFileWriter {
    private FileTotalStation tsfile;
    String filename;
    private FileOutputStream writer;

    public GeoFileWriter(FileTotalStation tsfile, String filename){
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
